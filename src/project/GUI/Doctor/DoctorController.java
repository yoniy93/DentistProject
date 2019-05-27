package project.GUI.Doctor;

public class DoctorController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;


    public DoctorController(DoctorModel doctorM,DoctorView doctorV)
    {
        this.doctorView=doctorV;
        this.doctorModel=doctorM;

        addViewActionListeners();
    }

    public void addViewActionListeners() {
        doctorView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> EnterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> ViewInfoAction());
    }

    public void EditDetailsAction()
    {
        new StartPersonalDetailsDoctor(doctorModel.getDoctor());
    }

    public void EnterShiftAction()
    {

    }

    public void ViewInfoAction()
    {

    }
}