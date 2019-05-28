package project.GUI.Admin;

import project.GUI.PersonView;

import javax.swing.*;

public class AdminView extends PersonView {

    private JButton registerNewUser = new JButton("Register new user: ");
    private JButton unRegisterNewUser= new JButton("Unregister exciting user: ");

    public AdminView()
    {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("WELCOME ADMIN");
    }

    private void setLocationAndSize(){
        registerNewUser.setBounds(150, 150, 150, 30);
        unRegisterNewUser.setBounds(150, 220, 150, 30);
    }

    private void addComponentsToFrame(){
        add(unRegisterNewUser);
        add(registerNewUser);
    }

    public JButton getRegisterNewUser() { return registerNewUser; }

    public JButton getUnRegisterNewUser() { return unRegisterNewUser; }
}