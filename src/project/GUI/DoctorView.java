package project.GUI;

import sun.jvm.hotspot.types.JBooleanField;

import javax.swing.*;

public class DoctorView extends JFrame{

    private JButton viewClinicStaffInfo ;
    private JButton enterShifts;
    private JButton editPersonalDetails;


    public DoctorView()
    {
        viewClinicStaffInfo = new JButton("View clinic staff info");
        enterShifts= new JButton("Manage your Shift");
        editPersonalDetails=new JButton("Edit personal details");
        generateLoginFrame();
    }


    private void generateLoginFrame() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();

        setTitle("WELCOME DOCTOR");
        setBounds(500, 100, 200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }



    private void setLocationAndSize() {

        viewClinicStaffInfo.setBounds(150, 150, 150, 30);
        enterShifts.setBounds(150, 220, 150, 30);
        editPersonalDetails.setBounds(150, 250, 150, 30);

    }

    private void addComponentsToContainer() {
        add(viewClinicStaffInfo);
        add(enterShifts);
        add(editPersonalDetails);

    }


    public JButton getViewClinicStaffInfo() {
        return viewClinicStaffInfo;
    }

    public JButton getEnterShifts() {
        return enterShifts;
    }

    public JButton getEditPersonalDetails() {
        return editPersonalDetails;
    }
}

