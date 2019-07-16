package project.GUI.Model;

import project.Database.DBInserts;
import project.Database.DBQuerys;
import project.Database.DBUpdates;
import project.Entities.Appointment;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.Entities.Treatments;

import java.util.List;

public class PatientModel {

    private Patient patient;

    private DBQuerys dbQuerys = new DBQuerys();
    private DBInserts dbInserts = new DBInserts();
    private DBUpdates dbUpdates = new DBUpdates();

    public PatientModel(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void UpdatePatient(Patient patient) {
        dbUpdates.updatePatientDetails(patient);
        this.patient = patient;
    }

    public List<Treatments> getAllTreatmentsList() {
        return dbQuerys.getTreatments();
    }

    public List<Appointment> getPatientAppointmentsList() {
        return dbQuerys.getPatientAppointments(patient.getId());
    }

    public List<Doctor> getAllDoctorList() {
        return dbQuerys.getDoctors();
    }

    public String getTreatmentName(String id) {
        return  dbQuerys.getTreatmentName(id);
    }

    public String getDoctorName(String id) {
        return dbQuerys.getDoctorDetails(id).toString();
    }

    public void insertAppointment(int appointmentID,int treatmentID,String date, String time, String doctorid){
        dbInserts.insertAppointments(appointmentID, treatmentID, date, time, patient.getId(), doctorid);
    }

    public int getLastAppointmentID(){
        return dbQuerys.getLastId("appointments");
    }
}
