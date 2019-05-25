package project.GUI;

import project.Entities.Doctor;

public class StartDoctorView {

    public StartDoctorView(Doctor doctor){
        DoctorModel doctorM = new DoctorModel();
        DoctorView doctorV = new DoctorView();
        new DoctorController(doctorM, doctorV);
    }
}
