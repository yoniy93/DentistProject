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

    private void addViewActionListeners() {
        doctorView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> EnterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> ViewInfoAction());
    }

    private void EditDetailsAction()
    {
        new StartPersonalDetailsDoctor(doctorModel.getDoctor());
    }

    private void EnterShiftAction()
    {

    }

    private void ViewInfoAction()
    {

    }
}