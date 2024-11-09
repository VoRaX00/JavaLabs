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
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(current.getInputStream()));
            while (true) {
                String message = in.readLine();
                if (!SendMessage(message, in)) {
                    clients.remove(current);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean SendMessage(String message, BufferedReader in) throws IOException {
        List<BufferedWriter> out = new ArrayList<>();
        for (Socket socket : clients) {
            if (socket != current) {
                out.add(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            }
        }

        for (BufferedWriter writer : out) {
            writer.write("Client #" + clientId + ": "+ message);
            writer.newLine();
            writer.flush();
        }

        if (message.equals("BYE")) {
            for (BufferedWriter writer : out) {
                writer.write("BYE");
                writer.newLine();
                writer.flush();
            }
            return false;
        }
        return true;
    }
}
