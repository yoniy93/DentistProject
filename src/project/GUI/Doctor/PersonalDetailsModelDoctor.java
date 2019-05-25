package project.GUI.Doctor;

import project.Entities.Doctor;
import project.Logic.DatabaseHandler;


public class PersonalDetailsModelDoctor {
    Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public PersonalDetailsModelDoctor(Doctor doctor){
        this.doctor=doctor;
    }

    public void UpdatedDoctor() {
        DatabaseHandler databaseHandler=new DatabaseHandler();
        databaseHandler.updateDoctorDetailts(doctor);

    }
}
