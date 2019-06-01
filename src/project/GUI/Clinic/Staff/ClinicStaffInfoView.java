package project.GUI.Clinic.Staff;

import project.Database.Locations;
import project.Entities.Doctor;

import javax.swing.*;
import java.util.Vector;

public class ClinicStaffInfoView extends JFrame {
    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround = new JLabel(imageForBG);
    

    public ClinicStaffInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Our Doctors: ");
        setBounds(300, 300, 800, 50);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {

    }

    private void addComponentsToFrame()
    {

        add(backGround);
    }
}
