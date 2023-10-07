package lekciya1.server;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JList<String> userList;
    boolean isServerWorking = false;
    String[] usernames = {"User1", "User2", "User3"};
    public static void main(String[] args) {
        new ServerWindow();
    }

    private ServerWindow() {


        btnStop.addActionListener(e -> {
            isServerWorking = false;
            System.out.println("Сервер остановлен. isServerWorking = " + isServerWorking + "\n");
        });

        btnStart.addActionListener(e -> {
            isServerWorking = true;
            System.out.println("Сервер запущен. isServerWorking = " + isServerWorking + "\n");
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Server");
        setAlwaysOnTop(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnStart);
        panel.add(btnStop);
        add(panel);

        String[] usernames = {"User1", "User2", "User3"};
        userList = new JList<>(usernames);
        add(userList);

        setLayout(new GridLayout(2, 1));
        add(panel);
        add(userList);

        setVisible(true);
    }
}
