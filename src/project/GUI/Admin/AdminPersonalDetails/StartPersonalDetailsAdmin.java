package project.GUI.Admin.AdminPersonalDetails;

import project.Entities.Admin;
import project.GUI.PersonalDetailsView;

public class StartPersonalDetailsAdmin
{
    public StartPersonalDetailsAdmin(Admin admin)
    {
        PersonalDetailsView adminPersonalDetailsView=new PersonalDetailsView();
        AdminPersonalDetailsModel adminPersonalDetailsModel=new AdminPersonalDetailsModel(admin);
        new AdminPersonalDetailsController(adminPersonalDetailsModel,adminPersonalDetailsView );
    }
}
