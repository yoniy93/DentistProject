package project.GUI.Doctor;

import project.GUI.PersonView;
import javax.swing.*;

public class DoctorView extends PersonView {

    private JButton enterShifts = new JButton("Manage your Shift");;

    public DoctorView()
    {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("WELCOME DOCTOR");
    }

    private void setLocationAndSize(){
        enterShifts.setBounds(150, 290, 150, 30);
    }

    private void addComponentsToFrame(){
        add(enterShifts);
    }

    public JButton getEnterShifts() {
        return enterShifts;
    }
}

