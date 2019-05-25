package project.Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {

    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:C:/Users/amit/Documents/שנה שניה סמסטר ב/הנדסת תכנה/DB/testDB.db"; // AMIT
        String url =         "jdbc:sqlite:/Users/yonatan/project/testDB.db";; // YONI
        //String url = "jdbc:sqlite:C:/Users/amit/Documents/שנה שניה סמסטר ב/הנדסת תכנה/DB/testDB.db"; // OFIR
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */

}
