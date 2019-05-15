package project.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    public JPanel LogInScreen;
    private JButton button1;
    public JButton ClickToLog;

    public App() {
        ClickToLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"hello");

            }
        });
    }
}
