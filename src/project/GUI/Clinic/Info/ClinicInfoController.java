package project.GUI.Clinic.Info;


public class ClinicInfoController {

    private ClinicInfoView clinicInfoView;
    public ClinicInfoController(ClinicInfoView clinicInfoView){
        this.clinicInfoView=clinicInfoView;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        clinicInfoView.cancleButton.addActionListener(e -> clinicInfoView.dispose());
    }

}
