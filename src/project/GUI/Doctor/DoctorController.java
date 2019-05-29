package project.GUI.Doctor;
import project.GUI.Clinic.StartClinicInfo;
import project.GUI.Doctor.DoctorPersonalDetails.StartPersonalDetailsDoctor;
import project.GUI.PersonController;
public class DoctorController extends PersonController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;


    public DoctorController(DoctorModel doctorM,DoctorView doctorV)
    {
        doctorView = doctorV;
        doctorModel = doctorM;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        doctorView.getLogoutButton().addActionListener(e -> logoutAction(doctorView));
        doctorView.getEditPersonalDetails().addActionListener(e -> EditDetailsAction());
        doctorView.getEnterShifts().addActionListener(e -> EnterShiftAction());
        doctorView.getViewClinicStaffInfo().addActionListener(e -> ViewInfoAction());
        doctorView.getViewClinicDetails().addActionListener(e->viewClinicInfo());
    }

    private void viewClinicInfo() {
        new StartClinicInfo();
    }

    private void EditDetailsAction()
    {
        new StartPersonalDetailsDoctor(doctorModel.getDoctor());
    }

    private void EnterShiftAction() {

    }

    private void ViewInfoAction() {

    }
}