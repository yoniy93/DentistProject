package project.GUI.Patient.Appointments;

import project.Database.DBInserts;
import project.Database.DBQuerys;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.Entities.Treatments;

import java.util.List;

public class SetAnAppointmentModel
{
    private Patient patient;

    private DBQuerys dbQuerys = new DBQuerys();
    private DBInserts dbInserts = new DBInserts();

    private List<Doctor> doctorsList;
    private List<Treatments> treatmentsList;

    public SetAnAppointmentModel(Patient patient){
        this.patient = patient;
    }

    public List<Treatments> getTreatmentList() {
        treatmentsList = dbQuerys.getTreatments();
        return treatmentsList;
    }

    public List<Doctor> getDoctorList() {
        doctorsList = dbQuerys.getDoctors();
        return doctorsList;
    }

    public void insertAppointment(int appointmentID,int treatmentID,String date, String time, String doctorid){

        dbInserts.insertAppointments(appointmentID, treatmentID, date, time, patient.getId(), doctorid);
    }

    public int getLastAppointmentID(){
       return dbQuerys.getLastId("appointments");
    }

}
