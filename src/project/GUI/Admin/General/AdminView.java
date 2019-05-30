package project.GUI.Admin.General;

import project.Database.Locations;
import project.GUI.General.PersonView;

import javax.swing.*;
import java.awt.*;

public class AdminView extends PersonView {


    private JButton registerNewUser = new JButton("Register new user ");
    private JButton unRegisterNewUser= new JButton("Unregister exciting user ");

    public AdminView()
    {
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("WELCOME ADMIN");
    }

    private void setLocationAndSize(){
        registerNewUser.setBounds(100, 150, 230, 50);
        registerNewUser.setFont(new Font("Ariel", Font.BOLD, 14));
        unRegisterNewUser.setBounds(100, 220,   230, 50);
        unRegisterNewUser.setFont(new Font("Ariel", Font.BOLD, 14));
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(unRegisterNewUser);
        add(registerNewUser);
        add(getBackGround());
    }

    public JButton getRegisterNewUser() { return registerNewUser; }

    public JButton getUnRegisterNewUser() { return unRegisterNewUser; }
}