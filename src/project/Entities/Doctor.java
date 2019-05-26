package project.Entities;
import java.util.*;
public class Doctor extends User{


    private int yearsOfEx;

    public Doctor(String id ,String pSW,String firstname,String lastname, String email, Date dateOfBirth ,String gender, int numYears)
    {
            this.setUserRole(USER_TYPE.DOCTOR);
            this.setLastName(lastname);
            this.setFirstName(firstname);
            this.setDateOfBirth(dateOfBirth);
            this.setEmail(email);
            this.setGender(gender);
            this.setId(id);
            this.setPassword(pSW);
            this.setYearsOfEx(numYears);
    }

    public int getYearsOfEx() {
        return yearsOfEx;
    }

    public void setYearsOfEx(int yearsOfEx) {
        this.yearsOfEx = yearsOfEx;
    }

}
