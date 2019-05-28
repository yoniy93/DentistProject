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
        pDetailsView.getFirstnameTextField().setText(pDetailsModel.getDoctor().getFirstName());
        pDetailsView.getLastnameTextField().setText(pDetailsModel.getDoctor().getLastName());
        pDetailsView.getEmailTextField().setText(pDetailsModel.getDoctor().getEmail());
        pDetailsView.getYearsOfExpTextField().setText(Integer.toString(pDetailsModel.getDoctor().getYearsOfEx()));
    }

    private void addViewActionListeners() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());
        pDetailsView.getCancelButton().addActionListener(e-> CancelAction());
    }

    private String getPassword(){
        return new String(pDetailsView.getPasswordField().getPassword());
    }

    public void EditAction() {
         pDetailsModel.UpdateDoctor();
    }

    public void CancelAction() {
        pDetailsView.dispose();
    }
}