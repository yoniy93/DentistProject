package project.GUI;

public class StartPatientView {
    public StartPatientView(){
        PatientModel patientM = new PatientModel();
        PatientView patientV = new PatientView();
        new PatientController(patientM, patientV);
    }
}
