package project.GUI.Patient.PersonalDetails;

import project.Entities.Patient;
import project.Logic.DBUpdates;

public class PersonalDetailsModelPatient {

    private Patient patient;

    public PersonalDetailsModelPatient(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void UpdatePatient(Patient p) {
        DBUpdates databaseUpdates = new DBUpdates();
        databaseUpdates.updatePatientDetails(p);
    }
}