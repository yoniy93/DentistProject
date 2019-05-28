package project.GUI.Admin;

import project.GUI.PersonView;

import javax.swing.*;


public class AdminView extends PersonView {


    private JButton registerNewUser = new JButton("Register new user: ");
    private JButton unRegisterNewUser= new JButton("Unregister exciting user: ");


    public AdminView()
    {

        setLayout(null);
        setLocationAndSize();
        setAdmin();
        addAdminToContainer();
        addComponentsToContainer();

        setTitle("WELCOME ADMIN");
        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

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



