package lekciya1.server;
import java.io.*;
import java.net.Socket;

public class Client {
    private final String account;
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

    public Client(String account) {
        this.account = account;
    }

    public void connectToServer(String ipAddress, int port) {
        try {
            socket = new Socket(ipAddress, port);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to server");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to server");
        }
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    public void sendMessage(String message) {
        try {
            writer.write(account + ": " + message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to send message");
        }
    }
}
