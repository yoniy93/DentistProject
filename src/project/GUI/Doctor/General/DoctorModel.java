package project.GUI.Doctor.General;
import project.Database.DBUpdates;
import project.Entities.Doctor;


public class DoctorModel
{
    private Doctor doctor;

    public DoctorModel(Doctor doctor)
    {
        this.doctor=doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void UpdateDoctor(Doctor d) {
        DBUpdates databaseUpdates=new DBUpdates();
        databaseUpdates.updateDoctorDetails(d);
    }

}
