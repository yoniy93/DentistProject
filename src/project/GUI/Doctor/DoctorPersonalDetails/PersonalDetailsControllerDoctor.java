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
        pDetailsView.getFirstnameTextField().setText(pDetailsModel.getDoctor().getFirstName());
        pDetailsView.getLastnameTextField().setText(pDetailsModel.getDoctor().getLastName());
        pDetailsView.getEmailTextField().setText(pDetailsModel.getDoctor().getEmail());
        pDetailsView.getPasswordField().setText(pDetailsModel.getDoctor().getPassword());
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
        Doctor doctor=pDetailsModel.getDoctor();
        doctor.setFirstName(pDetailsView.getFirstnameTextField().getText());
        doctor.setLastName(pDetailsView.getLastnameTextField().getText());
        doctor.setEmail(pDetailsView.getEmailTextField().getText());
        doctor.setPassword(pDetailsView.getPasswordField().toString());
        doctor.setYearsOfEx(Integer.parseInt(pDetailsView.getYearsOfExpTextField().getText()));
        pDetailsModel.UpdateDoctor(doctor);
        JOptionPane.showMessageDialog( pDetailsView,  "Details Updated");
        pDetailsView.dispose();
    }

    public void CancelAction() {
        pDetailsView.dispose();
    }
}