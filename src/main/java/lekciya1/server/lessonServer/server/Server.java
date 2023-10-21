package lekciya1.server.lessonServer.server;//package lekciya1.server.lessonServer.server;
//
//
//import lekciya1.server.lessonServer.client.Client;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//public class Server {
//    public static final int WIDTH = 400;
//    public static final int HEIGHT = 300;
//    public static final String LOG_PATH = "src/server/log.txt";
//
//    private final List<Client> clientList;
//    private final JButton btnStart;
//    private final JButton btnStop;
//    private final JTextArea log;
//    private boolean work;
//
//    public Server() {
//        clientList = new ArrayList<>();
//
//        JFrame serverWindow = new JFrame();
//        serverWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        serverWindow.setSize(WIDTH, HEIGHT);
//        serverWindow.setResizable(false);
//        serverWindow.setTitle("Chat server");
//        serverWindow.setLocationRelativeTo(null);
//
//        log = new JTextArea();
//        serverWindow.add(log);
//        serverWindow.add(createButtonPanel(), BorderLayout.SOUTH);
//
//        btnStart = new JButton("Start");
//        btnStop = new JButton("Stop");
//
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (work) {
//                    appendLog("Сервер уже был запущен");
//                } else {
//                    work = true;
//                    appendLog("Сервер запущен!");
//                }
//            }
//        });
//
//        btnStop.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!work) {
//                    appendLog("Сервер уже был остановлен");
//                } else {
//                    work = false;
//                    sendServerShutdownMessage();
//                    for (Client clientGUI : clientList) {
//                        disconnectUser(clientGUI);
//                    }
//                    appendLog("Сервер остановлен!");
//                }
//            }
//        });
//
//        serverWindow.setVisible(true);
//    }
//
//    public boolean connectUser(Client client) {
//        if (!work) {
//            return false;
//        }
//        clientList.add(client);
//        return true;
//    }
//
//    public String getHistory() {
//        return readLog();
//    }
//
//    public void disconnectUser(Client client) {
//        clientList.remove(client);
//        if (client != null) {
//            client.disconnectFromServer();
//        }
//    }
//
//    public void sendMessage(String text) {
//        if (!work) {
//            return;
//        }
//        appendLog(text);
//        answerAll(text);
//        saveInLog(text);
//    }
//
//    private void answerAll(String text) {
//        for (ClientGUI clientGUI : clientGUIList) {
//            clientGUI.answer(text);
//        }
//    }
//
//    private void saveInLog(String text) {
//        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
//            writer.write(text);
//            writer.write("\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String readLog() {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (FileReader reader = new FileReader(LOG_PATH)) {
//            int c;
//            while ((c = reader.read()) != -1) {
//                stringBuilder.append((char) c);
//            }
//            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//            return stringBuilder.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private void appendLog(String text) {
//        log.append(text + "\n");
//    }
//
//    private JPanel createButtonPanel() {
//        JPanel panel = new JPanel(new GridLayout(1, 2));
//        panel.add(btnStart);
//        panel.add(btnStop);
//        return panel;
//    }
//    private void sendServerShutdownMessage() {
//        String shutdownMessage = "Server is shutting down!";
//        answerAll(shutdownMessage);
//        saveInLog(shutdownMessage);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new Server();
//            }
//        });
//    }
//}


import lekciya1.server.lessonServer.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    public static void main(String[] args) {
        Server server = new Server();
        server.setup(); // метод для установки сервера
        server.start(); // метод для запуска сервера
    }

    private void start() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                String response = processInput(inputLine);
                out.println(response);
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processInput(String input) {

        String response = "";

        if (input.equals("Привет")) {
            response = "Привет!";
        } else if (input.equals("Как дела?")) {
            response = "Хорошо, спасибо!";
        } else {
            response = "Не могу понять, что вы сказали.";
        }

        return response;
    }


    private void setup() {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Сервер запущен");
            clientSocket = serverSocket.accept();
            System.out.println("Подключен клиент");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final String LOG_PATH = "src/server/log.txt";

    private final List<Client> clientList;
//    private final JButton btnStart;
//    private final JButton btnStop;
    private final JTextArea log;
    private boolean work;
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    public Server() {
        

        clientList = new ArrayList<>();

        JFrame serverWindow = new JFrame();
        serverWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverWindow.setSize(WIDTH, HEIGHT);
        serverWindow.setResizable(false);
        serverWindow.setTitle("Chat server");
        serverWindow.setLocationRelativeTo(null);

        log = new JTextArea();
        serverWindow.add(log);
        serverWindow.add(createButtonPanel(), BorderLayout.SOUTH);

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (work) {
                    appendLog("Сервер уже был запущен");
                } else {
                    work = true;
                    appendLog("Сервер запущен!");
                    setup();
                    start();
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!work) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    work = false;
                    sendServerShutdownMessage();
                    for (Client client : clientList) {
                        disconnectUser(client);
                    }
                    appendLog("Сервер остановлен!");
                    try {
                        if (serverSocket != null) {
                            serverSocket.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        serverWindow.setVisible(true);
    }

    private void sendServerShutdownMessage() {
        String message = "Сервер завершает работу. Подключение будет закрыто.";
        for (Client client : clientList) {
            client.sendMessage(message);
        }
    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public String getHistory() {
        return readLog();
    }

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (client != null) {
            client.disconnect();
        }
    }

    public void sendMessage(String text) {
        if (!work) {
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text) {
        for (Client client : clientList) {
            client.sendMessage(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        return buttonPanel;
    }
}

