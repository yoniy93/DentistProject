package project.GUI.Controller;

import project.GUI.Model.UserModel;
import project.GUI.View.Clinic.*;
import project.GUI.Login.StartLoginView;
import project.GUI.View.UserView;

import javax.swing.*;


public abstract class UserController {

    private UserModel userModel = UserModel.getInstance();
    private ClinicInfoView clinicInfoView;
    private ClinicStaffInfoView clinicStaffInfoView;

    protected void addActionsToPerson(UserView userView) {
        userView.setActionsToPerson(e->openLoginView(userView), e->openClinicStaffInfoView(), e->openClinicInfoView());
    }

    //===========================================================================

    private void openLoginView(UserView userView) {
       userView.dispose();

       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                new StartLoginView();
            }
       });
    }

    //===========================================================================

    private void openClinicStaffInfoView() {
        clinicStaffInfoView = new ClinicStaffInfoView();

        clinicStaffInfoView.setDoctorList (userModel.getDoctorList());

        clinicStaffInfoView.setActions(e->clinicStaffInfoView.setSelectedDoctorInfo() , e->clinicStaffInfoView.dispose());
    }

    //===========================================================================

    private void openClinicInfoView() {
        clinicInfoView = new ClinicInfoView();
        clinicInfoView.setActions(e -> clinicInfoView.dispose());
    }

    //===========================================================================
}
