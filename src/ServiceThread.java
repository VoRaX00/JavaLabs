import java.io.*;
import java.net.Socket;
import java.security.Provider;

public class ServiceThread extends Thread {
    private int clientId;
    private Socket socketOfServer;

    public ServiceThread(int clientId, Socket socketOfServer) {
        this.clientId = clientId;
        this.socketOfServer = socketOfServer;

        System.out.println("New connection with clientId: " + clientId);
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));

            while (true) {
                String message = in.readLine();
                out.write(message);
                out.newLine();
                out.flush();

                if (message.equals("BYE")) {
                    out.write("BYE");
                    out.newLine();
                    out.flush();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
