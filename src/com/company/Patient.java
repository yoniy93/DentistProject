package com.company;

public class Patient extends Person {

    private String gender;
    private int age;
    private int balance;

    public Patient(String lastName, String id, String userName, String password, String email, String firstName, String gender, int age, int balance) {
        super(lastName, id, userName, password, email, firstName);
        this.gender = gender;
        this.age = age;
        this.balance = balance;
    }
}
