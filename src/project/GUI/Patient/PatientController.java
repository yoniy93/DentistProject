package project.GUI.Patient;

import project.GUI.Login.StartLoginView;
import project.GUI.Patient.PersonalDetails.StartPersonalDetailsPatient;
import project.GUI.Patient.Treatments.StartTreatmentsPricesView;

import javax.swing.*;

public class PatientController {

    private PatientModel patientModel;
    private PatientView patientView;

    public PatientController(PatientModel patientM, PatientView patientV)
    {
        patientView = patientV;
        patientModel = patientM;
        addViewActionListeners();
    }

    public void addViewActionListeners() {
        patientView.getLogoutButton().addActionListener(e -> logoutAction());
        patientView.getEditPersonalDetails().addActionListener(e -> editDetailsAction());
        patientView.getViewTreatments().addActionListener(e->viewTreatmentsAction());
    }

    public void editDetailsAction()
    {
        new StartPersonalDetailsPatient(patientModel.getPatient());
    }

    public void viewTreatmentsAction() { new StartTreatmentsPricesView(); }

    private void logoutAction() {
        patientView.dispose();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }
}
