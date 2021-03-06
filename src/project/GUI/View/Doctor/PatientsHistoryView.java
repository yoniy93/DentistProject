package project.GUI.View.Doctor;

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
import java.util.List;
/*
    View class that shows all appointments history of selected user
    Only Doctors have this option
    The appointments table will change according to the selected user in the combo box
    and according to the appointments in DB table
 */
public class PatientsHistoryView extends JFrame{

    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround = new JLabel(imageForBG);
    private JComboBox<String> patientComboBox = new JComboBox<String>();

    private JLabel selectPatientLabel = new JLabel("Select Patient ID:");

    private JTable appointmentTable = new JTable();
    private DefaultTableModel tablePattern = new DefaultTableModel();
    private JScrollPane jScrollPane = new JScrollPane(appointmentTable);
    private String columsNames[] = new String[] { "Treatment" ,"Date", "Time", "Doctor" };

    TableColumnModel columnModel = appointmentTable.getColumnModel();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    private ExitButton exitButton = new ExitButton();

    public PatientsHistoryView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        updatePatientHistoryTable();

        setTitle("Patients Treatments History:");
        setBounds(dim.width/2-this.getSize().width/2-350, dim.height/2-this.getSize().height/2-250, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void setColWidth(){
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(125);
        columnModel.getColumn(3).setPreferredWidth(125);
    }

    private void setLocationAndSize() {
        patientComboBox.setBounds(50, 100, 200, 30);

        selectPatientLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        selectPatientLabel.setBounds(60,60,150,15);
        jScrollPane.setBounds(50,190,600,150);

        exitButton.setLocation(500,400,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame(){
        add(jScrollPane);
        add(patientComboBox);
        add(selectPatientLabel);
        add(exitButton);
        add(backGround);
    }

    //function that updates the values of the appointments history table according to the patient selected
    public void updatePatientHistoryTable(){
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

    public String getSelectedID(){
        return patientComboBox.getSelectedItem().toString();
    }

    //set patients from appointments table in DB into combobox
    public void setPatientList(List<String> patientsList) {
        patientComboBox.removeAllItems();
        patientsList.forEach(patient -> patientComboBox.addItem(patient));
        patientComboBox.setSelectedIndex(-1);
    }

    public void setActions(ActionListener select, ActionListener cancel){
        patientComboBox.addActionListener((select));
        exitButton.addActionListener(cancel);
    }
}
