package project.GUI.Patient.Appointments;

import project.Database.DBQuerys;
import project.Entities.Doctor;

import java.util.List;

public class SetAnAppointmentModel
{
    DBQuerys dbQuerys =new DBQuerys();
    private List<Doctor> doctorsList;


    public List<Doctor> getDoctorList()
    {
        doctorsList=dbQuerys.getDoctors();
        return doctorsList;
    }
}
