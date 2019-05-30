package project.GUI.General;

import project.Database.Locations;

import javax.swing.*;
import java.awt.*;

public abstract class PersonView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("adminGeneral.jpg"));
    private JLabel backGround=new JLabel(imageForBG);

    private JButton logoutButton = new JButton("Logout");
    private JButton editPersonalDetails = new JButton("Edit personal details");
    private JButton viewClinicStaffInfo = new JButton("View Clinic Staff Information");
    private JButton viewClinicDetails = new JButton("View Clinic Information ");

    public PersonView(){
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
        editPersonalDetails.setBounds(100, 290, 230, 50);
        editPersonalDetails.setFont(new Font("Ariel", Font.BOLD, 14));
        viewClinicStaffInfo.setBounds(100,360,230,50);
        viewClinicStaffInfo.setFont(new Font("Ariel", Font.BOLD, 14));
        viewClinicDetails.setBounds(100,430,230,50);
        viewClinicDetails.setFont(new Font("Ariel", Font.BOLD, 14));
    }

    private void addComponentsToFrame() {
        add(logoutButton);
        add(editPersonalDetails);
        add(viewClinicStaffInfo);
        add(viewClinicDetails);
    }

    public JButton getViewClinicDetails() {
        return viewClinicDetails;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getViewClinicStaffInfo() {
        return viewClinicStaffInfo; }

    public JButton getEditPersonalDetails() {
        return editPersonalDetails;
    }
    public void setImageForBG(ImageIcon imageForBG) {
        this.imageForBG = imageForBG;
    }

    public JLabel getBackGround() {
        return backGround;
    }

    public void setBackGround(JLabel backGround) {
        this.backGround = backGround;
    }
    public PersonView getPersonView() {
        return this;
    }

}
