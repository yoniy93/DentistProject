package project.GUI.Doctor;
import project.GUI.PersonView;

import javax.swing.*;

public class DoctorView extends PersonView {

    private JButton enterShifts;


    public DoctorView()
    {
        enterShifts= new JButton("Manage your Shift");
        generateLoginFrameDoctor();
    }


    private void generateLoginFrameDoctor() {

        setEnterShifts();
        addEnterShiftsToContainer();

        setTitle("WELCOME DOCTOR");
    }

    private void setEnterShifts() {


        enterShifts.setBounds(150, 290, 150, 30);


    }

    private void addEnterShiftsToContainer() {
        add(enterShifts);
    }




    public JButton getEnterShifts() {
        return enterShifts;
    }

}

