package project.GUI.Admin.AdminPersonalDetails;

import project.Entities.Admin;
import project.GUI.General.PersonalDetailsView;

public class AdminPersonalDetailsController

{
    AdminPersonalDetailsModel adminPersonalDetailsModel;
    PersonalDetailsView personalDetailsView;
    public AdminPersonalDetailsController(AdminPersonalDetailsModel adminPersonalDetailsModel, PersonalDetailsView personalDetailsView)
    {
        this.adminPersonalDetailsModel=adminPersonalDetailsModel;
        this.personalDetailsView=personalDetailsView;

        SetTextFieldsCurrentValues();
        addViewActionListeners();
    }

    private void addViewActionListeners()
    {
        personalDetailsView.getEditButton().addActionListener(e->editButtonAction());
        personalDetailsView.getCancelButton().addActionListener(e-> cancelAction());
    }
    private void SetTextFieldsCurrentValues() {
        personalDetailsView.getFirstnameTextField().setText(adminPersonalDetailsModel.getAdmin().getFirstName());
        personalDetailsView.getLastnameTextField().setText(adminPersonalDetailsModel.getAdmin().getLastName());
        personalDetailsView.getEmailTextField().setText(adminPersonalDetailsModel.getAdmin().getEmail());
        personalDetailsView.getPasswordField().setText(adminPersonalDetailsModel.getAdmin().getPassword());
    }
    private void editButtonAction()
    {
        Admin admin = adminPersonalDetailsModel.getAdmin();
        admin.setFirstName(personalDetailsView.getFirstnameTextField().getText());
        admin.setLastName(personalDetailsView.getLastnameTextField().getText());
        admin.setEmail(personalDetailsView.getEmailTextField().getText());
        admin.setPassword(new String(personalDetailsView.getPasswordField().getPassword()));
        adminPersonalDetailsModel.UpdateAdmin(admin);
    }

    private void  cancelAction()
    {
        personalDetailsView.dispose();
    }
}
