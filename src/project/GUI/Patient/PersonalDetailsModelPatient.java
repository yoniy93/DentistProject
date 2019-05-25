package project.GUI.Patient;
import project.Entities.Patient;

public class PersonalDetailsModelPatient {

    Patient patient;

    public PersonalDetailsModelPatient(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /*
    public void UpdatedPatient() {
        DatabaseHandler databaseHandler=new DatabaseHandler();
        databaseHandler.updatePatientDetailts(patient);

    }
    */
}
