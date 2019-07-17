package project.GUI.View.Patient;

import project.Database.Locations;
import project.GUI.View.ExitButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientAppointmentsView extends JFrame {

    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JLabel headLine = new JLabel("Your Appointments:");

    private JTable appointmentTable = new JTable();
    private DefaultTableModel tablePattern = new DefaultTableModel();
    private JScrollPane jScrollPane = new JScrollPane(appointmentTable);
    private String columsNames[] = new String[] { "Treatment" ,"Date", "Time", "Doctor" };

    TableColumnModel columnModel = appointmentTable.getColumnModel();

    private ExitButton exitButton = new ExitButton();

    public PatientAppointmentsView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        initializePatientAppointmentsTable();

        setTitle("Your Appointments History");
        setBounds(550, 150, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        headLine.setBounds(50,10,400,200);
        headLine.setFont(new Font("Ariel", Font.BOLD, 30));

        jScrollPane.setBounds(50,150,600,150);

        exitButton.setLocation(500,400,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame() {
        add(jScrollPane);
        add(headLine);
        add(exitButton);
        add(backGround);
    }

    public void setColWidth(){
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(125);
        columnModel.getColumn(3).setPreferredWidth(125);
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
        exitButton.addActionListener(cancel);
    }
}
