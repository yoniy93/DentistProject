package project.GUI.Admin.General;

import project.Entities.Admin;

public class StartAdminView {
    public StartAdminView(Admin admin){
        AdminModel adminM = new AdminModel(admin);
        AdminView adminV = new AdminView();
        new AdminController(adminM, adminV);
    }
}