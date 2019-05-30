package project.GUI.Doctor.General;

import project.GUI.General.PersonView;
import javax.swing.*;

public class DoctorView extends PersonView {

    private ImageIcon imageForBG=new ImageIcon(this.getClass().getResource("image1.jpg"));
    private JLabel backGround=new JLabel(imageForBG);
    private JButton enterShifts = new JButton("Manage your Shift");;

    public DoctorView()
    {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("WELCOME DOCTOR");
    }

    private void setLocationAndSize(){

        enterShifts.setBounds(150, 290, 150, 30);
        backGround.setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(enterShifts);
        add(backGround);
    }

    public JButton getEnterShifts() {
        return enterShifts;
    }
}

