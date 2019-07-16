package project.GUI.View.Patient;

import project.Database.Locations;
import project.GUI.General.CancelButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientAppointmentsView extends JFrame {

    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JLabel headLine = new JLabel("Your Appointments");

    private JTable appointmentTable = new JTable();
    private DefaultTableModel tablePattern = new DefaultTableModel();
    private JScrollPane jScrollPane = new JScrollPane(appointmentTable);
    private String columsNames[] = new String[] { "Treatment" ,"Date", "Time", "Doctor" };

    private CancelButton cancelButton = new CancelButton();

    public PatientAppointmentsView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        initializePatientAppointmentsTable();

        setTitle("Your Appointments History");
        setBounds(300, 20, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        headLine.setBounds(100,10,400,200);
        headLine.setFont(new Font("Ariel", Font.BOLD, 30));

        jScrollPane.setBounds(50,200,600,150);
        cancelButton.setLocation(500,400,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame() {
        add(jScrollPane);
        add(headLine);
        add(cancelButton);
        add(backGround);
    }

    private void initializePatientAppointmentsTable(){
        tablePattern.setRowCount(0);
        tablePattern.setColumnCount(0);
        tablePattern.setColumnIdentifiers(columsNames);

        appointmentTable.setModel(tablePattern);
        appointmentTable.setFont(new Font("Ariel", Font.BOLD, 14));
    }

    public void addRowToAppointmentsTable(String treatmentName, Date appointmentDate, Time appointmentTime , String doctorName){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(appointmentDate);

        tablePattern.addRow(new Object[] {treatmentName, dateStr, appointmentTime, doctorName});
    }

    public void setActions(ActionListener cancel){
        cancelButton.addActionListener(cancel);
    }
}
