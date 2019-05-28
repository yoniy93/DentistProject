package project.Entities;

import java.util.*;

public class Admin extends User {

    public Admin(String id, String password, String firstname, String lastname, String email, Date dateOfBirth, String gender)
    {
        this.setUserRole(USER_TYPE.ADMIN);
        this.setId(id);
        this.setPassword(password);
        this.setFirstName(firstname);
        this.setLastName(lastname);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setGender(gender);
    }
}
