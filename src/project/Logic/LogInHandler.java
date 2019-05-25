package project.Logic;

import project.Entities.USER_TYPE;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInHandler {

    private ResultSet resultSet;
    public LogInHandler (String id){
        SelectApp select=new SelectApp();
        resultSet=select.getUserNamePasswordAndRole(id);
    }

    public USER_TYPE getUserType (String username) throws SQLException {

        String userType=resultSet.getString("userrole");
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

    public boolean isPasswordCorrect (String password) throws SQLException {
        return resultSet.getString("password").equals(password);
    }

    public boolean isUserExists (String id) throws SQLException {
        return resultSet.getString("id").equals(id) ;
    }
}
