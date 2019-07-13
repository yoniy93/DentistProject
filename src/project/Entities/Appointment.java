package project.Entities;


import java.sql.Time;
import java.util.Date;

public class Appointment {

    private String treatmentID;
    private Time treatmentTime ;
    private Date treatmentDate;
    private String  doctorId;
    private String patientId;

    public Appointment(String treatmentID, Date appointmentDATE, Time appointmentTIME, String clientID, String doctorID) {
        setTreatmentID(treatmentID);
        setTreatmentDate(appointmentDATE);
        setTreatmentTime(appointmentTIME);
        setPatientId(clientID);
        setDoctorId(doctorID);

    }

    public String getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(String treatmentID) {
        this.treatmentID = treatmentID;
    }

    public Time getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(Time treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }


}
