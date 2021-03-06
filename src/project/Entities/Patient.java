package project.Entities;
import java.util.*;

public class Patient extends User {

    private double height;
    private double weight;

    public Patient(String id, String password, String firstname, String lastname, String email, double weight, double height, Date dateOfBirth, String gender,String phoneNumber)
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
