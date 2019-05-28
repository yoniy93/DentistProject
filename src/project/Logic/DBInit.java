package project.Logic;

import java.io.File;

public class DBInit {

    private static boolean isDBExists() {
        File file=new File(DBLocation.DBLocation());
        if (file.exists())
            return true;
        else
            return false;
    }

    private static void createTablesInDB(){
        DBHandler.createNewDatabase();
        DBHandler.createNewTables();
    }

    private static void insertInitialData(){
        DBInserts dbInserts=new DBInserts();
        dbInserts.insertForAdmin("1234567", "1234567", "Admin", "Admin", "mail", "13-05-1993", "male");
        dbInserts.insertForDoctor("302208178", "12345", "Yoni", "Yardeni", "yoniy93@gmail.com", "13-05-1993", "male", 3);
        dbInserts.insertForPatient("123", "123", "check", "check", "check", 60.5, 178, "13-05-1993", "male");
        dbInserts.insertTreatment(1, "שיננית", 30, 70.5);
        dbInserts.insertTreatment(2, "סתימה", 60, 99);
        dbInserts.insertTreatment(3, "גשר", 90, 150);
        dbInserts.insertTreatment(4, "שיננית", 60, 69.9);
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
