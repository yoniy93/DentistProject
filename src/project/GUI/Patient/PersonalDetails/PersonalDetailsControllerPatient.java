package project.GUI.Patient.PersonalDetails;

import project.Entities.Patient;

import javax.swing.*;

public class PersonalDetailsControllerPatient {

    private PersonalDetailsViewPatient pDetailsView;
    private PersonalDetailsModelPatient pDetailsModel;

    public PersonalDetailsControllerPatient(PersonalDetailsModelPatient pPM , PersonalDetailsViewPatient pPV) {
        pDetailsModel = pPM;
        pDetailsView = pPV;

        SetTextFieldsCurrentValues();
        addViewActionListeners();
    }

    private void SetTextFieldsCurrentValues() {
        pDetailsView.initializeFields(pDetailsModel.getPatient());
    }

    private void addViewActionListeners() {
        pDetailsView.setActions(e->editAction(), e-> pDetailsView.dispose());
    }

    private void editAction() {
        Patient patient = pDetailsModel.getPatient();

        patient.setFirstName(pDetailsView.getFirstNameText());
        patient.setLastName(pDetailsView.getLastNameText());
        patient.setEmail(pDetailsView.getEmailText());
        patient.setPassword(pDetailsView.getPasswordText());
        patient.setHeight(Integer.parseInt(pDetailsView.getHeightText()));
        patient.setWeight(Double.parseDouble(pDetailsView.getWeightText()));
        patient.setPhoneNumber(pDetailsView.getPhoneNumberText());

        pDetailsModel.UpdatePatient(patient);

        JOptionPane.showMessageDialog( pDetailsView,  "Details Updated");

        pDetailsView.dispose();
    }
}
