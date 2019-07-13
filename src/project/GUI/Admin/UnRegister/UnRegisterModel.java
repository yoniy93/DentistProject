package project.GUI.Admin.UnRegister;

import project.Database.DBQuerys;
import project.Database.DBUpdates;
import project.Entities.Admin;

public class UnRegisterModel
{
    Admin admin;
    public UnRegisterModel(Admin admin) {
        this.admin=admin;
    }

    public String deleteUser (String id) {
        return new DBUpdates().deleteUserFromDB(id);
    }
    public Boolean isUserExists(String id) {
        return new DBQuerys().isUserExists(id);

    }
}
