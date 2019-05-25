package project.GUI;

public class DoctorController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;

    public DoctorController(DoctorModel doctorM,DoctorView doctorV)
    {
        this.doctorView=doctorV;
        this.doctorModel=doctorM;
    }
}
