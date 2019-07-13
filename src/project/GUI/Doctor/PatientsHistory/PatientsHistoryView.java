package project.GUI.Doctor.PatientsHistory;

import project.Database.Locations;
import project.Entities.Appointment;
import project.Entities.Patient;
import project.GUI.General.CancelButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PatientsHistoryView extends JFrame{

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private PatientsHistoryController patientsHistoryController=new PatientsHistoryController();

    private JComboBox<String> patientJComboBox = new JComboBox<String>();

    private JLabel selectPatientLable =new JLabel("Select Patient ID:");


    JTable tbl=new JTable();
    DefaultTableModel dtm=new DefaultTableModel();
    JScrollPane jScrollPane;
    String header[] = new String[] { "Date" ,"Treatment", "Time", "Doctor" };

    private JTable updateTableDetails(){
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        dtm.setColumnIdentifiers(header);
        tbl.setModel(dtm);
        // add row dynamically into the table
        for (Appointment x : patientsHistoryController.getTreatmentHistory(getSelectedID())) {
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
        this.setDoctorList(patientsHistoryController.getPatientsList());
        tbl.setBounds(100,100,300,200);
        updateTableDetails();
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

        patientJComboBox.setBounds(60, 130, 200, 50);

        selectPatientLable.setFont(new Font("Ariel", Font.BOLD, 14));
        selectPatientLable.setBounds(60,80,100,30);

        cancelButton.setLocation(310,250,120,30);
        backGround.setBounds(0,0,700,500);

    }

    private void addComponentsToFrame(){
        add(jScrollPane);
        add(patientJComboBox);
        add(selectPatientLable);
        add(cancelButton);
        add(backGround);

    }

    public JComboBox getPatientJComboBox() {
        return patientJComboBox;
    }

    public void setDoctorList(List<String> values) {
        this.patientJComboBox.removeAllItems();
        values.forEach(x -> this.patientJComboBox.addItem(x));
    }

    private void addActionListeners() {
        getCancel().addActionListener(e->cancelAction());
        this.getPatientJComboBox().addActionListener(e->updatePatientTreatmentHistopry());
        this.cancelButton.addActionListener(e -> this.dispose());
    }

    private void updatePatientTreatmentHistopry() {
        String patientId = ((Patient) this.getPatientJComboBox().getSelectedItem()).getId();
        List<Appointment> appointmentList;
        appointmentList=patientsHistoryController.getTreatmentHistory(patientId);
    }


    private void cancelAction() {
        this.dispose();
    }


    public JButton getCancel() {
        return cancelButton;
    }

}
