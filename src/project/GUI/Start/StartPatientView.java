package project.GUI.Start;

import project.GUI.Controller.PatientController;
import project.Entities.Patient;
import project.GUI.Model.PatientModel;
import project.GUI.View.Patient.PatientView;

public class StartPatientView {
    public StartPatientView(Patient patient){
        PatientModel patientM = new PatientModel(patient);
        PatientView patientV = new PatientView();
        new PatientController(patientM, patientV);
    }
}
