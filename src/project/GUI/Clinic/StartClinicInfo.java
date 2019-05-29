package project.GUI.Clinic;


public class StartClinicInfo {
    public StartClinicInfo()
    {
        ClinicInfoView clinicInfoView=new ClinicInfoView();
        new ClinicInfoController(clinicInfoView);
    }
}
