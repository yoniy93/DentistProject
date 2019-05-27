package project.GUI.Admin;

import project.GUI.PersonView;

import javax.swing.*;


public class AdminView extends PersonView {


    private JButton registerNewUser ;
    private JButton unRegisterNewUser;


    public AdminView()
    {

        registerNewUser= new JButton("Register new user: ");
        unRegisterNewUser= new JButton("Unregister exciting user: ");

        generateLoginFrameAdmin();
    }


    private void generateLoginFrameAdmin() {

        setAdmin();
        addAdminToContainer();

        setTitle("WELCOME ADMIN");

    }

    private void setAdmin() {


        registerNewUser.setBounds(150, 150, 150, 30);
        unRegisterNewUser.setBounds(150, 220, 150, 30);


    }

    private void addAdminToContainer() {

        add(unRegisterNewUser);
        add(registerNewUser);


    }

    public JButton getRegisterNewUser() { return registerNewUser; }

    public JButton getUnRegisterNewUser() { return unRegisterNewUser; }



}



