package project.GUI.Clinic;

import project.GUI.CancleButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class ClinicInfoView extends JFrame {


    private JLabel clinicNameLabler = new JLabel( "מרפאת שיניים חולון");
    private JLabel openningHoursLable = new JLabel( "שעות פתיחה:");
    private JLabel phoneNumberLable = new JLabel( "טלפונים:");
    private JLabel addressLabel = new JLabel( "כתובת:");
    CancleButton cancleButton=new CancleButton();

    public ClinicInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("מידע שימושי");
        setBounds(300, 300, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize(){
        clinicNameLabler.setFont(new Font("Tahoma", Font.BOLD , 25));
        clinicNameLabler.setBounds(250, 100, 100, 30);

        openningHoursLable.setFont(new Font("Tahoma", Font.BOLD, 16));
        openningHoursLable.setBounds(400,200,70,20);
        cancleButton.setLocation(220,400,100,30);


    }

    private void addComponentsToFrame(){

        add(clinicNameLabler);
        add(cancleButton);


    }

    public JLabel getClinicNameLabler() {
        return clinicNameLabler;
    }

    public JLabel getOpenningHoursLable() {
        return openningHoursLable;
    }

    public JLabel getPhoneNumberLable() {
        return phoneNumberLable;
    }

    public JLabel getAddressLabel() {
        return addressLabel;
    }

    public CancleButton getCancleButton() {
        return cancleButton;
    }
}
