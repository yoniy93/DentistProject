package project.GUI.Doctor.DoctorPersonalDetails;
import project.GUI.General.PersonalDetailsView;

import javax.swing.*;
import java.awt.*;

public class PersonalDetailsViewDoctor extends PersonalDetailsView{

    private JLabel yearsOfExpLabel = new JLabel("Years of experience:");
    private JTextField yearsOfExpTextField = new JTextField();


    public PersonalDetailsViewDoctor() {
        setLocationAndSize();
        addComponentsToFrame();
    }

    private void setLocationAndSize() {
        yearsOfExpLabel.setFont(getButtonFont());
        yearsOfExpLabel.setBounds(60, 240, 100, 30);
        yearsOfExpTextField.setBounds(170, 240, 150, 30);
    }

    private void addComponentsToFrame(){
        add(yearsOfExpLabel);
        add(yearsOfExpTextField);
    }

    public JTextField getYearsOfExpTextField() {
        return yearsOfExpTextField;
    }
}