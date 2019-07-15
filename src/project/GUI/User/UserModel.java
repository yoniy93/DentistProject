package project.GUI.User;

import project.Database.DBQuerys;
import project.Entities.Doctor;

import java.util.List;

public class UserModel {

    private static UserModel instance;

    DBQuerys dbQuerys = new DBQuerys();
    private List<Doctor> doctorsList;

    private UserModel(){}

    public static UserModel getInstance(){
        if (instance == null)
            instance = new UserModel();
        return instance;
    }

    public List<Doctor> getDoctorList()
    {
        doctorsList = dbQuerys.getDoctors();
        return doctorsList;
    }
}
