package project.GUI.User;

import project.GUI.Clinic.ClinicInfoView;
import project.GUI.Clinic.Staff.StartClinicStaffInfo;
import project.GUI.Login.StartLoginView;
import javax.swing.*;

public abstract class UserController {

    private ClinicInfoView clinicInfoView;

    protected void addActionsToPerson(UserView userView) {
        userView.setActionsToPerson(e->logoutAction(userView), e->viewStaffInfoAction(), e->openClinicInfoView());
    }

    private void logoutAction(UserView userView) {
       userView.dispose();
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                new StartLoginView();
            }
       });
    }


    private void viewStaffInfoAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartClinicStaffInfo();
            }
        });
    }


    private void openClinicInfoView() {
        clinicInfoView = new ClinicInfoView();
        clinicInfoView.setActions(e -> clinicInfoView.dispose());
    }
}
