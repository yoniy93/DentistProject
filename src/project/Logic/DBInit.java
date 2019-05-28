package project.Logic;

import org.w3c.dom.Text;

import java.io.File;

public class DBInit {

    private static boolean isDBExists() {
        String s=DBLocation.DBLocation();
        String location = s.substring(s.lastIndexOf(':') + 1).trim();
        File file=new File(location);
        return file.exists();
    }

    private static void createTablesInDB() {
        DBHandler.createNewDatabase();
        DBHandler.createNewTables();
    }

    private static void insertInitialData(){
        DBInserts dbInserts=new DBInserts();
        dbInserts.insertForAdmin("1", "1", "Admin", "Admin", "email", "01-01-2000", "male");
        dbInserts.insertForDoctor("2", "1", "check", "check", "check", "13-05-1993", "male", 3);
        dbInserts.insertForPatient("3", "1", "check", "check", "check", 60.5, 178, "13-05-1993", "female");
        dbInserts.insertTreatment(1, "שיננית", 30, 70.5);
        dbInserts.insertTreatment(2, "סתימה", 60, 99);
        dbInserts.insertTreatment(3, "גשר", 90, 150);
        dbInserts.insertTreatment(4, "הלבנה", 60, 69.9);
        dbInserts.insertMedicalEquipment(11, "מזלג", "12-12-2020", 4);
    }

    public static void loadDatabaseWithInitialData(){

        boolean isDBexists=isDBExists();
        createTablesInDB();
//        String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
        if (!isDBexists) {
            insertInitialData();
        }

    }
}
