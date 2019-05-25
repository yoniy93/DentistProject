package project.GUI;

public class DoctorController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;


    public DoctorController(DoctorModel doctorM,DoctorView doctorV)
    {
        this.doctorView=doctorV;
        this.doctorModel=doctorM;

        initController();
    }

    public void initController() {
        doctorView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> EnterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> ViewInfoAction());
    }

    public void EditDetailsAction()
    {
        new StratPersonalDetails();
    }

    public void EnterShiftAction()
    {

    }

    public void ViewInfoAction()
    {

    }
}