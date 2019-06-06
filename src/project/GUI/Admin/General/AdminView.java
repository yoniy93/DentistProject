package project.GUI.Admin.General;

import project.GUI.General.PersonView;
import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminView extends PersonView {

    private JButton registerButton = new JButton("Register new user ");
    private JButton unRegisterButton= new JButton("Unregister exciting user ");

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
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(unRegisterButton);
        add(registerButton);
        add(getBackGround());
    }


    public void setAction(ActionListener register, ActionListener unregister) {
        registerButton.addActionListener(register);
        unRegisterButton.addActionListener(unregister);
    }

}