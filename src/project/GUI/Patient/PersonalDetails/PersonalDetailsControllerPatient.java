package project.GUI.Patient.PersonalDetails;

import project.Entities.Patient;

import javax.swing.*;

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
        pDetailsView.getPasswordField().setText(pDetailsModel.getPatient().getPassword());
        pDetailsView.getHeightTextField().setText(Integer.toString(pDetailsModel.getPatient().getHeight()));
        pDetailsView.getWeightTextFiled().setText(Integer.toString(pDetailsModel.getPatient().getWeight()));
        pDetailsView.getPhoneNumberTextField().setText(pDetailsModel.getPatient().getPhoneNumber());
    }

    private void addViewActionListeners() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());
        pDetailsView.getCancelButton().addActionListener(e-> CancelAction());
    }

    public void EditAction()
    {
        Patient patient=pDetailsModel.getPatient();
        patient.setFirstName(pDetailsView.getFirstnameTextField().getText());
        patient.setLastName(pDetailsView.getLastnameTextField().getText());
        patient.setEmail(pDetailsView.getEmailTextField().getText());
        patient.setPassword(new String(pDetailsView.getPasswordField().getPassword()));
        patient.setHeight(Integer.parseInt(pDetailsView.getHeightTextField().getText()));
        patient.setWeight(Integer.parseInt(pDetailsView.getHeightTextField().getText()));
        pDetailsModel.UpdatePatient(patient);
        JOptionPane.showMessageDialog( pDetailsView,  "Details Updated");
        pDetailsView.dispose();

    }

    public void CancelAction() {
        pDetailsView.dispose();
    }
}
