package project.GUI.Clinic.Staff;

import project.Database.DBQuerys;
import project.Entities.Doctor;

import java.util.Vector;

public class ClinicStaffInfoModel {

    DBQuerys dbQuerys =new DBQuerys();;

    public Vector<Doctor> createDoctorsTable()
    {
        Vector<Doctor> doctors=new Vector<Doctor>();
        doctors=dbQuerys.getDoctors();
        return doctors;
    }
}
