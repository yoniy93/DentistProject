package project.GUI.Patient.General;

import project.Entities.Patient;

public class StartPatientView {
    public StartPatientView(Patient patient){
        PatientModel patientM = new PatientModel(patient);
        PatientView patientV = new PatientView();
        new PatientController(patientM, patientV);
    }
}