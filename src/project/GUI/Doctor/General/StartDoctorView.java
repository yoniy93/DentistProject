package project.GUI.Doctor.General;

import project.Entities.Doctor;

public class StartDoctorView {

    public StartDoctorView(Doctor doctor){
        DoctorModel doctorM = new DoctorModel(doctor);
        DoctorView doctorV = new DoctorView();
        new DoctorController(doctorM, doctorV);
    }
}
