package Server;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        try {
            Server server = new Server(8011);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
