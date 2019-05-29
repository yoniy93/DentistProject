package project.GUI.Doctor.General;
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

}
