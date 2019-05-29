package project.GUI;

import javax.swing.*;

public abstract class PersonView extends JFrame {

    private JButton logoutButton = new JButton("Logout");
    private JButton editPersonalDetails = new JButton("Edit personal details");
    private JButton viewClinicStaffInfo = new JButton("View Clinic Staff Information: ");
    private JButton viewClinicDetails = new JButton("הצג פרטי מרפאה");


    public PersonView(){
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public PersonView getPersonView() {
        return this;
    }

    private void setLocationAndSize() {
        logoutButton.setBounds(10, 10, 100, 30);
        editPersonalDetails.setBounds(150, 290, 150, 30);
        viewClinicStaffInfo.setBounds(150,360,150,30);
        viewClinicDetails.setBounds(150,430,150,30);

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
}
