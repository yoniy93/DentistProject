package project.GUI;

public class StartDoctorView {

    public StartDoctorView(){
        DoctorModel doctorM = new DoctorModel();
        DoctorView doctorV = new DoctorView();
        new DoctorController(doctorM, doctorV);
    }
}
