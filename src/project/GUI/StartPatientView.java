package project.GUI;

import project.Entities.Patient;

public class StartPatientView {
    public StartPatientView(Patient patient){
        PatientModel patientM = new PatientModel();
        PatientView patientV = new PatientView();
        new PatientController(patientM, patientV);
    }
}
