package project.GUI.Doctor;

import project.Entities.Doctor;
import project.Logic.DBUpdates;


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
        DBUpdates databaseUpdates=new DBUpdates();
        databaseUpdates.updateDoctorDetailts(doctor);

    }
}
