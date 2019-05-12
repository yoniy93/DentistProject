package project.Entities;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private Treatments treatmentType;
    private Time treatmentTime ;
    private Date treatmentDate;
    private Doctor  doctor;
    private Patient patient;

    public Treatments getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(Treatments treatmentType) {
        this.treatmentType = treatmentType;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



}
