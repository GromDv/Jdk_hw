package messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final String LOG_PATH = "src/server/log.txt";

    JButton btnStart, btnStop;
    JTextArea logServer;
    Server server;

    public ServerGUI(Server server) {
        this.server = server;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        logServer = new JTextArea();
        JScrollPane scroll = new JScrollPane(logServer,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll);
        add(createButtons(), BorderLayout.SOUTH);
    }

    public void appendLog(String text) {
        logServer.append(text + "\n");
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWorking()) {
                    appendLog("Сервер уже был запущен");
                } else {
                    server.start();
                    appendLog(server.getHistory());
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isWorking()) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.stop();
                    server.disconnectAllUsers();
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
