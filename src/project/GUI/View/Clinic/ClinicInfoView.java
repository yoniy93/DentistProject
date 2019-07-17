package project.GUI.View.Clinic;

import project.Database.Locations;
import project.GUI.View.ExitButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClinicInfoView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private String[][] tableData = {
            {" Days:", "Hours:"},
            {" Sunday", "09:00 - 17:00"},
            {" Monday", "09:00 - 17:00"},
            {" Tuesday", "09:00 - 17:00"},
            {" Wednesday", "08:00 - 15:00"},
            {" Thursday", "09:00 - 17:00"},
    };

    private String[] columnNames = { "Days:", "Hours:" };
    private JLabel clinicNameLable = new JLabel( "<HTML><U>Clinic Info:</U></HTML>");
    private JLabel openningHoursLable = new JLabel( "Opening Hours: ");
    private JLabel phoneNumberLable = new JLabel( "Phone Number: ");
    private JLabel addressLabel = new JLabel( "Address: ");
    private JLabel address = new JLabel( "  Holon, Golomb 52");
    private JLabel phone1 = new JLabel( "  03-6880321");

    private JTable hoursTable = new JTable(tableData,columnNames);
    ExitButton exitButton =new ExitButton();

    public ClinicInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Information");
        setBounds(500, 150, 800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize(){
        clinicNameLable.setHorizontalAlignment(SwingConstants.CENTER);
        clinicNameLable.setFont(new Font("Ariel", Font.BOLD, 30));
        clinicNameLable.setBounds(180, 28, 348, 80);

        openningHoursLable.setHorizontalAlignment(SwingConstants.RIGHT);
        openningHoursLable.setFont(new Font("Ariel", Font.BOLD, 20));
        openningHoursLable.setOpaque(false);
        openningHoursLable.setBounds(20,120,200,40);

        phoneNumberLable.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneNumberLable.setFont(new Font("Ariel", Font.BOLD, 20));
        phoneNumberLable.setOpaque(false);
        phoneNumberLable.setBounds(20,300, 200,40);

        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addressLabel.setFont(new Font("Ariel", Font.BOLD, 20));
        addressLabel.setOpaque(false);
        addressLabel.setBounds(380,120,200,40);

        hoursTable.setBounds(230, 130, 230, 125);
        hoursTable.setFont(new Font("Ariel", Font.BOLD, 16));
        hoursTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        hoursTable.setRowHeight(20);
        hoursTable.setBackground(Color.WHITE);
        hoursTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        hoursTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        hoursTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));


        address.setHorizontalAlignment(SwingConstants.LEFT);
        address.setFont(new Font("Ariel", Font.BOLD, 18));
        address.setOpaque(true);
        address.setBackground(Color.WHITE);
        address.setBounds(580,125,190,30);
        address.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        phone1.setHorizontalAlignment(SwingConstants.LEFT);
        phone1.setFont(new Font("Ariel", Font.BOLD, 18));
        phone1.setOpaque(true);
        phone1.setBackground(Color.WHITE);
        phone1.setBounds(220,305,150,30);
        phone1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        exitButton.setLocation(610,400,120,30);
        backGround.setBounds(0,0,800,500);
    }

    private void addComponentsToFrame(){
        add(hoursTable);
        add(clinicNameLable);
        add(exitButton);
        add(addressLabel);
        add(address);
        add(phone1);
        add(phoneNumberLable);
        add(openningHoursLable);
        add(backGround);

    }

    public void setActions(ActionListener cancel){
        exitButton.addActionListener((cancel));
    }
}
