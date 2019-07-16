package project.GUI.View.Doctor;

import project.Entities.Doctor;
import project.GUI.General.PersonalDetailsView;

import javax.swing.*;
import java.awt.event.ActionListener;

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
        getBackGround().setBounds(0,0,400,400);
    }

    private void addComponentsToFrame(){
        add(yearsOfExpLabel);
        add(yearsOfExpTextField);
        add(getBackGround());
    }

    public String getYearsOfExpText() {
        return yearsOfExpTextField.getText();
    }

    private void setYearsOfExpText(String yearsOfExp) {
        yearsOfExpTextField.setText(yearsOfExp);
    }

    public void initializeFields(Doctor doctor){
        initializeUserFields(doctor);

        setYearsOfExpText(Integer.toString(doctor.getYearsOfExp()));
    }

    public void setActions(ActionListener edit, ActionListener cancel){
        getEditButton().addActionListener((edit));
        getCancelButton().addActionListener(cancel);
    }
    public boolean isYearsOfExFilled()
    {
        if(getYearsOfExpText().equals(""))
            return false;
        return true;
    }
}