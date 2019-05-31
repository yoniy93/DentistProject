package project.GUI.Doctor.General;

import project.Database.Locations;
import project.GUI.General.PersonView;
import javax.swing.*;
import java.awt.*;

public class DoctorView extends PersonView {

    private JButton enterShifts = new JButton("Manage your Shift");

    public DoctorView() {
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Welcome Doctor");
    }

    private void setLocationAndSize() {
        enterShifts.setFont(getButtonFont());
        enterShifts.setBounds(100, 220, 230, 50);
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame() {
        add(enterShifts);
        add(getBackGround());
    }

    public JButton getEnterShifts() {
        return enterShifts;
    }
}

