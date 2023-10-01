package messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ServerWindow extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 800;

    JButton btnStart, btnStop;
    ClientWindow cliWin;
    JTextArea txtArea;

    ServerWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Messenger");
        setResizable(false);

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        cliWin = new ClientWindow(this);


        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Server stoped.");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Server started!");
            }
        });

        txtArea = new JTextArea(getLog("messages.log"),10,40);
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);

        add(panBottom, BorderLayout.SOUTH);
        add(txtArea,BorderLayout.CENTER);

        setVisible(true);
    }
    public  static String getLog(String file) {
        StringBuilder str = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int c;
            while((c=fr.read())!=-1){
                str.append((char)c);
            }
        } catch ( IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str.toString();
    }
}
