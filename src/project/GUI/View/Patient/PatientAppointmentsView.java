package project.GUI.View.Patient;

import project.Database.Locations;
import project.GUI.General.CancelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class PatientAppointmentsView extends JFrame {

    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JLabel headLine = new JLabel("Your Appointments");

    private JTable appointmentTable = new JTable();
    private JScrollPane jScrollPane;

    private CancelButton cancelButton = new CancelButton();

    public PatientAppointmentsView( JTable appointmentTable)
    {
        setLayout(null);
        loadTable(appointmentTable);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Your Appointments History");
        setBounds(300, 20, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void addActionListeners(ActionListener cancel) {
        cancelButton.addActionListener(cancel);
    }

    private void addComponentsToFrame() {
        add(jScrollPane);
        add(headLine);
        add(cancelButton);
        add(backGround);
    }

    private void setLocationAndSize() {
        headLine.setBounds(100,10,400,200);
        headLine.setFont(new Font("Ariel", Font.BOLD, 30));

        jScrollPane.setBounds(100,200,500,150);
        cancelButton.setLocation(500,400,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void loadTable( JTable appointmentTable){
        this.appointmentTable = appointmentTable;
        this.appointmentTable.setFont(new Font("Ariel", Font.BOLD, 14));
        jScrollPane = new JScrollPane(appointmentTable);
    }
}
