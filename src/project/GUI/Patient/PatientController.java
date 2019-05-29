package project.GUI.Patient;

import project.GUI.Clinic.StartClinicInfo;
import project.GUI.PersonController;
import project.GUI.Patient.PersonalDetails.StartPersonalDetailsPatient;
import project.GUI.Patient.Treatments.StartTreatmentsPricesView;

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
        patientView.getLogoutButton().addActionListener(e -> logoutAction(patientView));
        patientView.getEditPersonalDetails().addActionListener(e -> editDetailsAction());
        patientView.getViewTreatments().addActionListener(e->viewTreatmentsAction());
        patientView.getViewClinicDetails().addActionListener(e->viewClinicInfo());
    }

    private void viewClinicInfo() {
        new StartClinicInfo();
    }

    private void editDetailsAction() {
        new StartPersonalDetailsPatient(patientModel.getPatient());
    }

    private void viewTreatmentsAction() {
        new StartTreatmentsPricesView();
    }


}
