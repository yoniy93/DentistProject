package project.Logic;

import project.Entities.Enum;

public class LogInHandler {

    public Enum.USER_TYPE getUserType (String username) {

        String userType="check"; // להחליך לשליפה מהDB
        switch (userType){
            case "A":
                return Enum.USER_TYPE.ADMIN;
            case "D":
                return Enum.USER_TYPE.DOCTOR;
            case "P":
                return Enum.USER_TYPE.PATIENT;
            case "S":
                return Enum.USER_TYPE.SECRETARY;
            default:
                return Enum.USER_TYPE.ERROR;
        }
    }

    public boolean isPasswordCorrect (String id) {
        //SELECT FROM TABLE
        return id.equals("check");
    }

    public boolean isUserExists (String password) {
        //SELECT FROM TABLE
        return password.equals("check");
    }
}
