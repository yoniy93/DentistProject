package project.Database;

import org.junit.jupiter.api.*;
import project.Entities.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static project.Entities.USER_TYPE.*;

public class DBTest  {

    static private DBQuerys dbQuery;
    static private DBInserts dbInsert;
    static private DBUpdates dbUpdates;

    static private Admin expectedAdmin;
    static private Doctor expectedDoctor;
    static private Patient expectedPatient;
    static private Appointment expectedAppointment;
    static private Treatments expectedTreatment;

    static private int userID;
    static private String adminID;
    static private String doctorID;
    static private String patientID;
    static private int appointmentID;
    static private int treatmentID;

    static private String dateString = "2000-01-01";
    static private String timeString = "20:00";
    static private int timeInt = 2000;
    static private String  timeStringDifferent = "17:00";

    @BeforeAll
    static void setUp() throws ParseException {
        DBInitializer.loadDatabaseWithInitialData();
        dbQuery = new DBQuerys();
        dbInsert = new DBInserts();

        setExpectedValues();
        insertExpectedValues();
    }

    @AfterAll
    static void tearDown() {
        deleteExpectedValues();
    }

    static private void setExpectedValues() throws ParseException {
        userID = dbQuery.getLastId("users");
        adminID = Integer.toString(++userID);
        doctorID = Integer.toString(++userID);
        patientID = Integer.toString(++userID);

        appointmentID = dbQuery.getLastId("appointments") + 1;
        treatmentID = dbQuery.getLastId("treatments") +1 ;

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        Time time = new Time(timeInt);

        expectedAdmin = new Admin(adminID, "Password", "FirstName", "LastName", "Email@gmail.com", date, "male","0501234567");
        expectedDoctor = new Doctor(doctorID, "Password", "FirstName", "LastName", "Email@gmail.com", date,99 , "female","0501234567");
        expectedPatient = new Patient(patientID, "Password", "FirstName", "LastName", "Email@gmail.com",250.7 ,230 ,  date, "male","0501234567");
        expectedAppointment = new Appointment(Integer.toString(appointmentID), Integer.toString(treatmentID),date, time, patientID, doctorID);
        expectedTreatment = new Treatments(Integer.toString(treatmentID), "TestTreatment", 60, 99,"None");

    }

    static private void insertExpectedValues(){
        dbInsert.insertForAdmin(expectedAdmin.getId(),expectedAdmin.getPassword(),expectedAdmin.getFirstName(),expectedAdmin.getLastName(),expectedAdmin.getEmail(),dateString, expectedAdmin.getGender(),expectedAdmin.getPhoneNumber());
        dbInsert.insertForDoctor(expectedDoctor.getId(),expectedDoctor.getPassword(),expectedDoctor.getFirstName(),expectedDoctor.getLastName(),expectedDoctor.getEmail(),dateString, expectedDoctor.getGender(), expectedDoctor.getYearsOfExp(), expectedDoctor.getPhoneNumber());
        dbInsert.insertForPatient(expectedPatient.getId(),expectedPatient.getPassword(),expectedPatient.getFirstName(),expectedPatient.getLastName(),expectedPatient.getEmail(), expectedPatient.getWeight(), expectedPatient.getHeight(), dateString, expectedPatient.getGender(),expectedPatient.getPhoneNumber());
        dbInsert.insertAppointments(Integer.parseInt(expectedAppointment.getAppointmentID()), Integer.parseInt(expectedAppointment.getTreatmentID()), dateString, timeString, expectedAppointment.getPatientId(), expectedAppointment.getDoctorId());
        dbInsert.insertTreatment(Integer.parseInt(expectedTreatment.getId()),expectedTreatment.getName(),expectedTreatment.getDuration(),expectedTreatment.getPrice(),expectedTreatment.getDescription());
    }

    static private void deleteExpectedValues(){
        dbUpdates = new DBUpdates();

        dbUpdates.deleteUserFromDB(adminID);
        dbUpdates.deleteUserFromDB(doctorID);
        dbUpdates.deleteUserFromDB(patientID);
        dbUpdates.deleteAppointmentFromDB(Integer.toString(appointmentID));
        dbUpdates.deleteTreatmentFromDB(Integer.toString(treatmentID));
    }

