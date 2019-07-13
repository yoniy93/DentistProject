package project.GUI.Doctor.PatientsHistory;

import project.Entities.Appointment;
import project.Entities.Patient;

import java.util.List;

public class PatientsHistoryController {

    PatientsHistoryModel patientsHistoryModel;
    PatientsHistoryController(){
        patientsHistoryModel=new PatientsHistoryModel();

    }

    public List<Patient> getPatientsList(){
        return patientsHistoryModel.queryAllPatients();
    }

    public List<Appointment> getTreatmentHistory(String patientId) {
        return patientsHistoryModel.quertAllTreatmentsHistory(patientId);
    }
}
