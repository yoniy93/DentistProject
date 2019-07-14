package project.GUI.Admin.AdminPersonalDetails;

import project.Entities.Admin;
import project.GUI.General.PersonalDetailsView;

import javax.swing.*;

public class AdminPersonalDetailsController

{
    AdminPersonalDetailsModel adminPersonalDetailsModel;
    PersonalDetailsView personalDetailsView;
    public AdminPersonalDetailsController(AdminPersonalDetailsModel adminPersonalDetailsModel, PersonalDetailsView personalDetailsView) {
        this.adminPersonalDetailsModel=adminPersonalDetailsModel;
        this.personalDetailsView=personalDetailsView;

        SetTextFieldsCurrentValues();
        addViewActionListeners();
    }

    private void addViewActionListeners() {
        personalDetailsView.setActions(e->editAction(), e-> personalDetailsView.dispose());
    }
    private void SetTextFieldsCurrentValues() {
        personalDetailsView.initializePersonFields(adminPersonalDetailsModel.getAdmin());
    }

    private void editAction() {
        Admin admin = adminPersonalDetailsModel.getAdmin();

        admin.setFirstName(personalDetailsView.getFirstNameText());
        admin.setLastName(personalDetailsView.getLastNameText());
        admin.setEmail(personalDetailsView.getEmailText());
        admin.setPassword(personalDetailsView.getPasswordText());
        admin.setPhoneNumber(personalDetailsView.getPhoneNumberText());

        adminPersonalDetailsModel.UpdateAdmin();

        JOptionPane.showMessageDialog( personalDetailsView,  "Details Updated");

        personalDetailsView.dispose();
    }
}
