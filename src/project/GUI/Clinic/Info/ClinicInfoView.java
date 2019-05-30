package project.GUI.Clinic.Info;

import project.GUI.General.CancleButton;

import javax.swing.*;
import java.awt.*;

public class ClinicInfoView extends JFrame {

    ImageIcon bgImage=new ImageIcon(this.getClass().getResource("p1.jpg"));
    private JLabel image=new JLabel(bgImage);
    private JLabel clinicNameLable = new JLabel( "מרפאת שיניים ");
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
        clinicNameLable.setFont(new Font("Tahoma", Font.BOLD , 10));
        clinicNameLable.setBounds(250, 50, 100, 100);

        openningHoursLable.setFont(new Font("Tahoma", Font.BOLD, 10));
        openningHoursLable.setBounds(250,100,70,20);

        phoneNumberLable.setFont(new Font("Tahoma", Font.BOLD, 10));
        phoneNumberLable.setBounds(200,100, 70,20);

        addressLabel.setFont(new Font("Tahoma",Font.BOLD,10));
        addressLabel.setBounds(200,250,70,10);

        cancleButton.setLocation(220,400,100,30);

        image.setBounds(300,300,600,500);
    }

    private void addComponentsToFrame(){
        add(image);
        add(clinicNameLable);
        add(cancleButton);
        add(addressLabel);
        add(phoneNumberLable);


    }

    public JLabel getClinicNameLable() {
        return clinicNameLable;
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
