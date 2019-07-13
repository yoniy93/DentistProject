package project.GUI.Patient.General;

import project.GUI.General.PersonController;
import project.GUI.Patient.Appointments.SetAnAppointmentView;
import project.GUI.Patient.Appointments.StartAppointmentView;
import project.GUI.Patient.PersonalDetails.StartPersonalDetailsPatient;
import project.GUI.Patient.Treatments.StartTreatmentsPricesView;

import javax.swing.*;

public class PatientController extends PersonController{

    private PatientModel patientModel;
    private PatientView patientView;

    public PatientController(PatientModel patientM, PatientView patientV)
    {
        patientView = patientV;
        patientModel = patientM;
        addViewActionListeners();
    }

    private void addViewActionListeners() {

        addActionsToPerson(patientView);
        patientView.setActions(e->editDetailsAction(), e->setAnAppointmentAction(),e->viewTreatmentsAction());

/*
        patientView.getLogoutButton().addActionListener(e -> logoutAction(patientView));
        patientView.getEditPersonalDetails().addActionListener(e -> editDetailsAction());
        patientView.getViewTreatments().addActionListener(e->viewTreatmentsAction());
        patientView.getViewClinicDetails().addActionListener(e->viewClinicInfo());
*/
    }

    private void editDetailsAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartPersonalDetailsPatient(patientModel.getPatient());
            }
        });
    }

    private void setAnAppointmentAction() {
        new StartAppointmentView(patientModel.getPatient());

    }

    private void viewTreatmentsAction(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartTreatmentsPricesView();
            }
        });
    }
}
