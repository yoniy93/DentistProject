package project.GUI.Patient.PersonalDeatails;
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

    public void UpdatedPatient() {
        DBUpdates databaseUpdates = new DBUpdates();
        databaseUpdates.updatePatientDetaits(patient);
    }

}
