package project.Logic;

import java.io.File;

public class DBInit {

    private static boolean isDBExists() {
        String s=DBLocation.getPath();
        String location = s.substring(s.lastIndexOf(':') + 1).trim();
        File file=new File(location);
        return file.exists();
    }

    private static void createTablesInDB() {
        DBHandler.createNewDatabase();
        DBHandler.createNewTables();
    }

    public static void loadDatabaseWithInitialData(){

        boolean isDBexists=isDBExists();
        createTablesInDB();
//        String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
        if (!isDBexists) {
            DBInserts db=new DBInserts();
            db.insertInitialData();
        }
    }
}
