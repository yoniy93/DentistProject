package project.GUI;

public class StartPersonalDetails {

    public StartPersonalDetails(){
        PersonalDetailsModelDoctor personalDetailsM = new PersonalDetailsModelDoctor();
        PersonalDetailsViewDoctor personalDetailsV = new PersonalDetailsViewDoctor();
        new PersonalDetailsControllerDoctor(personalDetailsM, personalDetailsV);
    }
}
