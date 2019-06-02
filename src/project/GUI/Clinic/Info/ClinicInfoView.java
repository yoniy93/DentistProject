package project.GUI.Clinic.Info;

import project.Database.Locations;
import project.GUI.General.CancleButton;

import javax.swing.*;
import java.awt.*;

public class ClinicInfoView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private String[][] tableData = {
            {"Days:", "Hours:"},
            {"Sunday", "09:00 - 17:00"},
            {"Monday", "09:00 - 17:00"},
            {"Tuesday", "09:00 - 17:00"},
            {"Wednesday", "08:00 - 15:00"},
            {"Thursday", "09:00 - 17:00"},
    };

    private String[] columnNames = { "Days:", "Hours:" };

    private JLabel clinicNameLable = new JLabel( "מרפאת שיניים ");
    private JLabel openningHoursLable = new JLabel( "שעות פתיחה:");
    private JLabel phoneNumberLable = new JLabel( "טלפונים:");
    private JLabel addressLabel = new JLabel( "כתובת:");
    private JTable hoursTable = new JTable(tableData,columnNames);
    CancleButton cancleButton=new CancleButton();

    public ClinicInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("מידע שימושי");
        setBounds(200, 200, 800, 500);
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

        hoursTable.setBounds(300, 200, 230, 120);
        hoursTable.setFont(new Font("Tahoma", Font.BOLD, 16));
        hoursTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        hoursTable.setRowHeight(20);
        hoursTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        hoursTable.getColumnModel().getColumn(1).setPreferredWidth(150);

        cancleButton.setLocation(220,400,100,30);
        backGround.setBounds(0,0,800,500);
    }

    private void addComponentsToFrame(){

        add(hoursTable);
        add(clinicNameLable);
        add(cancleButton);
        add(addressLabel);
        add(phoneNumberLable);
        add(openningHoursLable);
        add(backGround);

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
