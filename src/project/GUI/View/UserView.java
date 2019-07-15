package project.GUI.View;

import project.Database.Locations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class UserView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("mainapp.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private JButton logoutButton = new JButton("Logout");
    protected JButton editPersonalDetails = new JButton("Edit personal details");
    private JButton viewClinicStaffInfo = new JButton("View Clinic Staff Information");
    private JButton viewClinicDetails = new JButton("View Clinic Information ");

    private Font buttonFont = new Font("Ariel",Font.BOLD,14);

    protected UserView(){
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        logoutButton.setBounds(10, 10, 100, 30);
        logoutButton.setFont(new Font("Ariel",Font.BOLD, 12));

        editPersonalDetails.setBounds(100, 290, 230, 50);
        editPersonalDetails.setFont(getButtonFont());

        viewClinicStaffInfo.setBounds(100,360,230,50);
        viewClinicStaffInfo.setFont(getButtonFont());

        viewClinicDetails.setBounds(100,430,230,50);
        viewClinicDetails.setFont(getButtonFont());
    }

    private void addComponentsToFrame() {
        add(logoutButton);
        add(editPersonalDetails);
        add(viewClinicStaffInfo);
        add(viewClinicDetails);
    }

    public void setActionsToPerson(ActionListener logout, ActionListener viewStaff, ActionListener viewClinic) {
            logoutButton.addActionListener(logout);
            viewClinicDetails.addActionListener(viewClinic);
            viewClinicStaffInfo.addActionListener(viewStaff);
    }

    public JLabel getBackGround() {
        return backGround;
    }

    public Font getButtonFont() {
        return buttonFont;
    }
}
