package project.GUI.General;

import project.GUI.Clinic.Info.StartClinicInfo;
import project.GUI.Clinic.Staff.StartClinicStaffInfo;
import project.GUI.Login.StartLoginView;
import javax.swing.*;

public abstract class PersonController {

    protected void addActionsToPerson(PersonView personView) {
        personView.setActionsToPerson(e->logoutAction(personView), e->viewStaffInfoAction(), e->viewClinicInfoAction());
    }

    private void logoutAction(PersonView personView) {
       personView.dispose();
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

    private void viewClinicInfoAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartClinicInfo();
            }
        });
    }
}
