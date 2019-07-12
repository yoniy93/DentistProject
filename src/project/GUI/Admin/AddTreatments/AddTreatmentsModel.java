package project.GUI.Admin.AddTreatments;

import org.sqlite.core.DB;
import project.Database.DBInserts;
import project.Database.DBQuerys;

public class AddTreatmentsModel
{
    DBInserts dbInserts = new DBInserts();
    DBQuerys dbQuerys = new DBQuerys();

    public int getAvailableId(){
        return dbQuerys.getLastId("treatments");
    }

    public String InsertTreatment(int Id, String Name , int Duration, double Price)
    {
        return dbInserts.insertTreatment(Id, Name,Duration, Price);
    }

}
