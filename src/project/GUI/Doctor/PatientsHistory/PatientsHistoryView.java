package project.GUI.Doctor.PatientsHistory;

import project.Database.Locations;
import project.Entities.Appointment;
import project.GUI.General.CancelButton;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PatientsHistoryView extends JFrame{

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);
    private JComboBox<String> patientJComboBox = new JComboBox<String>();

    private JLabel selectPatientLabel =new JLabel("Select Patient ID:");

    PatientsHistoryController patientsHistoryController=new PatientsHistoryController();

    JTable appointmentTable =new JTable();
    DefaultTableModel tablePattern =new DefaultTableModel();
    JScrollPane jScrollPane;
    String columsNames[] = new String[] { "Treatment" ,"Date", "Time", "Doctor" };

    CancelButton cancelButton=new CancelButton();

    public PatientsHistoryView() {
        setLayout(null);
        getPatientJComboBox().setVisible(true);
        setPatientList(patientsHistoryController.getPatientsList());
        loadTable();
        jScrollPane=new JScrollPane(appointmentTable);
        setLocationAndSize();
        addComponentsToFrame();
        addActionListeners();

        setTitle("Patients Treatments History:");
        setBounds(300, 20, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void loadTable(){
        appointmentTable=updateTableDetails(getSelectedID());
        appointmentTable.setFont(new Font("Ariel", Font.BOLD, 14));
    }

    private JTable updateTableDetails(String id){
        tablePattern.setRowCount(0);
        tablePattern.setColumnCount(0);

        tablePattern.setColumnIdentifiers(columsNames);

        appointmentTable.setModel(tablePattern);
        List<Appointment> listAppointment=patientsHistoryController.getTreatmentHistory(id);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate;
        for (Appointment x : listAppointment) {
            strDate= dateFormat.format(x.getTreatmentDate());
            tablePattern.addRow(new Object[] { getTreatmentName(x.getTreatmentID()),
                    strDate,
                    x.getTreatmentTime(),
                    getDoctorName(x.getDoctorId())} );
        }
        return appointmentTable;
    }

    private String getTreatmentName(String id){
        return patientsHistoryController.queryTreatmentName(id);
    }

    private String getDoctorName(String id){
        return patientsHistoryController.queryDoctorName(id);
    }

    private String getSelectedID(){
        return patientJComboBox.getSelectedItem().toString();
    }

    private void setLocationAndSize() {

        patientJComboBox.setBounds(50, 100, 200, 50);

        selectPatientLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        selectPatientLabel.setBounds(60,80,200,30);
        jScrollPane.setBounds(100,190,500,150);

        cancelButton.setLocation(500,400,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame(){
        add(jScrollPane);
        add(patientJComboBox);
        add(selectPatientLabel);
        add(cancelButton);
        add(backGround);
    }

    public JComboBox getPatientJComboBox() {
        return patientJComboBox;
    }

    public void setPatientList(List<String> values) {
        this.patientJComboBox.removeAllItems();
        values.forEach(x -> this.patientJComboBox.addItem(x));
    }

    private void addActionListeners() {
        getCancel().addActionListener(e->cancelAction());
        this.getPatientJComboBox().addActionListener(e-> updatePatientTreatmentHistory());
        this.cancelButton.addActionListener(e -> this.dispose());
    }

    private void updatePatientTreatmentHistory() {
        String patientId = patientJComboBox.getSelectedItem().toString();
        updateTableDetails(patientId);
    }

    private void cancelAction() {
        this.dispose();
    }

    public JButton getCancel() {
        return cancelButton;
    }


}
