package project.Entities;

import java.util.*;

public class Admin extends User {

    public Admin(String lastname, String firstname,String id , String gender, Date dateOfBirth , String pSW, String email)
    {
        this.setUserRole(USER_TYPE.ADMIN);
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setDateOfBirth(dateOfBirth);
        this.setEmail(email);
        this.setGender(gender);
        this.setId(id);
        this.setPassword(pSW);
    }

}
