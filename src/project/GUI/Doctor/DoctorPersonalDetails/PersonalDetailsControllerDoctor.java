package project.GUI.Doctor.DoctorPersonalDetails;

import project.Entities.Doctor;

import javax.swing.*;

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
        pDetailsView.initializeFields(pDetailsModel.getDoctor());
    }

    private void addViewActionListeners() {
        pDetailsView.setActions(e->editAction(), e-> pDetailsView.dispose());
    }

    private void editAction() {
        Doctor doctor = pDetailsModel.getDoctor();

        doctor.setFirstName(pDetailsView.getFirstNameText());
        doctor.setLastName(pDetailsView.getLastNameText());
        doctor.setEmail(pDetailsView.getEmailText());
        doctor.setPassword(pDetailsView.getPasswordText());
        doctor.setYearsOfEx(Integer.parseInt(pDetailsView.getYearsOfExpText()));
        doctor.setPhoneNumber(pDetailsView.getPhoneNumberText());

        pDetailsModel.UpdateDoctor(doctor);
        JOptionPane.showMessageDialog( pDetailsView,  "Details Updated");
        pDetailsView.dispose();
    }
}