package project.GUI.Doctor;

import project.Entities.Doctor;
import project.Logic.DBUpdates;

public class PersonalDetailsModelDoctor {

    private Doctor doctor;

    public PersonalDetailsModelDoctor(Doctor doctor){
        this.doctor=doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void UpdateDoctor() {
        DBUpdates databaseUpdates=new DBUpdates();
        databaseUpdates.updateDoctorDetails(doctor);
    }
}