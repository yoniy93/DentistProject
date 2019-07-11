package project.GUI.Patient;

import project.GUI.General.PersonController;
import project.GUI.Patient.General.PatientModel;
import project.GUI.Patient.General.PatientView;
import project.GUI.Patient.PersonalDetails.StartPersonalDetailsPatient;
import project.GUI.Patient.Treatments.StartTreatmentsPricesView;

import javax.swing.*;

public class Controller  extends PersonController {

    private Model patientModel;
    private PatientView patientView;

    public Controller(Model patientM, PatientView patientV)
    {
        patientView = patientV;
        patientModel = patientM;
        addViewActionListeners();
    }

    private void addViewActionListeners(){

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

    }

    private void viewTreatmentsAction(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartTreatmentsPricesView();
            }
        });
    }
}


