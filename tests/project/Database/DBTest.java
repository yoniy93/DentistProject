package project.Database;

import org.junit.jupiter.api.*;
import project.Entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DBTest {

    static DBQuerys query;
    static Admin expectedAdmin;
    static Doctor expectedDoctor;
    static Patient expectedPatient;
    static Treatments expectedTreatment;

    @BeforeAll
    static void setUp() throws ParseException {

        DBInserts.loadDatabaseWithInitialData();
        query = new DBQuerys();

        Date adminBirthDate = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2000");
        expectedAdmin = new Admin("1", "1", "Admin", "Admin", "admin@gmail.com", adminBirthDate, "male","0547690760");

        Date doctorBirthDate = new SimpleDateFormat("dd-MM-yyyy").parse("13-05-1993");
        expectedDoctor = new Doctor("2", "1", "Amit", "Aflalo", "amit@gmail.com", doctorBirthDate , 3, "female","0547690750");

        Date patientBirthDate = new SimpleDateFormat("dd-MM-yyyy").parse("13-05-1993");
        expectedPatient = new Patient("3", "1", "Yonatan", "Yardeni", "yoni@gmail.com", 60.5, 178, patientBirthDate, "male","0547690740");

        expectedTreatment = new Treatments("2", "סתימה", 60, 99);
    }

    @Test
    void getAdminDetails() {
        Admin actualAdmin = query.getAdminDetails("1");

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
        Doctor actualDoctor = query.getDoctorDetails("2");

        assertEquals(expectedDoctor.getId(),actualDoctor.getId(), "Doctor ID Not Equal");
        assertEquals(expectedDoctor.getPassword(),actualDoctor.getPassword(), "Doctor Password Not Equal");
        assertEquals(expectedDoctor.getFirstName(),actualDoctor.getFirstName(), "Doctor First Name Not Equal");
        assertEquals(expectedDoctor.getLastName(),actualDoctor.getLastName(), "Doctor Last Name Not Equal");
        assertEquals(expectedDoctor.getEmail(),actualDoctor.getEmail(), "Doctor Email Not Equal");
        assertEquals(expectedDoctor.getDateOfBirth(),actualDoctor.getDateOfBirth(), "Doctor Birth Date Not Equal");
        assertEquals(expectedDoctor.getYearsOfEx(),actualDoctor.getYearsOfEx(), "Doctor Years Of Experience Not Equal");
        assertEquals(expectedDoctor.getGender(),actualDoctor.getGender(), "Doctor Gender Not Equal");
        assertEquals(expectedDoctor.getPhoneNumber(),actualDoctor.getPhoneNumber(), "Doctor Phone Number Not Equal");
    }

    @Test
    void getPatientDetails() {
        Patient actualPatient = query.getPatientDetails("3");

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
    }

    @Test
    void isPasswordCorrect() {
    }

    @Test
    void getTypeOfUser() {
    }

    @Test
    void getDoctors() {
    }

    @Test
    void getTreatments() {
    }
}