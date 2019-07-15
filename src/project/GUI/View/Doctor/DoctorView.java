package project.GUI.View.Doctor;

import project.GUI.View.UserView;
import javax.swing.*;
import java.awt.event.ActionListener;

public class DoctorView extends UserView {

    private JButton patientsHistory = new JButton("Show Patients History");


    public DoctorView() {
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Welcome Doctor");
    }

    private void setLocationAndSize() {
        patientsHistory.setFont(getButtonFont());
        patientsHistory.setBounds(100,220,230,50);
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame() {

        add(patientsHistory);
        add(getBackGround());
    }

    public void setActions(ActionListener edit,  ActionListener showHistory){
        editPersonalDetails.addActionListener((edit));
        patientsHistory.addActionListener(showHistory);
    }
}
