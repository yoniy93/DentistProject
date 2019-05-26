package project.Logic;

import project.Entities.USER_TYPE;

public class LogInHandler {

    public USER_TYPE getUserType (String username)  {
        return new DatabaseQuerys().getTypeOfUser(username);
    }

    public boolean isPasswordCorrect (String userid, String password) {
       return new DatabaseQuerys().isPasswordCorrect(userid,password);
    }

    public boolean isUserExists (String id) {
        return new DatabaseQuerys().isUserExists(id);
    }
}
