package project.GUI.Clinic.Info;


public class StartClinicInfo {
    public StartClinicInfo() {
        ClinicInfoView clinicInfoView = new ClinicInfoView();
        new ClinicInfoController(clinicInfoView);
    }
}
