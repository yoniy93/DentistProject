package project.Logic;

import project.Entities.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DatabaseHandler {

    public Connection connect() {
        // SQLite connection string
        String url = DatabaseLocation.DBLocation();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {

        String url = DatabaseLocation.DBLocation();

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
        String url = DatabaseLocation.DBLocation();

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (id text PRIMARY KEY, password text NOT NULL, firstname text NOT NULL," +
                " lastname text NOT NULL, email text NOT NULL, weight double, height integer, birthdate date NOT NULL, userRole text" +
                ", yearOfExperiens integer, gender text);";

        String sql1 ="CREATE TABLE IF NOT EXISTS medical_equipment (id integer PRIMARY KEY NOT NULL, treatmentname text NOT NULL, expiredate date NOT NULL, quantity integer NOT NULL);";

        String sql2="CREATE TABLE IF NOT EXISTS treatments ( id integer PRIMARY KEY NOT NULL, treatmentname text NOT NULL, durationmin integer NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            stmt.execute(sql1);
            stmt.execute(sql2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // add a popup window with the error
        }
    }
    public void insertMedicalEquipment(int id,String name, String expiredate,int quantity){
        String sql="INSERT INTO medical_equipment(id, treatmentname, expiredate, quantity) VALUES ('"+id+"', '"+name+"', '"+expiredate+"', '"+quantity+"');";
        connectAndExecute(sql);
    }


    public void insertTreatment(int id,String name, int duration){
        String sql="INSERT INTO treatments(id, treatmentname, durationmin) VALUES ('"+id+"', '"+name+"', '"+duration+"');";
        connectAndExecute(sql);
    }

    private void connectAndExecute(String sql){
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertForAdmin (String id, String pswd, String name, String lname, String email, String bdate, String gender ){
        String sql="INSERT INTO users (id, password, firstname, lastname, email, birthdate, userRole, gender)"+
                " VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"', 'A','" +gender+"');";
        connectAndExecute(sql);
    }

    public void insertForPatient (String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, String gender) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, weight, height, birthdate, userRole, gender)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+wieght+"', '"+height+"', '"+bdate+"', 'P','"+gender +"');";
        connectAndExecute(sql);
    }

    public void insertForDoctor (String id, String pswd, String name, String lname, String email, String bdate, String gender,int yearofEx) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, birthdate, userRole,yearOfExperiens,gender)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"','D','"+yearofEx+"', '"+gender+"');";
        connectAndExecute(sql);
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
        String sql = "SELECT userRole FROM users WHERE id ="+userid;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            String userType = pstmt.executeQuery().getString("userRole");
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

    public void updatePatientDetaits(Patient p){
        String sql= "UPDATE users SET  password="+p.getPassword()+", firstname="+p.getFirstName() +
                ", lastname="+p.getLastName() +", email="+p.getEmail() +"WHERE id=" +p.getId()+";";
        connectAndExecute(sql);
    }

    public void updateDoctorDetailts(Doctor d){
        String sql= "UPDATE users SET  password="+d.getPassword()+", firstname="+d.getFirstName() +
                ", lastname="+d.getLastName() +", email="+d.getEmail() +", birthdate="+ d.getDateOfBirth()+
                ", birthdate="+d.getDateOfBirth() +"WHERE id=" +d.getId()+";";
        connectAndExecute(sql);

    }

    public void updateAdmin(Admin a) {

        String sql= "UPDATE users SET  password="+a.getPassword()+", firstname="+a.getFirstName() +
                ", lastname="+a.getLastName() +", email="+a.getEmail() +"WHERE id=" +a.getId()+";";
        connectAndExecute(sql);
    }

    public Doctor getDoctorDetails (String id) {
        String sql = "SELECT * FROM users WHERE id="+id;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            Date date=format.parse(rs.getString("birthdate"));

            return new Doctor(id,rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),date,rs.getString("gender"),rs.getInt("yearOfExperiens"));
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Admin getAdminDetails (String id) {
        String sql = "SELECT * FROM users WHERE id="+id;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            Date date=format.parse(rs.getString("birthdate"));
             return new Admin(id,rs.getString("firstname"),rs.getString("lastname"), rs.getString("email"), rs.getString("password"),rs.getString("gender") ,date);
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Patient getPatientDetails (String id) {
        String sql = "SELECT * FROM users WHERE id="+id;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            Date date=format.parse(rs.getString("birthdate"));
            return new Patient(id,rs.getString("firstname"),rs.getString("lastname"), rs.getString("email"), rs.getString("password"),rs.getString("gender") ,date,rs.getInt("weight"),rs.getInt("height"));
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteFromUsers(String id){
        String sql="DELETE FROM users WHERE id="+id;
        connectAndExecute(sql);
    }



}
