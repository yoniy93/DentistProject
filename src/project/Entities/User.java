package project.Entities;


public abstract class User extends Person {
    private String password;
    private String email;
    private String phoneNumber;
    private USER_TYPE userRole;

    public USER_TYPE getUserRole() {
        return userRole;
    }

    public void setUserRole(USER_TYPE userRole) {
        this.userRole = userRole;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
