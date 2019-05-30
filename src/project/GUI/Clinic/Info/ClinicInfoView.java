package project.GUI.Clinic.Info;

import project.GUI.General.CancleButton;

import javax.swing.*;
import java.awt.*;

public class ClinicInfoView extends JFrame {

    private String[][] data = {
            {"", "09:00-17:00", "א'"},
            {"", "09:00-17:00", "ב'"},
            {"חצי יום","08:00-15:00","ג'"},
            {"","09:00-17:00","ד'" },
            {"קבלת תורים בלבד","09:00-17:00","ה'"}
    };

    private String[] columnNames = { "הערות", "שעות פתיחה", "ימים" };

    private JLabel clinicNameLable = new JLabel( "מרפאת שיניים ");
    private JLabel openningHoursLable = new JLabel( "שעות פתיחה:");
    private JLabel phoneNumberLable = new JLabel( "טלפונים:");
    private JLabel addressLabel = new JLabel( "כתובת:");
    private JTable hoursTable = new JTable(data,columnNames);
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
        clinicNameLable.setBounds(250, 50, 20, 10);

        openningHoursLable.setFont(new Font("Tahoma", Font.BOLD, 10));
        openningHoursLable.setBounds(250,100,20,10);

        phoneNumberLable.setFont(new Font("Tahoma", Font.BOLD, 10));
        phoneNumberLable.setBounds(200,100, 20,10);

        addressLabel.setFont(new Font("Tahoma",Font.BOLD,10));
        addressLabel.setBounds(200,250,20,10);

        hoursTable.setBounds(1,1,1,1);
        hoursTable.setSize(20,20);

        cancleButton.setLocation(220,400,20,30);
    }

    private void addComponentsToFrame(){

        add(hoursTable);
        add(clinicNameLable);
        add(cancleButton);
        add(addressLabel);
        add(phoneNumberLable);
        add(openningHoursLable);

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
