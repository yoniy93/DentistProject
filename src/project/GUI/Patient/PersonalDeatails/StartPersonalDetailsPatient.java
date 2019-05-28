package project.GUI.Patient.PersonalDeatails;
import project.Entities.Patient;
import project.GUI.Patient.PersonalDeatails.PersonalDetailsControllerPatient;
import project.GUI.Patient.PersonalDeatails.PersonalDetailsModelPatient;
import project.GUI.Patient.PersonalDeatails.PersonalDetailsViewPatient;

public class StartPersonalDetailsPatient {
    public StartPersonalDetailsPatient(Patient patient){
        PersonalDetailsModelPatient personalDetailsM = new PersonalDetailsModelPatient(patient);
        PersonalDetailsViewPatient personalDetailsV = new PersonalDetailsViewPatient();
        new PersonalDetailsControllerPatient(personalDetailsM, personalDetailsV);
    }
}
