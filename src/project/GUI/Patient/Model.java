package project.GUI.Patient;

import project.Database.DBUpdates;
import project.Entities.Patient;

public class Model {

    private Patient patient;

    public Model(Patient patient)
    {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setpatient(Patient patient) {
        this.patient = patient;
    }

    public void UpdatePatient(Patient p) {
        DBUpdates databaseUpdates = new DBUpdates();
        databaseUpdates.updatePatientDetails(p);
    }
}
