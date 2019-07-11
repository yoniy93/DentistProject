package project.GUI.Clinic.Staff;

public class StartClinicStaffInfo
{
    public StartClinicStaffInfo() {
        ClinicStaffInfoView clinicStaffInfoView = new ClinicStaffInfoView();
        ClinicStaffInfoModel clinicStaffInfoModel = new ClinicStaffInfoModel();
        new ClinicStaffInfoController(clinicStaffInfoModel, clinicStaffInfoView);
    }
}
