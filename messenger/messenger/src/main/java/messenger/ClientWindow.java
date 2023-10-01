package messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ClientWindow extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    public static final String LABEL_LOGIN_PANEL = "Параметры подключения:";
    ServerWindow srvWin;
    JTextArea txtArea;
    JButton btnSend, btnLogin;
    JTextField txtMess;
    StringBuilder mess;

    ClientWindow(ServerWindow sw) {
        this.srvWin = sw;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(500,500);
        setTitle("Client of messenger");
        setResizable(false);

        add(createloginPanel(),BorderLayout.NORTH);
        txtArea = new JTextArea();
        add(txtArea, BorderLayout.CENTER);
        add(createSendPanel(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private Component createloginPanel() {
        JPanel pnlLogin = new JPanel(new GridLayout(2, 3));
        pnlLogin.add(new JTextField("192.168.0.1"));
        pnlLogin.add(new JTextField("8189"));
        pnlLogin.add( new JLabel(" "));
        pnlLogin.add(new JTextField("login"));
        pnlLogin.add(new JTextField("password"));
        pnlLogin.add(createButtonLogin(pnlLogin));
        return pnlLogin;
    }

    private Component createButtonLogin(Component par) {
        JButton btnLog = new JButton("Login");
        btnLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                par.setVisible(false);
            }
        });
        return btnLog;
    }

    private Component createSendPanel() {
        JPanel pnlSend = new JPanel(new GridLayout(1, 2));
        txtMess = new JTextField("Сообщение");
        pnlSend.add(txtMess);
        pnlSend.add(createButtonSend());
        return pnlSend;
    }
    private Component createButtonSend() {
        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append(txtMess.getText() + "\n");
                srvWin.txtArea.append(txtMess.getText() + "\n");
                try (FileWriter file = new FileWriter("messages.log",true)) {
                    file.write(txtMess.getText() + "\n");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                txtMess.setText("");
            }
        });
        return btnSend;
    }
}
