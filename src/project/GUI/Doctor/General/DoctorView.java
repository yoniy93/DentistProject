package project.GUI.Doctor.General;

import project.GUI.General.PersonView;
import javax.swing.*;
import java.awt.event.ActionListener;

public class DoctorView extends PersonView {

    private JButton enterShiftsButton = new JButton("Manage your Shift");

    public DoctorView() {
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Welcome Doctor");
    }

    private void setLocationAndSize() {
        enterShiftsButton.setFont(getButtonFont());
        enterShiftsButton.setBounds(100, 220, 230, 50);
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame() {
        add(enterShiftsButton);
        add(getBackGround());
    }

    public void setActions(ActionListener edit, ActionListener enterShifts){
        editPersonalDetails.addActionListener((edit));
        enterShiftsButton.addActionListener(enterShifts);
    }
}

