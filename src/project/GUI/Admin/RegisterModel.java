package project.GUI.Admin;

import project.Entities.Admin;

public class RegisterModel {

    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public RegisterModel(Admin admin)
    {
        this.admin=admin;
    }

}
