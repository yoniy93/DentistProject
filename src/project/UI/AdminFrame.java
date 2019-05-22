package project.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {

    private Container container = getContentPane();
    private JButton logoutButton = new JButton("Logout");
    private JFrame logoutFrame;

    public AdminFrame(JFrame Frame)
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        logoutFrame = Frame;

        setTitle("Welcome");
        setBounds( 300, 100,800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    private void setLocationAndSize() {
        logoutButton.setBounds(20, 20, 100, 30);

    }

    private void addComponentsToContainer() {
        container.add(logoutButton);
    }

    private void addActionEvent() {
        logoutButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logoutButton) {
            logoutFrame.setVisible(true);
            this.setVisible(false);
        }
    }

}
