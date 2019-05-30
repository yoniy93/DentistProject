package project.GUI.Doctor.General;

import project.Database.Locations;
import project.GUI.General.PersonView;
import javax.swing.*;

public class DoctorView extends PersonView {


    private JButton enterShifts = new JButton("Manage your Shift");

    public DoctorView()
    {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("WELCOME DOCTOR");
    }

    private void setLocationAndSize(){

        enterShifts.setBounds(150, 290, 150, 30);
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(enterShifts);
        add(getBackGround());
    }

    public JButton getEnterShifts() {
        return enterShifts;
    }
}

