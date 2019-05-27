package project.GUI.Doctor;
import project.GUI.PersonView;

import javax.swing.*;

public class DoctorView extends PersonView {

    private JButton enterShifts= new JButton("Manage your Shift");;


    public DoctorView()
    {

        generateLoginFrameDoctor();
    }


    private void generateLoginFrameDoctor() {
        setLayout(null);
        this.setLocationAndSize();
        setEnterShifts();
        this.addComponentsToContainer();
        addEnterShiftsToContainer();

        setTitle("WELCOME DOCTOR");
        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
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

