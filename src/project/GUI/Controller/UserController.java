package project.GUI.Controller;

import project.GUI.Model.UserModel;
import project.GUI.View.Clinic.*;
import project.GUI.Login.StartLoginView;
import project.GUI.View.UserView;

import javax.swing.*;


public abstract class UserController  {

    private UserModel userModel = UserModel.getInstance();

    //windows related to all users
    private ClinicInfoView clinicInfoView;
    private ClinicStaffInfoView clinicStaffInfoView;

    protected void setActionListener(UserView userView) {
        userView.setActionsToPerson(e->openLoginView(userView), e->openClinicStaffInfoView(), e->openClinicInfoView());
    }

    //===========================================================================
    //open new login window
    private void openLoginView(UserView userView) {
       userView.dispose();

       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                new StartLoginView();
            }
       });
    }

    //===========================================================================
    //open new sub-window of view of all the doctors and their details and add action listener
    private void openClinicStaffInfoView() {
        clinicStaffInfoView = new ClinicStaffInfoView();

        clinicStaffInfoView.setDoctorList (userModel.getDoctorList());//add all doctors from DB to list

        clinicStaffInfoView.setActions(e->clinicStaffInfoView.setSelectedDoctorInfo() , e->clinicStaffInfoView.dispose());
    }

    //===========================================================================
    //open new sub-window of view of clinic information and add action listener
    private void openClinicInfoView() {
        clinicInfoView = new ClinicInfoView();
        clinicInfoView.setActions(e -> clinicInfoView.dispose());
    }

    //===========================================================================
}
