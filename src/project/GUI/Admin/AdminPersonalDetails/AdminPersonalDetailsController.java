package project.GUI.Admin.AdminPersonalDetails;

import project.GUI.PersonalDetailsView;

public class AdminPersonalDetailsController

{
    AdminPersonalDetailsModel adminPersonalDetailsModel;
    PersonalDetailsView personalDetailsView;
    public AdminPersonalDetailsController(AdminPersonalDetailsModel adminPersonalDetailsModel, PersonalDetailsView personalDetailsView)
    {
        this.adminPersonalDetailsModel=adminPersonalDetailsModel;
        this.personalDetailsView=personalDetailsView;

        initController();
    }

    private void initController()
    {
        personalDetailsView.getEditButton().addActionListener(e->editButtonAction());
    }

    private void editButtonAction()
    {

    }
}
