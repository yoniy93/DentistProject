package project.GUI.Doctor;

import project.GUI.Login.StartLoginView;

import javax.swing.*;

public class DoctorController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;


    public DoctorController(DoctorModel doctorM,DoctorView doctorV)
    {
        this.doctorView=doctorV;
        this.doctorModel=doctorM;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        doctorView.getLogoutButton().addActionListener(e -> logoutAction());
        doctorView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> EnterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> ViewInfoAction());
    }

    private void logoutAction() {
        doctorView.dispose();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }

    private void EditDetailsAction()
    {
        new StartPersonalDetailsDoctor(doctorModel.getDoctor());
    }

    private void EnterShiftAction() {

    }

    private void ViewInfoAction() {

    }
}