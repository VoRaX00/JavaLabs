package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Server {
    private final ServerSocket serverSocket;
    private final List<Socket> clients;
    private int clientNumber;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientNumber = 0;
        clients = Collections.synchronizedList(new ArrayList<>());
    }

    public void start() throws IOException {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                new ServiceThread(clientNumber++, socket, clients).start();
            }
        } finally {
            serverSocket.close();
        }
    }
}
