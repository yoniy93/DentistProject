package project.Entities;
import java.util.*;
public class Doctor extends User{


    private int yearsOfEx;

    public Doctor(String lastname, String firstname,String id , String gender, Date dateOfBirth , String pSW, String email)
    {
            this.setUserRole("D");
            this.setLastName(lastname);
            this.setFirstName(firstname);
            this.setDateOfBirth(dateOfBirth);
            this.setEmail(email);
            this.setGender(gender);
            this.setId(id);
            this.setPassword(pSW);

    }

    public int getYearsOfEx() {
        return yearsOfEx;
    }

    public void setYearsOfEx(int yearsOfEx) {
        this.yearsOfEx = yearsOfEx;
    }

}
