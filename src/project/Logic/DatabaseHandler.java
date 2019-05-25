package project.Logic;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import project.Entities.*;

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
                " lastname text NOT NULL, email text NOT NULL, weightkg double, heightcm integer, birthdate text NOT NULL, userrole text" +
                ", yearOfExperiens integer, gender text);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // add a popup window with the error
        }
    }

    public void insert(String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, USER_TYPE role, String gender) {

        String sql;
        switch (role){
            case SECRETARY:
                sql = "INSERT INTO users(id, password, firstname, lastname, email, weightkg, heightcm, birthdate, userrole,gender,yearOfEx)" +
                        "VALUES ("+id+", "+pswd+", "+name+", "+lname+", "+email+", "+wieght+", "+height+", "+bdate+",S ,"+gender+");";
                break;
            case DOCTOR:
                sql = "INSERT INTO users(id, password, firstname, lastname, email, birthdate, userrole,gender,yearOfEx)" +
                        "VALUES ("+id+", "+pswd+", "+name+", "+lname+", "+email+", "+bdate+",D,"+gender+");";
                break;
            case ADMIN:
                sql = "INSERT INTO users(id, password, firstname, lastname, email, birthdate, userrole, gender)" +
                        "VALUES ("+id+", "+pswd+", "+name+", "+lname+", "+email+", "+bdate+", A," +gender+");";
                break;
            case PATIENT:
                sql = "INSERT INTO users(id, password, firstname, lastname, email, weightkg, heightcm, birthdate, userrole,gender)" +
                        "VALUES ("+id+", "+pswd+", "+name+", "+lname+", "+email+", "+wieght+", "+height+", "+bdate+",P, "+gender +");";
                break;
            default:
                sql=null;
        }

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
//id, password, firstname, lastname, email, weightkg, heightcm, birthdate, userrole
    public void update(Admin a) {

        String sql= "UPDATE users SET  password="+a.getPassword()+", firstname="+a.getFirstName() +
                ", lastname="+a.getLastName() +", email="+a.getEmail() +"WHERE id=" +a.getId()+";";
        /*
        switch (user.getUserRole()){
            case PATIENT:

                sql = "UPDATE users SET  password="+user.getPassword()+", firstname="+user.getFirstName() +
                        ", lastname="+user.getLastName() +", email="+user.getEmail() +", wieght="+user.getWeight() +
                        ", height="+user.getHeight() +", birthdate="+user.getDateOfBirth() +"WHERE id=" +user.getId()+";";
                break;
            case ADMIN:
                sql = "UPDATE users SET  password="+user.getPassword()+", firstname="+user.getFirstName() +
                        ", lastname="+user.getLastName() +", email="+user.getEmail() +"WHERE id=" +user.getId()+";";
                break;
            case DOCTOR:
                sql = "UPDATE users SET  password="+user.getPassword()+", firstname="+user.getFirstName() +
                        ", lastname="+user.getLastName() +", email="+user.getEmail() +", wieght="+ +", height="+
                        ", birthdate="+user.getDateOfBirth() +"WHERE id=" +user.getId()+";";
                break;
            case SECRETARY:
                sql = "UPDATE users SET  password="+user.getPassword()+", firstname="+user.getFirstName() + ", lastname="+user.getLastName() +
                        ", email="+user.getEmail() +", wieght="+ +", height="+ +", birthdate="+user.getDateOfBirth() +"WHERE id=" +user.getId()+";";
                break;
            default:
                sql=null;
        }*/

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
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

            switch (type){
                case ADMIN:
                    return new Admin(id,rs.getString("firstname"),rs.getString("lastname"), rs.getString("email"), rs.getString("password"),rs.getString("gender") ,rs.getDate("birthdate"));
                case DOCTOR:
                    return new Doctor(id,rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),);
                case SECRETARY:
                    return new Secretary();
                case PATIENT:
                    return new Patient();
                case ERROR:
                    return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
