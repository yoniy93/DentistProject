package project.GUI.Doctor.PatientsHistory;

import project.Database.DBQuerys;
import project.Entities.Appointment;
import project.Entities.Patient;

import java.util.List;

public class PatientsHistoryModel {

    DBQuerys dbQuerys=new DBQuerys();

    public List<String> queryAllPatientsID(){
        return dbQuerys.getAllPatientsID();
    }

    public List<Appointment> quertAllTreatmentsHistory(String patientId) {
        return dbQuerys.getAllTreatmetsForUser(patientId);
    }
}
