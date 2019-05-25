package project.Logic;

import project.Entities.USER_TYPE;

public class LogInHandler {


    public USER_TYPE getUserType (String username)  {
        return new Querys().getTypeOfUser(username);
    }

    public boolean isPasswordCorrect (String userid, String password) {
       return new Querys().isPasswordCorrect(userid,password);
    }

    public boolean isUserExists (String id) {
        return new Querys().isUserExists(id);
    }
}
