package project.GUI;

import project.Entities.Person;

import javax.swing.*;

public class PersonView extends JFrame {


    private JButton viewClinicStaffInfo =new JButton("View Clinic Staff Information: ");
    private JButton editPersonalDetails = new JButton("Edit personal details");


    public PersonView(){
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();

        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    protected void setLocationAndSize() {

        editPersonalDetails.setBounds(150, 290, 150, 30);
        viewClinicStaffInfo.setBounds(150,360,150,30);

    }
    protected void addComponentsToContainer() {
        add(editPersonalDetails);
        add(viewClinicStaffInfo);
    }


    public JButton getViewClinicStaffInfo() { return viewClinicStaffInfo; }


    public JButton getEditPersonalDetails() {
        return editPersonalDetails;
    }
}
