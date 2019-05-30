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
        clinicNameLable.setHorizontalAlignment(SwingConstants.CENTER);
        clinicNameLable.setFont(new Font("Tahoma", Font.BOLD, 26));
        clinicNameLable.setBounds(116, 28, 348, 69);

        openningHoursLable.setHorizontalAlignment(SwingConstants.RIGHT);
        openningHoursLable.setFont(new Font("Tahoma", Font.BOLD, 16));
        openningHoursLable.setBounds(372,131,114,40);

        phoneNumberLable.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneNumberLable.setFont(new Font("Tahoma", Font.BOLD, 16));
        phoneNumberLable.setBounds(150,300, 114,40);

        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addressLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        addressLabel.setBounds(150,180,114,40);

        hoursTable.setBounds(312, 229, 225, 80);
        hoursTable.setFont(new Font("Tahoma", Font.BOLD, 11));
        hoursTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        hoursTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        hoursTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        hoursTable.getColumnModel().getColumn(2).setPreferredWidth(40);

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
