package project.GUI.Doctor;

public class PersonalDetailsControllerDoctor {

    private PersonalDetailsViewDoctor pDetailsView;
    private PersonalDetailsModelDoctor pDetailsModel;

    public PersonalDetailsControllerDoctor(PersonalDetailsModelDoctor pDM , PersonalDetailsViewDoctor pDV) {
        pDetailsModel =pDM;
        pDetailsView =pDV;

        SetTextFieldsCurrentValues();
        addViewActionListeners();
    }

    private void SetTextFieldsCurrentValues() {
        pDetailsView.getFirstnameTextField().setText(pDetailsModel.patient.getFirstName());
        pDetailsView.getLastnameTextField().setText(pDetailsModel.patient.getLastName());
        pDetailsView.getEmailTextField().setText(pDetailsModel.patient.getEmail());
        pDetailsView.getYearsOfExpTextField().setText(Integer.toString(pDetailsModel.d.getHeight()));

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



