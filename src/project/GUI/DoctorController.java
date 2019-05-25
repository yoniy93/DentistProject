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
        doctorView.getEditPersonalDetails().addActionListener(e -> editDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> enterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> viewInfoAction());
    }

    public void editDetailsAction()
    {

    }

    public void enterShiftAction()
    {

    }

    public void viewInfoAction()
    {

    }
}