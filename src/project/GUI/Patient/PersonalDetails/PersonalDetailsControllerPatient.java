package project.GUI.Patient.PersonalDetails;

public class PersonalDetailsControllerPatient {

    private PersonalDetailsViewPatient pDetailsView;
    private PersonalDetailsModelPatient pDetailsModel;

    public PersonalDetailsControllerPatient(PersonalDetailsModelPatient pPM , PersonalDetailsViewPatient pPV) {
        pDetailsModel=pPM;
        pDetailsView=pPV;

        SetTextFieldsCurrentValues();
        addViewActionListeners();
    }

    private void SetTextFieldsCurrentValues() {
        pDetailsView.getFirstnameTextField().setText(pDetailsModel.getPatient().getFirstName());
        pDetailsView.getLastnameTextField().setText(pDetailsModel.getPatient().getLastName());
        pDetailsView.getEmailTextField().setText(pDetailsModel.getPatient().getEmail());
        pDetailsView.getHeightTextField().setText(Integer.toString(pDetailsModel.getPatient().getHeight()));
        pDetailsView.getWeightTextFiled().setText(Integer.toString(pDetailsModel.getPatient().getWeight()));
    }

    private void addViewActionListeners() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public String getPassword(){
        return new String(pDetailsView.getPasswordField().getPassword());
    }

    public void EditAction() {
        pDetailsModel.UpdatePatient();
    }
}