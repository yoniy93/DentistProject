package project.GUI.Doctor.PatientsHistory;

import project.Entities.Appointment;

import java.util.List;

public class PatientsHistoryController {

    private PatientsHistoryModel patientsHistoryModel;

    PatientsHistoryController(){
       this.patientsHistoryModel=new PatientsHistoryModel();
    }

    public List<String> getPatientsList(){
        return patientsHistoryModel.queryAllPatientsID();
    }

    public List<Appointment> getTreatmentHistory(String patientId) {
        return patientsHistoryModel.quertAllTreatmentsHistory(patientId);
    }

    public String queryTreatmentName(String id){
        return patientsHistoryModel.dbQuerys.getTreatmentName(id);
    }

    public String queryDoctorName(String id){
        return patientsHistoryModel.dbQuerys.getDoctorDetails(id).toString();
    }
}
