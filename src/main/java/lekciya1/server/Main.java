package lekciya1.server;


import lekciya1.server.lessonServer.client.Client;

public class Main {
        public static void main(String[] args) {
            Server server=new Server();
            new Client(server,"Dimon","12345");
            new Client(server,"Tolyan","12345");
        }
    }