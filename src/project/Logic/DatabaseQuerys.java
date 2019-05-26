package project.Logic;

import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.Entities.USER_TYPE;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseQuerys extends DatabaseHandler {

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
}
