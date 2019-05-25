package project.Logic;
import java.sql.*;

public class Database {

    public static Database database=null;

    static Database getDatabase()
    {
        if(database==null)
        {
           database=new Database();
        }
        return database;
    }

    public static void createNewDatabase() {

        //String url = "jdbc:sqlite:C:/Users/amit/Documents/שנה שניה סמסטר ב/הנדסת תכנה/DB/testDB.db"; // AMIT
        String url =         "jdbc:sqlite:/Users/yonatan/project/projectDB.db";; // YONI
        //String url = "jdbc:sqlite:C:\Downloads\First Degree\IntelliJ\DentistProject\DentistDB.db" // OFIR



        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url ="jdbc:sqlite:/Users/yonatan/project/projectDB.db";; // YONI

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (id text PRIMARY KEY, password text NOT NULL, firstname text NOT NULL,"+
                " lastname text NOT NULL, email text NOT NULL, weightkg double, heightcm integer, birthdate text NOT NULL, userrole text, yearOfExperiens integer);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
