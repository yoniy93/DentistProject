package project.GUI.Admin.AddTreatments;

import org.sqlite.core.DB;
import project.Database.DBInserts;

public class AddTreatmentsModel
{
    DBInserts dbInserts = new DBInserts();

    public String InsertTreatment(int Id, String Name , int Duration, double Price)
    {
        return dbInserts.insertTreatment(Id, Name,Duration, Price);
    }

}
