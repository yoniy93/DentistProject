package project.GUI;

import project.Entities.Admin;

public class StartAdminView {
    public StartAdminView(Admin admin){
        AdminModel adminM = new AdminModel();
        AdminView adminV = new AdminView();
        new AdminController(adminM, adminV);
    }
}