package project.GUI.Clinic.Staff;

import project.Database.DBQuerys;
import project.Entities.Doctor;

import java.util.List;

public class ClinicStaffInfoModel {

    DBQuerys dbQuerys = new DBQuerys();
    private List<Doctor> doctorsList;

    public List<Doctor> getDoctorList()
    {
        doctorsList = dbQuerys.getDoctors();
        return doctorsList;
    }
}
