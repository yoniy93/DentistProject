package project.Logic;

import project.Entities.USER_TYPE;

public class LogInHandler {

    public USER_TYPE getUserType (String username) {

        String userType="check"; // להחליך לשליפה מהDB
        switch (userType){
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

    public boolean isPasswordCorrect (String id) {

        //SELECT FROM TABLE
        return id.equals("check");
    }

    public boolean isUserExists (String id) {
        //SELECT FROM TABLE
        return id.equals("check");
    }
}
