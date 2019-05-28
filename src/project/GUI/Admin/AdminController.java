package project.GUI.Admin;


import project.GUI.Admin.Register.StartRegisterView;
import project.GUI.Login.StartLoginView;
import project.Logic.DBInserts;
import project.Logic.DBQuerys;

import javax.swing.*;

public class AdminController {

    private AdminModel adminModel;
    private AdminView adminView;

    public AdminController(AdminModel adminM, AdminView adminV) {
        this.adminModel=adminM;
        this.adminView=adminV;

        addViewActionListeners();
    }

    private void addViewActionListeners ()
    {
        adminView.getLogoutButton().addActionListener(e -> logoutAction());
        adminView.getRegisterNewUser().addActionListener(e->registerAction());
//        adminView.getUnRegisterNewUser().addActionListener(e->unregisterAction());
        adminView.getEditPersonalDetails().addActionListener(e->editPersonalDeatailsAction());
  //      adminView.getViewClinicStaffInfo().addActionListener(e->viewClinicInfoAction());
    }

    private void logoutAction() {
        adminView.dispose();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }

    private void registerAction()
    {
        new StartRegisterView();
    }

    private void unregisterAction()
    {

    }

    private void editPersonalDeatailsAction()
    {

    }

    private void viewClinicInfoAction()
    {

    }
}
