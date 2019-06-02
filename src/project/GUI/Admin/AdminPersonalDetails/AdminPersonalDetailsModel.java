package project.GUI.Admin.AdminPersonalDetails;

import project.Entities.Admin;
import project.Database.DBUpdates;

public class AdminPersonalDetailsModel
{
    Admin admin;

    public AdminPersonalDetailsModel(Admin admin)
    {
        this.admin = admin;
    }
    public Admin getAdmin() {
        return admin;
    }

    public void UpdateAdmin() {
        DBUpdates databaseUpdates = new DBUpdates();
        databaseUpdates.updateAdmin(admin);
    }
}
