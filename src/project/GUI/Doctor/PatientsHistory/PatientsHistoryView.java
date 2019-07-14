package project.GUI.Doctor.PatientsHistory;

import project.Database.Locations;
import project.Entities.Appointment;
import project.Entities.Patient;
import project.GUI.General.CancelButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class PatientsHistoryView extends JFrame{


    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);
    private JComboBox<String> patientJComboBox = new JComboBox<String>();

    private JLabel selectPatientLabel =new JLabel("Select Patient ID:");

    PatientsHistoryController patientsHistoryController=new PatientsHistoryController();

    JTable tbl=new JTable();
    DefaultTableModel dtm=new DefaultTableModel();
    JScrollPane jScrollPane;
    String header[] = new String[] { "Date" ,"Treatment", "Time", "Doctor" };

    private JTable updateTableDetails(String id){
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        dtm.setColumnIdentifiers(header);
        tbl.setModel(dtm);
        // add row dynamically into the table
        List<Appointment> listAppointment=patientsHistoryController.getTreatmentHistory(id);
        for (Appointment x : listAppointment) {
            dtm.addRow(new Object[] { x.getTreatmentDate(),
                                      getTreatmentName(x.getTreatmentID()),
                                      x.getTreatmentTime(),
                                      getDoctorName(x.getDoctorId())} );
        }
        return tbl;
    }

    private String getTreatmentName(String id){
        return patientsHistoryController.queryTreatmentName(id);
    }

    private String getDoctorName(String id){
        return patientsHistoryController.queryDoctorName(id);
    }


    CancelButton cancelButton=new CancelButton();





    public PatientsHistoryView() {
        setLayout(null);
        this.getPatientJComboBox().setVisible(true);
        this.setPatientList(patientsHistoryController.getPatientsList());
        tbl.setBounds(100,100,300,200);
        tbl=updateTableDetails(getSelectedID());
        tbl.setFont(new Font("Ariel", Font.BOLD, 14));
        jScrollPane=new JScrollPane(tbl);
        setLocationAndSize();
        addComponentsToFrame();
        addActionListeners();
        setTitle("Patients Treatments History:");
        setBounds(300, 20, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private String getSelectedID(){
        return patientJComboBox.getSelectedItem().toString();
    }

    private void setLocationAndSize() {

        patientJComboBox.setBounds(50, 100, 200, 50);

        selectPatientLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        selectPatientLabel.setBounds(60,80,100,30);
        jScrollPane.setBounds(100,200,400,200);

        cancelButton.setLocation(400,400,120,30);
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
