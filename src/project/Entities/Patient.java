package project.Entities;
import java.util.*;
public class Patient extends User {

    private int weight;
    private int height;

    public Patient(String id, String firstname, String lastname, String gender, String email, String pswd, Date dateOfBirth, int weight, int height)
    {
        this.setUserRole(USER_TYPE.PATIENT);
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setDateOfBirth(dateOfBirth);
        this.setEmail(email);
        this.setGender(gender);
        this.setId(id);
        this.setPassword(pswd);
        this.setHeight(weight);
        this.setHeight(height);

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
