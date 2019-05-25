package project.Logic;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.USER_TYPE;
import project.Entities.User;

import java.sql.*;

public class DatabaseHandler {

    public static String DBLocation() {
        // Yoni
        return "jdbc:sqlite:/Users/yonatan/project/projectDB.db";

        //Ofir
        //return "jdbc:sqlite:C:/Downloads/First Degree/IntelliJ/DentistProject/DentistDB.db";

        //Amit
        //return "jdbc:sqlite:C:/Users/amit/Documents/שנה שניה סמסטר ב/הנדסת תכנה/DB/testDB.db";
    }

    public Connection connect() {
        // SQLite connection string
        String url = DatabaseHandler.DBLocation();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {

        String url = DatabaseHandler.DBLocation();

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

    public static void createNewTables() {
        // SQLite connection string
        String url = DatabaseHandler.DBLocation();

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (id text PRIMARY KEY, password text NOT NULL, firstname text NOT NULL," +
                " lastname text NOT NULL, email text NOT NULL, weightkg double, heightcm integer, birthdate text NOT NULL, userrole text, yearOfExperiens integer);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // add a popup window with the error
        }
    }

    public void insert(String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, String role) {

        String sql = "INSERT INTO users(id, password, firstname, lastname, email, weightkg, heightcm, birthdate, userrole)" +
                "VALUES ("+id+", "+pswd+", "+name+", "+lname+", "+email+", "+wieght+", "+height+", "+bdate+", "+role+");";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isUserExists (String userid){
        String sql = "SELECT id FROM users WHERE id ="+userid;
        try (Connection conn = connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            ResultSet resultSet=pstmt.executeQuery();
            return resultSet.getString("id").equals(userid);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isPasswordCorrect (String userid, String password){
        String sql = "SELECT password FROM users WHERE id ="+userid;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            ResultSet resultSet=pstmt.executeQuery();
            return resultSet.getString("password").equals(password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public USER_TYPE getTypeOfUser (String userid){
        String sql = "SELECT id FROM users WHERE id ="+userid;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            String userType = pstmt.executeQuery().getString("userrole");
            switch (userType) {
                case "A":
                    return USER_TYPE.ADMIN;
                case "D":
                    return USER_TYPE.DOCTOR;
                case "P":
                    return USER_TYPE.PATIENT;
                case "S":
                    return USER_TYPE.SECRETARY;
                default:
                    return USER_TYPE.ERROR;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return USER_TYPE.ERROR;
        }
    }

    public void update(int id, String name, double capacity) {
        String sql = "UPDATE warehouses SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getDoctorDetails (String id, USER_TYPE type) {
        String sql = "SELECT * FROM users WHERE id="+id;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set

            switch (type){
                case ADMIN:
                    return new Admin();
                case DOCTOR:
                    return new Doctor();
                case ERROR:
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }



}
