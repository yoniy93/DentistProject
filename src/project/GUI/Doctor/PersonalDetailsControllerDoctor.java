package project.GUI.Doctor;

public class PersonalDetailsControllerDoctor {

    private PersonalDetailsViewDoctor personalDetailsView;
    private PersonalDetailsModelDoctor personalDetailsModel;

    public PersonalDetailsControllerDoctor(PersonalDetailsModelDoctor pDM , PersonalDetailsViewDoctor pDV) {
        personalDetailsModel =pDM;
        personalDetailsView =pDV;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        personalDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public String getPassword(){
        return new String(personalDetailsView.getPasswordField().getPassword());
    }

    public int getYearsOfExp(){
       return Integer.parseInt(personalDetailsView.getYearsOfExpTextField().getText());
    }

    public void EditAction() {
         personalDetailsModel.UpdatedDoctor();

    }
}



