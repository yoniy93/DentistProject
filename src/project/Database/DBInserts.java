package project.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBInserts {
    DBInitializer dbInitializer=DBInitializer.getInstance();

    public void insertInitialData(){
        initializeUsers();
        initializeTreatments();
        initializeAppointments();
    }

    private void initializeUsers(){
        insertForAdmin("1", "1", "Admin", "Admin", "admin@gmail.com", "1993-07-100", "male","0547690760");

        insertForDoctor("319020111", "123456", "Amit", "Aflalo", "amit@gmail.com", "1994-07-10", "female", 3,"0547690750");
        insertForDoctor("312656366", "123456", "Dor", "Dadon", "dor123@gmail.com", "1992-07-01", "female", 3,"0547872750");

        insertForPatient("302208178", "123456", "Yonatan", "Yardeni", "yoniy93@gmail.com", 80.2, 182, "1993-05-13", "male","0547690740");
        insertForPatient("203254008", "123456", "Ofir", "Gan", "offirgan@gmail.com", 56.5, 170, "2991-11-10", "male","0547690730");
    }

    private void initializeTreatments(){
        insertTreatment(1, "Braces", 45, 59.9, "A dental brace is a device used to correct\n the alignment of teeth and bite-related problems");
        insertTreatment(2, "Fillngs and Repairs", 60, 99,"Dental fillings and repairs use restorative\n materials used to repair teeth which have been compromised due to cavities or trauma");
        insertTreatment(3, "Bridges and Implants", 90, 150,"Bridges and implants are two ways to replace\n a missing tooth or teeth");
        insertTreatment(4, "Teeth Whitening", 50, 69.9,"Teeth naturally darken with age, however staining may be caused by various foods\n and beverages such as coffee, tea and berries, some drugs such as tetracycline, smoking, or a trauma to a tooth");
        insertTreatment(5, "Crowns and Caps", 50, 75,"A crown or cap is a cover that fits over a tooth that has\n been damaged by decay, broken, badly stained or mis-shaped");
        insertTreatment(6, "Dentures", 40, 80,"Dentures are prosthetic devices replacing lost teeth");
        insertTreatment(7, "Root Canals", 30, 50,"Root canals treat diseases or absessed teeth");
        insertTreatment(8, "Extractions", 55, 74.9,"A severely damaged tooth may need to be extracted.\n Permanent teeth may also need to be removed for orthodontic treatment");
    }

    private void initializeAppointments(){
        insertAppointments(1,1,"2019-07-03","10:00", "302208178", "312656366");
        insertAppointments(2,2,"2019-07-04","11:00", "302208178", "312656366");
        insertAppointments(3,3,"2019-07-05","12:00", "302208178", "312656366");
        insertAppointments(4,4,"2019-07-06","13:00", "302208178", "312656366");
        insertAppointments(5,5,"2019-07-07","08:00", "302208178", "312656366");
        insertAppointments(6,6,"2019-07-08","09:00", "302208178", "319020111");
        insertAppointments(7,7,"2019-07-09","10:00", "302208178", "319020111");
        insertAppointments(8,8,"2019-07-10","13:00", "203254008", "319020111");
        insertAppointments(9,1,"2019-07-11","08:00", "203254008", "319020111");
        insertAppointments(10,2,"2019-07-12","09:00", "203254008", "319020111");
        insertAppointments(11,3,"2019-07-13","10:00", "203254008", "319020111");
        insertAppointments(12,4,"2019-07-14","11:00", "203254008", "319020111");
        insertAppointments(13,5,"2019-07-15","12:00", "203254008", "319020111");
        insertAppointments(14,6,"2019-07-16","13:00", "203254008", "319020111");
        insertAppointments(15,7,"2019-07-17","15:00", "302208178", "312656366");
        insertAppointments(16,8,"2019-07-18","16:00", "302208178", "312656366");
        insertAppointments(17,1,"2019-07-19","10:00", "302208178", "312656366");
        insertAppointments(18,2,"2019-07-20","12:00", "302208178", "312656366");
        insertAppointments(19,3,"2019-07-20","08:00", "302208178", "312656366");
        insertAppointments(20,4,"2019-07-21","09:00", "203254008", "312656366");
        insertAppointments(21,5,"2019-07-22","10:00", "203254008", "312656366");
    }

    public String insertTreatment(int id,String name, int duration, double price, String description){
        String sql="INSERT INTO treatments(id, treatmentname, durationmin, price, description)"+"" +
                " VALUES ('"+id+"', '"+name+"', '"+duration+"', '"+price+"', '"+description+"');";
        return dbInitializer.connectAndExecute(sql);
    }

    public String insertAppointments(int id,int treatmentID,String date, String time, String clientid, String doctorid){
        String sql="INSERT INTO appointments(id, treatmentID,appointmentDATE, appointmentTIME,clientID,doctorID)"+
                " VALUES ('"+id+"', '"+treatmentID+"', '"+date+"', '"+time+"', '"+clientid+"', '"+doctorid+"');";
        return dbInitializer.connectAndExecute(sql);
    }

    public String insertForAdmin (String id, String pswd, String name, String lname, String email, String bdate, String gender,String phoneNumber ){
        String sql="INSERT INTO users (id, password, firstname, lastname, email, birthdate, userRole, gender,phoneNumber)"+
                " VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"', 'A','" +gender+"', '"+phoneNumber+"');";
        return dbInitializer.connectAndExecute(sql);
    }

    public String insertForPatient (String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, String gender,String phoneNumber) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, weight, height, birthdate, userRole, gender, phoneNumber)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+wieght+"', '"+height+"', '"+bdate+"', 'P','"+gender +"', '"+phoneNumber+"');";
        return dbInitializer.connectAndExecute(sql);
    }

    public String insertForDoctor (String id, String pswd, String name, String lname, String email, String bdate, String gender,int yearofEx,String phoneNumber) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, birthdate, userRole,yearOfExperiens,gender,phoneNumber)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"','D','"+yearofEx+"', '"+gender+"', '"+phoneNumber+"');";
        return dbInitializer.connectAndExecute(sql);
    }
}
