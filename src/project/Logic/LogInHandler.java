package project.Logic;

import project.Entities.USER_TYPE;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInHandler {


    public USER_TYPE getUserType (String username)  {
        return new SelectApp().getTypeOfUser(username);
    }

    public boolean isPasswordCorrect (String userid,String password) throws SQLException {
       return new SelectApp().isPasswordCorrect(userid,password);
    }

    public boolean isUserExists (String id) throws SQLException {
        return new SelectApp().isUserExists(id);
    }
}
