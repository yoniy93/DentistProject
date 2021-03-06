package project.GUI.Model;
import project.Database.DBQuerys;
import project.Database.DBUpdates;
import project.Entities.Appointment;
import project.Entities.Doctor;

import java.util.List;


public class DoctorModel
{
    private Doctor doctor;
    private DBQuerys dbQuerys;

    public DoctorModel(Doctor doctor) {
        this.doctor=doctor;
        dbQuerys = new DBQuerys();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void UpdateDoctor(Doctor d) {
        DBUpdates databaseUpdates=new DBUpdates();
        databaseUpdates.updateDoctorDetails(d);
    }

    public List<String> getAllPatientsIDList(){
        return dbQuerys.getAllPatientsID();
    }

    public List<Appointment> getPatientAppointmentsList(String patientID) {
        return dbQuerys.getPatientAppointmentsHistory(patientID);
    }

    public String getDoctorName(String doctorID){
        return dbQuerys.getDoctorDetails(doctorID).toString();
    }

    public String getTreatmentName(String treatmentID){
        return dbQuerys.getTreatmentName(treatmentID);
    }
}
