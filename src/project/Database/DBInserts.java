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

        insertForDoctor("2", "1", "Amit", "Aflalo", "amit@gmail.com", "1994-07-10", "female", 3,"0547690750");
        insertForDoctor("3", "1", "Doctor", "doc", "amit@gmail.com", "1992-07-01", "female", 3,"0547690750");

        insertForPatient("4", "1", "Yonatan", "Yardeni", "yoni@gmail.com", 60.5, 178, "1990-10-10", "male","0547690740");
        insertForPatient("5", "1", "Ofir", "Gan", "offirgan@gmail.com", 56.5, 170, "2991-11-10", "male","0547690730");
    }

    private void initializeTreatments(){
        insertTreatment(1, "צילום", 30, 54.9);
        insertTreatment(2, "סתימה", 60, 99);
        insertTreatment(3, "גשר", 90, 150);
        insertTreatment(4, "הלבנה", 60, 69.9);
        insertTreatment(5, "שיננית", 30, 75);
    }

    private void initializeAppointments(){
        insertAppointments(1,5,"2019-07-3","10:00", "4", "3");
        insertAppointments(2,4,"2019-07-4","11:00", "4", "3");
        insertAppointments(3,2,"2019-07-5","12:00", "4", "3");
        insertAppointments(4,2,"2019-07-6","13:00", "4", "3");
        insertAppointments(5,2,"2019-07-7","08:00", "4", "3");
        insertAppointments(6,2,"2019-07-8","09:00", "5", "3");
        insertAppointments(7,3,"2019-07-9","10:00", "5", "3");
        insertAppointments(8,3,"2019-07-10","13:00", "5", "3");
        insertAppointments(9,4,"2019-07-11","08:00", "5", "3");
        insertAppointments(10,4,"2019-07-12","09:00", "5", "2");
        insertAppointments(11,4,"2019-07-13","10:00", "5", "2");
        insertAppointments(12,4,"2019-07-14","11:00", "4", "2");
        insertAppointments(13,2,"2019-07-15","12:00", "4", "2");
        insertAppointments(14,2,"2019-07-16","13:00", "4", "2");
        insertAppointments(15,2,"2019-07-17","15:00", "4", "2");
        insertAppointments(16,2,"2019-07-18","16:00", "4", "2");
        insertAppointments(17,3,"2019-07-19","10:00", "4", "2");
        insertAppointments(18,3,"2019-07-20","12:00", "4", "2");
        insertAppointments(19,4,"2019-07-20","08:00", "5", "2");
        insertAppointments(20,4,"2019-07-21","09:00", "5", "2");
        insertAppointments(21,4,"2019-07-22","10:00", "5", "2");
    }

    public String insertTreatment(int id,String name, int duration, double price){
        String sql="INSERT INTO treatments(id, treatmentname, durationmin, price)"+"" +
                " VALUES ('"+id+"', '"+name+"', '"+duration+"', '"+price+"');";
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
