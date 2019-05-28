package project.GUI.Patient.PersonalDetails;
import project.Entities.Patient;

public class StartPersonalDetailsPatient {
    public StartPersonalDetailsPatient(Patient patient){
        PersonalDetailsModelPatient personalDetailsM = new PersonalDetailsModelPatient(patient);
        PersonalDetailsViewPatient personalDetailsV = new PersonalDetailsViewPatient();
        new PersonalDetailsControllerPatient(personalDetailsM, personalDetailsV);
    }
}
