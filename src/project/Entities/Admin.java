package project.Entities;

import java.util.*;

public class Admin extends User {

    public Admin(String id ,String firstname,String lastname, String email,String pswd,  String gender, Date dateOfBirth )
    {
        this.setUserRole(USER_TYPE.ADMIN);
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setDateOfBirth(dateOfBirth);
        this.setEmail(email);
        this.setGender(gender);
        this.setId(id);
        this.setPassword(pswd);
    }
}
