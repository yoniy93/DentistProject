package project.Database;

import java.io.File;
import java.sql.*;

public class DBInitializer {

    public Connection connect() {
        String url = Locations.getDatabasePath();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {

        String url = Locations.getDatabasePath();

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("Connection to DB was successfully.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isDBExists() {
        String s= Locations.getDatabasePath();
        String location = s.substring(s.lastIndexOf(':') + 1).trim();
        File file=new File(location);
        return file.exists();
    }

    private static void createTablesInDB() {
        createNewDatabase();
        createNewTables();
    }

    public static void loadDatabaseWithInitialData(){
        boolean isDBexists=isDBExists();
        createTablesInDB();
//        String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
        if (!isDBexists) {
            System.out.println("Initial database was loaded successfully ");
            DBInserts db=new DBInserts();
            db.insertInitialData();
        }
    }

    public static void createNewTables() {

        String url,sql,sql1,sql2,sql3,sql4,sql5,sql6;

        url = Locations.getDatabasePath();

        sql = "CREATE TABLE IF NOT EXISTS users (id text PRIMARY KEY, password text NOT NULL, firstname text NOT NULL," +
                "lastname text NOT NULL, email text NOT NULL, weight double, height integer, birthdate date NOT NULL, userRole text," +
                "yearOfExperiens integer, gender text, phoneNumber text NOT NULL);";

        sql1 ="CREATE TABLE IF NOT EXISTS medical_equipment (id integer PRIMARY KEY NOT NULL, treatmentname text NOT NULL,"+
                " expiredate date NOT NULL, quantity integer NOT NULL);";

        sql2="CREATE TABLE IF NOT EXISTS treatments ( id integer PRIMARY KEY NOT NULL, treatmentname text NOT NULL,"+
                " durationmin integer NOT NULL, price double NOT NULL);";

        sql3="CREATE TABLE IF NOT EXISTS appointments (treatmentID integer PRIMARY KEY NOT NULL, appointmentDATE date NOT NULL,"+
                " appointmentTIME time NOT NULL,clientID text NOT NULL, doctorID text NOT NULL);";

        sql4="CREATE TABLE IF NOT EXISTS mediciens (medicineid integer NOT NULL PRIMARY KEY,expiredate date NOT NULL," +
                "quantity integer NOT NULL,medicinename text NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    protected void connectAndExecute(String sql){
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}