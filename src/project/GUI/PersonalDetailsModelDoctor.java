package project.GUI;

import project.Entities.Doctor;
import project.Logic.DatabaseHandler;

import java.util.concurrent.atomic.DoubleAccumulator;

public class PersonalDetailsModelDoctor {
    Doctor doctor;

    public PersonalDetailsModelDoctor(Doctor doctor){
        this.doctor=doctor;
    }

    public Doctor UpdatedDoctor()
    {
        DatabaseHandler databaseHandler=new DatabaseHandler();
        databaseHandler.updateDoctorDetailts(doctor);
        return this.doctor;
    }
}
