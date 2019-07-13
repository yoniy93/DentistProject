package project.GUI.Doctor.General;

import project.GUI.Doctor.DoctorPersonalDetails.StartPersonalDetailsDoctor;
import project.GUI.Doctor.PatientsHistory.PatientsHistoryView;
import project.GUI.General.PersonController;
import javax.swing.*;

public class DoctorController extends PersonController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;


    public DoctorController(DoctorModel doctorM,DoctorView doctorV)
    {
        doctorView = doctorV;
        doctorModel = doctorM;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        addActionsToPerson(doctorView);
        doctorView.setActions(e->editDetailsAction(), e->enterShiftAction(),e -> showHistoryAction());
        /*
        doctorView.getLogoutButton().addActionListener(e -> logoutAction(doctorView));
        doctorView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> EnterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> ViewInfoAction());
        doctorView.getViewClinicDetails().addActionListener(e->viewClinicInfo());
        */
    }

    private void editDetailsAction()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartPersonalDetailsDoctor(doctorModel.getDoctor());
            }
        });
    }

    private void showHistoryAction()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PatientsHistoryView();
            }
        });
    }

    private void enterShiftAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new ManageShiftView();
            }
        });
    }
}