package project.GUI.Clinic.Staff;

public class ClinicStaffInfoController
{

    ClinicStaffInfoView clinicStaffInfoView;
    ClinicStaffInfoModel clinicStaffInfoModel;

    public ClinicStaffInfoController() {
        clinicStaffInfoModel = new ClinicStaffInfoModel();
        clinicStaffInfoView = new ClinicStaffInfoView();

        clinicStaffInfoView.setDoctorList (clinicStaffInfoModel.getDoctorList());

        clinicStaffInfoView.setActions(e->clinicStaffInfoView.setSelectedDoctorInfo() , e->clinicStaffInfoView.dispose());
    }
}
