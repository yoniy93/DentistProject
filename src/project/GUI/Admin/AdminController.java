package project.GUI.Admin;



public class AdminController {
    private AdminModel adminModel;
    private AdminView adminView;

    public AdminController(AdminModel adminM, AdminView adminV) {
        AdminModel adminModel=adminM;
        AdminView adminView=adminV;

        initController();
    }

    private void initController ()
    {
        adminView.getRegisterNewUser().addActionListener(e->registerAction());
        adminView.getUnRegisterNewUser().addActionListener(e->unregisterAction());
        adminView.getEditPersonalDetails().addActionListener(e->editPersonalDeatailsAction());
        adminView.getViewClinicStaffInfo().addActionListener(e->viewClinicInfoAction());
    }

    private void registerAction()
    {

    }

    private void unregisterAction()
    {

    }

    private void editPersonalDeatailsAction()
    {

    }

    private void viewClinicInfoAction()
    {

    }
}
