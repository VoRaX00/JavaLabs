import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;
    private int clientNumber;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientNumber = 0;
    }

    public void start() throws IOException {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                new ServiceThread(clientNumber, socket).start();
            }
        } finally {
            serverSocket.close();
        }
    }
}
