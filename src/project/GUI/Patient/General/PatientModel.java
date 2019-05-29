package project.GUI.Patient.General;

import project.Entities.Patient;

public class PatientModel {

    private Patient patient;

    public PatientModel(Patient patient)
    {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setpatient(Patient patient) {
        this.patient = patient;
    }

}