    @Test
    void getAdminDetails() {
        Admin actualAdmin = dbQuery.getAdminDetails(adminID);

        assertEquals(expectedAdmin.getId(),actualAdmin.getId(), "Admin ID Not Equal");
        assertEquals(expectedAdmin.getPassword(),actualAdmin.getPassword(), "Admin Password Not Equal");
        assertEquals(expectedAdmin.getFirstName(),actualAdmin.getFirstName(), "Admin First Name Not Equal");
        assertEquals(expectedAdmin.getLastName(),actualAdmin.getLastName(), "Admin Last Name Not Equal");
        assertEquals(expectedAdmin.getEmail(),actualAdmin.getEmail(), "Admin Email Not Equal");
        assertEquals(expectedAdmin.getDateOfBirth(),actualAdmin.getDateOfBirth(), "Admin Birth Date Not Equal");
        assertEquals(expectedAdmin.getGender(),actualAdmin.getGender(), "Admin Gender Not Equal");
        assertEquals(expectedAdmin.getPhoneNumber(),actualAdmin.getPhoneNumber(), "Admin Phone Number Not Equal");
    }

    @Test
    void getDoctorDetails() {
        Doctor actualDoctor = dbQuery.getDoctorDetails(doctorID);

        assertEquals(expectedDoctor.getId(),actualDoctor.getId(), "Doctor ID Not Equal");
        assertEquals(expectedDoctor.getPassword(),actualDoctor.getPassword(), "Doctor Password Not Equal");
        assertEquals(expectedDoctor.getFirstName(),actualDoctor.getFirstName(), "Doctor First Name Not Equal");
        assertEquals(expectedDoctor.getLastName(),actualDoctor.getLastName(), "Doctor Last Name Not Equal");
        assertEquals(expectedDoctor.getEmail(),actualDoctor.getEmail(), "Doctor Email Not Equal");
        assertEquals(expectedDoctor.getDateOfBirth(),actualDoctor.getDateOfBirth(), "Doctor Birth Date Not Equal");
        assertEquals(expectedDoctor.getYearsOfExp(),actualDoctor.getYearsOfExp(), "Doctor Years Of Experience Not Equal");
        assertEquals(expectedDoctor.getGender(),actualDoctor.getGender(), "Doctor Gender Not Equal");
        assertEquals(expectedDoctor.getPhoneNumber(),actualDoctor.getPhoneNumber(), "Doctor Phone Number Not Equal");
    }

    @Test
    void getPatientDetails() {
        Patient actualPatient = dbQuery.getPatientDetails(patientID);

        assertEquals(expectedPatient.getId(),actualPatient.getId(), "Patient ID Not Equal");
        assertEquals(expectedPatient.getPassword(),actualPatient.getPassword(), "Patient Password Not Equal");
        assertEquals(expectedPatient.getFirstName(),actualPatient.getFirstName(), "Patient First Name Not Equal");
        assertEquals(expectedPatient.getLastName(),actualPatient.getLastName(), "Patient Last Name Not Equal");
        assertEquals(expectedPatient.getEmail(),actualPatient.getEmail(), "Patient Email Not Equal");
        assertEquals(expectedPatient.getWeight(),actualPatient.getWeight(), "Patient Weight Not Equal");
        assertEquals(expectedPatient.getHeight(),actualPatient.getHeight(), "Patient Height Not Equal");
        assertEquals(expectedPatient.getDateOfBirth(),actualPatient.getDateOfBirth(), "Patient Birth Date Not Equal");
        assertEquals(expectedPatient.getGender(),actualPatient.getGender(), "Patient Gender Not Equal");
        assertEquals(expectedPatient.getPhoneNumber(),actualPatient.getPhoneNumber(), "Patient Phone Number Not Equal");
    }

    @Test
    void isUserExists() {
        assertEquals(true,dbQuery.isUserExists(adminID), "User ID Need To Be Exist");
        assertEquals(false,dbQuery.isUserExists("-1"), "User ID Doesn't Need To Be Exist");
    }

    @Test
    void isPasswordCorrect() {
        assertEquals(true,dbQuery.isPasswordCorrect("1","1"), "Password Should Be Correct");
        assertEquals(false,dbQuery.isPasswordCorrect("1","-5"), "Password Should Be Not Correct");
    }

    @Test
    void getTypeOfUser() {
        assertEquals(ADMIN,dbQuery.getTypeOfUser(adminID), "User Type Should Be Admin");
        assertEquals(DOCTOR,dbQuery.getTypeOfUser(doctorID), "User Type Should Be Doctor");
        assertEquals(PATIENT,dbQuery.getTypeOfUser(patientID), "User Type Should Be Patient");
    }

    @Test
    void isAvailableTime(){
        assertEquals(false,dbQuery.isAvailableTime(doctorID, dateString, timeString), "Time Should Not Be Avaliable");
        assertEquals(true,dbQuery.isAvailableTime(doctorID,dateString, timeStringDifferent), "Time Should Be Avaliable");

    }

    @Test
    void getLastID(){
        assertEquals(userID, dbQuery.getLastId("users"), "Users id not right");
        assertEquals(appointmentID, dbQuery.getLastId("appointments"), "Appointment id not right");
        assertEquals(treatmentID, dbQuery.getLastId("treatments"), "Treatments id not right");

    }
}