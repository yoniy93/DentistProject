package project.GUI.Patient.PersonalDeatails;

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
        pDetailsView.getFirstnameTextField().setText(pDetailsModel.patient.getFirstName());
        pDetailsView.getLastnameTextField().setText(pDetailsModel.patient.getLastName());
        pDetailsView.getEmailTextField().setText(pDetailsModel.patient.getEmail());
        pDetailsView.getHeightTextField().setText(Integer.toString(pDetailsModel.patient.getHeight()));
        pDetailsView.getWeightTextFiled().setText(Integer.toString(pDetailsModel.patient.getWeight()));
    }

    private void addViewActionListeners() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public String getPassword(){
        return new String(pDetailsView.getPasswordField().getPassword());
    }


    public void EditAction() {

    }
}
