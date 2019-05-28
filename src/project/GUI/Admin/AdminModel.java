package project.GUI.Admin;

import project.Entities.Admin;

public class AdminModel {

    private Admin admin;
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminModel(Admin admin){
        this.admin = admin;
    }
}
