package project.GUI.Patient;

public class PatientController {

    private PatientModel patientModel;
    private PatientView patientView;

    public PatientController(PatientModel patientM, PatientView patientV)
    {
        patientView = patientV;
        patientModel = patientM;
        initController();
    }

    public void initController() {
        patientView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
    }

    public void EditDetailsAction()
    {
        new StartPersonalDetailsPatient(patientModel.getPatient());
    }

}
