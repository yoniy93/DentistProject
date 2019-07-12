package project.GUI.Admin.AddTreatments;

import org.sqlite.core.DB;
import project.Database.DBInserts;

public class AddTreatmentsModel
{
    DBInserts dbInserts = new DBInserts();

    public void InsertTreatment(int Id, String Name , int Duration, double Price)
    {
        dbInserts.insertTreatment(Id, Name,Duration, Price);
    }

}
