package project.GUI.Admin.General;

import project.GUI.Admin.AdminPersonalDetails.StartPersonalDetailsAdmin;
import project.GUI.Admin.Register.StartRegisterView;
import project.GUI.Admin.UnRegister.StartUnRegister;
import project.GUI.Clinic.Info.StartClinicInfo;
import project.GUI.General.PersonController;

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
        adminView.setActionS(e->registerAction(), e->unregisterAction());

        adminView.getLogoutButton().addActionListener(e -> logoutAction(adminView));
        adminView.getEditPersonalDetails().addActionListener(e->editPersonalDeatailsAction());
  //    adminView.getViewClinicStaffInfo().addActionListener(e->viewClinicInfoAction());
        adminView.getViewClinicDetails().addActionListener(e->viewClinicInfoAction());
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
        new StartClinicInfo();
    }
}
