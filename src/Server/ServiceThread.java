package Server;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServiceThread extends Thread {
    private final int clientId;
    private final Socket current;
    private final List<Socket> clients;

    public ServiceThread(int clientId, Socket current, List<Socket> clients) {
        this.clientId = clientId;
        this.current = current;
        this.clients = clients;

        System.out.println("New connection with clientId: " + clientId);
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(current.getInputStream()));) {
            String message;
            while ((message = in.readLine()) != null) {
                if (!SendMessage(message, in)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clients.remove(current);
                current.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean SendMessage(String message, BufferedReader in) throws IOException {
        synchronized (clients) {
            for (Socket socket : clients) {
                if (socket != current) {
                    try {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        writer.write("Client.Client #" + clientId + ": " + message);
                        writer.newLine();
                        writer.flush();
                    } catch (IOException e) {
                        System.out.println("Error sending message to a client: " + e.getMessage());
                    }
                }
            }
        }

        if (message.equals("BYE")) {
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(current.getOutputStream()));
                writer.write("BYE");
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                System.out.println("Error sending BYE message to client #" + clientId + ": " + e.getMessage());
            }
            return false;
        }
        return true;
    }
}
