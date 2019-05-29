package project.GUI.Admin;

import project.GUI.Admin.AdminPersonalDetails.StartPersonalDetailsAdmin;
import project.GUI.Admin.Register.StartRegisterView;
import project.GUI.Admin.UnRegister.StartUnRegister;
import project.GUI.PersonController;
import project.GUI.PersonalDetailsView;

public class AdminController extends PersonController {

    private AdminModel adminModel;
    private AdminView adminView;

    public AdminController(AdminModel adminM, AdminView adminV) {
        adminModel = adminM;
        adminView = adminV;

        addViewActionListeners();
    }

    private void addViewActionListeners ()
    {
        adminView.getLogoutButton().addActionListener(e -> logoutAction(adminView));
        adminView.getRegisterNewUser().addActionListener(e->registerAction());
         adminView.getUnRegisterNewUser().addActionListener(e->unregisterAction());
        adminView.getEditPersonalDetails().addActionListener(e->editPersonalDeatailsAction());
  //      adminView.getViewClinicStaffInfo().addActionListener(e->viewClinicInfoAction());
    }

    private void registerAction()
    {
        new StartRegisterView(adminModel.getAdmin());
    }

    private void unregisterAction() {
        new StartUnRegister(adminModel.getAdmin());

    }

    private void editPersonalDeatailsAction() {

        new StartPersonalDetailsAdmin(adminModel.getAdmin());
    }

    private void viewClinicInfoAction() {

    }
}
