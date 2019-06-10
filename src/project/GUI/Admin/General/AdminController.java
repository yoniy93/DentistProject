package project.GUI.Admin.General;

import project.GUI.Admin.AdminPersonalDetails.StartPersonalDetailsAdmin;
import project.GUI.Admin.Register.StartRegisterView;
import project.GUI.Admin.UnRegister.StartUnRegister;
import project.GUI.General.PersonController;

import javax.swing.*;

public class AdminController extends PersonController {

    private AdminModel adminModel;
    private AdminView adminView;

    public AdminController(AdminModel adminM, AdminView adminV) {
        adminModel = adminM;
        adminView = adminV;

        addViewActionListeners();
    }

    private void addViewActionListeners () {
        addActionsToPerson(adminView);
        adminView.setActions(e->editPersonalDetailsAction(), e->registerAction(), e->unregisterAction());

        /*
        adminView.getLogoutButton().addActionListener(e -> logoutAction(adminView));
        adminView.getEditPersonalDetails().addActionListener(e->editPersonalDetailsAction());
        adminView.getViewClinicStaffInfo().addActionListener(e->viewStaffInfoAction());
        adminView.getViewClinicDetails().addActionListener(e->viewClinicInfoAction());
        */
    }

    private void registerAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartRegisterView(adminModel.getAdmin());
            }
        });
    }

    private void unregisterAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartUnRegister(adminModel.getAdmin());
            }
        });
    }

    private void editPersonalDetailsAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartPersonalDetailsAdmin(adminModel.getAdmin());
            }
        });
    }
}
