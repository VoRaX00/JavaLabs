package Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private final Scanner in;
    private final PrintWriter out;
    private final Scanner send;
    private volatile boolean isRunning;

    public Client() throws IOException {
        String host = "localhost";
        int port = 8011;
        socket = new Socket(host, port);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        send = new Scanner(System.in);
        isRunning = true;
    }

    public void start() {
        new Thread(this::receiveMessages).start();
        try {
            while (isRunning) {
                String line = send.nextLine();
                out.println(line);

                if ("BYE".equalsIgnoreCase(line)) {
                    isRunning = false;
                    break;
                }
            }
        } finally {
            closeResource();
        }
    }

    private void receiveMessages() {
        try {
            while (isRunning && in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            if (isRunning) {
                System.out.println("Connection error");
            }
            e.printStackTrace();
        } finally {
            isRunning = false;
            closeResource();
        }
    }

    private void closeResource() {
        isRunning = false;
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (send != null) {
                send.close();
            }
        } catch (Exception e) {
            System.out.println("Connection error");
        }
    }
}
