package project.GUI;

public class StartAdminView {
    public StartAdminView(){
        AdminModel adminM = new AdminModel();
        AdminView adminV = new AdminView();
        new AdminController(adminM, adminV);
    }
}