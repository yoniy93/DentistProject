package project.GUI.Admin.Register;

import project.Entities.Admin;
import project.Logic.DBInserts;

public class RegisterModel {
    Admin admin;
    DBInserts dbInserts = new DBInserts();

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
