package project.Entities;
import java.util.*;
public class Patient extends User {

    private int height;
    private int weight;

    public Patient(String id, String password, String firstname, String lastname, String email, int weight, int height, Date dateOfBirth, String gender,String phoneNumber)
    {
        this.setUserRole(USER_TYPE.PATIENT);
        this.setId(id);
        this.setPassword(password);
        this.setFirstName(firstname);
        this.setLastName(lastname);
        this.setEmail(email);
        this.setWeight(weight);
        this.setHeight(height);
        this.setDateOfBirth(dateOfBirth);
        this.setGender(gender);
        this.setPhoneNumber(phoneNumber);
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
