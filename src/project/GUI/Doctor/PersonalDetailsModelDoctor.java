package project.GUI.Doctor;

import project.Entities.Doctor;
import project.Logic.DatabaseHandler;
import project.Logic.DatabaseUpdates;


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
        DatabaseUpdates databaseUpdates=new DatabaseUpdates();
        databaseUpdates.updateDoctorDetailts(doctor);

    }
}
