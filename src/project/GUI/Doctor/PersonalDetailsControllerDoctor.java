package project.GUI.Doctor;

public class PersonalDetailsControllerDoctor {

    private PersonalDetailsViewDoctor pDetailsView;
    private PersonalDetailsModelDoctor pDetailsModel;

    public PersonalDetailsControllerDoctor(PersonalDetailsModelDoctor pDM , PersonalDetailsViewDoctor pDV) {
        pDetailsModel=pDM;
        pDetailsView=pDV;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public String getPassword(){
        return new String(pDetailsView.getPasswordField().getPassword());
    }

    public int getYearsOfExp(){
       return Integer.parseInt(pDetailsView.getYearsOfExpTextField().getText());
    }

    public void EditAction() {
         pDetailsModel.UpdatedDoctor();

    }
}



