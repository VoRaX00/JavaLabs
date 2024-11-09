import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket socket = null;
    BufferedReader in = null;
    BufferedWriter out = null;

    public Client() throws IOException {
        String host = "localhost";
        int port = 8011;
        socket = new Socket(host, port);
    }
}
