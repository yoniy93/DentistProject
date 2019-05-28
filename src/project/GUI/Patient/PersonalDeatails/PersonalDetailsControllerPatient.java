package project.GUI.Patient.PersonalDeatails;

public class PersonalDetailsControllerPatient {

    private PersonalDetailsViewPatient pDetailsView;
    private PersonalDetailsModelPatient pDetailsModel;

    public PersonalDetailsControllerPatient(PersonalDetailsModelPatient pPM , PersonalDetailsViewPatient pPV) {
        pDetailsModel=pPM;
        pDetailsView=pPV;

        pDetailsView.getFirstnameTextField().setText(pPM.patient.getFirstName());
        pDetailsView.getLastnameTextField().setText(pPM.patient.getLastName());
        pDetailsView.getEmailTextField().setText(pPM.patient.getEmail());

        initController();
    }

    private void initController() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public String getPassword(){
        return new String(pDetailsView.getPasswordField().getPassword());
    }


    public void EditAction() {

    }
}
