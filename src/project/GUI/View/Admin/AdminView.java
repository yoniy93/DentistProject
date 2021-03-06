package project.GUI.View.Admin;

import project.GUI.View.UserView;
import javax.swing.*;
import java.awt.event.ActionListener;

/*
    The main window displays all the functionality of the Admin
 */
public class AdminView extends UserView {

    private JButton registerButton = new JButton("Register new user ");
    private JButton unRegisterButton= new JButton("Unregister exciting user ");
    private JButton addNewTreatments=new JButton("Add New Treatments");

    public AdminView() {
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Welcome Admin");
    }

    private void setLocationAndSize(){
        registerButton.setBounds(100, 150, 230, 50);
        registerButton.setFont(getButtonFont());
        unRegisterButton.setBounds(100, 220,   230, 50);
        unRegisterButton.setFont(getButtonFont());
        addNewTreatments.setBounds(100, 80,   230, 50);
        addNewTreatments.setFont(getButtonFont());
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(unRegisterButton);
        add(registerButton);
        add(addNewTreatments);
        add(getBackGround());
    }

    public void setActions(ActionListener edit, ActionListener register, ActionListener unregister ,ActionListener addTreatments) {
        editPersonalDetails.addActionListener((edit));
        registerButton.addActionListener(register);
        unRegisterButton.addActionListener(unregister);
        addNewTreatments.addActionListener(addTreatments);
    }
}