package project.GUI.Patient;

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
        patientView.getEditPersonalDetails().addActionListener(e -> editDetailsAction());
        patientView.getViewTreatments().addActionListener(e->viewTreatmentsAction());
    }

    public void editDetailsAction()
    {
        new StartPersonalDetailsPatient(patientModel.getPatient());
    }

    public void viewTreatmentsAction() { new StartTreatmentsPricesView(); }
}
