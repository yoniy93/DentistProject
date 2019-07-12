package project.GUI.Clinic.Staff;

import project.Database.DBQuerys;
import project.Entities.Doctor;
import project.Entities.Treatments;

import java.util.List;
import java.util.Vector;

public class ClinicStaffInfoModel {

    DBQuerys dbQuerys =new DBQuerys();
    private List<Doctor> doctorsList;


    public List<Doctor> getDoctorList()
    {
        doctorsList=dbQuerys.getDoctors();
        return doctorsList;
    }
}
