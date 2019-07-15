package project.GUI.Start;

import project.GUI.Controller.DoctorController;
import project.Entities.Doctor;
import project.GUI.Model.DoctorModel;
import project.GUI.View.Doctor.DoctorView;

public class StartDoctorView {

    public StartDoctorView(Doctor doctor){
        DoctorModel doctorM = new DoctorModel(doctor);
        DoctorView doctorV = new DoctorView();
        new DoctorController(doctorM, doctorV);
    }
}
