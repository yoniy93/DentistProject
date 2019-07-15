package project.GUI.Start;

import project.Entities.Admin;
import project.GUI.Controller.AdminController;
import project.GUI.Model.AdminModel;
import project.GUI.View.Admin.AdminView;

public class StartAdminView {
    public StartAdminView(Admin admin){
        AdminModel adminM = new AdminModel(admin);
        AdminView adminV = new AdminView();
        new AdminController(adminM, adminV);
    }
}