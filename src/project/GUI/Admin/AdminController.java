package project.GUI.Admin;

import project.GUI.Admin.Register.StartRegisterView;
import project.GUI.PersonController;

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
//        adminView.getUnRegisterNewUser().addActionListener(e->unregisterAction());
        adminView.getEditPersonalDetails().addActionListener(e->editPersonalDeatailsAction());
  //      adminView.getViewClinicStaffInfo().addActionListener(e->viewClinicInfoAction());
    }

    private void registerAction()
    {
        new StartRegisterView();
    }

    private void unregisterAction() {

    }

    private void editPersonalDeatailsAction() {

    }

    private void viewClinicInfoAction() {

    }
}
