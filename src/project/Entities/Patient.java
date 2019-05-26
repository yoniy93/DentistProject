package project.Entities;
import java.util.*;
public class Patient extends User {

    private int weight;
    private int height;
    private USER_TYPE userRole;

    public Patient(String id, String firstname, String lastname, String gender, String email, String pswd, Date dateOfBirth, int weight, int height)
    {
        this.setUserRole(USER_TYPE.DOCTOR);
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setDateOfBirth(dateOfBirth);
        this.setEmail(email);
        this.setGender(gender);
        this.setId(id);
        this.setPassword(pswd);
        this.weight=weight;
        this.height=height;

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
