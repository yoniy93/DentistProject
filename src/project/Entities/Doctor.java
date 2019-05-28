package project.Entities;
import java.util.*;
public class Doctor extends User{


    private int yearsOfExp;

    public Doctor(String id, String password, String firstname, String lastname, String email, Date dateOfBirth, int yearsOfExp, String gender)
    {
        this.setUserRole(USER_TYPE.DOCTOR);

        this.setId(id);
        this.setPassword(password);
        this.setFirstName(firstname);
        this.setLastName(lastname);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setYearsOfEx(yearsOfExp);
        this.setGender(gender);
    }

    public int getYearsOfEx() {
        return yearsOfExp;
    }

    public void setYearsOfEx(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

}
