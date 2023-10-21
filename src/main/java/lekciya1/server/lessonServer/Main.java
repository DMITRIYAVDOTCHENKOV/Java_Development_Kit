package lekciya1.server.lessonServer;


import lekciya1.server.lessonServer.client.Client;
import lekciya1.server.lessonServer.server.Server;

public class Main {
    public static void main(String[] args) {
        Server serverWindow = new Server();
        new Client(serverWindow, "ff", "23" );
    }
}
