package project.GUI;

public class StartPersonalDetails {
    public StartPersonalDetails(){
        PersonalDetailsModel personalDetailsM = new PersonalDetailsModel();
        PersonalDetailsView personalDetailsV = new PersonalDetailsView();
        new PersonalDetailsController(personalDetailsM, personalDetailsV);
    }
}
