package project.GUI.Doctor;
import project.GUI.PersonalDetailsView;

import javax.swing.*;
import java.awt.*;

public class PersonalDetailsViewDoctor extends PersonalDetailsView{

    private JLabel yearsOfExpLabel = new JLabel("Years of experience: ");
    private JTextField yearsOfExpTextField = new JTextField();


    public PersonalDetailsViewDoctor() {
        setLocationAndSize();
        addComponentsToFrame();
    }

    private void setLocationAndSize() {
        yearsOfExpLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        yearsOfExpLabel.setBounds(60, 200, 100, 30);

        yearsOfExpTextField.setBounds(170, 200, 150, 30);
    }

    private void addComponentsToFrame(){
        add(yearsOfExpLabel);
        add(yearsOfExpTextField);
    }

    public JTextField getYearsOfExpTextField() {
        return yearsOfExpTextField;
    }
}