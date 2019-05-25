package project.Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createNewTable() {
        // SQLite connection string
        //String url = "jdbc:sqlite:C:/Users/amit/Documents/שנה שניה סמסטר ב/הנדסת תכנה/DB/testDB.db"; // AMIT
        String url =         "jdbc:sqlite:/Users/yonatan/project/testDB.db";; // YONI
        //String url = "jdbc:sqlite:C:/Users/amit/Documents/שנה שניה סמסטר ב/הנדסת תכנה/DB/testDB.db"; // OFIR

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (id text NOT NULL PRIMARY KEY, password text NOT NULL, firstname text NOT NULL,"+
        " lastname text NOT NULL, email text NOT NULL, weightkg double, heightcm integer, birthdate text NOT NULL, userrole text, yearOfExperiens integer);";
        /*
        String sql1 = "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
