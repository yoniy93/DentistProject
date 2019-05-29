package project.GUI.Doctor.DoctorPersonalDetails;

import project.Entities.Doctor;


public class StartPersonalDetailsDoctor {

    public StartPersonalDetailsDoctor(Doctor doctor){
        PersonalDetailsModelDoctor personalDetailsM = new PersonalDetailsModelDoctor(doctor);
        PersonalDetailsViewDoctor personalDetailsV = new PersonalDetailsViewDoctor();
        new PersonalDetailsControllerDoctor(personalDetailsM, personalDetailsV);
    }
}