package project.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBInserts {
    DBInitializer dbInitializer=DBInitializer.getInstance();

    public void insertInitialData(){
        initializeUsers();
        initializeTreatments();
        initializeEquipments();
        initializeAppointments();
    }

    private void initializeUsers(){
        insertForAdmin("1", "1", "Admin", "Admin", "admin@gmail.com", "01-01-2000", "male","0547690760");

        insertForDoctor("2", "1", "Amit", "Aflalo", "amit@gmail.com", "13-05-1993", "female", 3,"0547690750");
        insertForDoctor("3", "1", "Doctor", "doc", "amit@gmail.com", "13-05-1993", "female", 3,"0547690750");

        insertForPatient("4", "1", "Yonatan", "Yardeni", "yoni@gmail.com", 60.5, 178, "13-05-1993", "male","0547690740");
        insertForPatient("5", "1", "Ofir", "Gan", "offirgan@gmail.com", 56.5, 170, "04-09-1992", "male","0547690730");
    }

    private void initializeTreatments(){
        insertTreatment(1, "צילום", 30, 54.9);
        insertTreatment(2, "סתימה", 60, 99);
        insertTreatment(3, "גשר", 90, 150);
        insertTreatment(4, "הלבנה", 60, 69.9);
        insertTreatment(5, "שיננית", 30, 75);
    }

    private void initializeEquipments(){
        insertMedicalEquipment(1, "מזרק", "12-12-2020", 5);
        insertMedicalEquipment(2, "מספריים", "12-12-2022", 5);
        insertMedicalEquipment(3, "סכין", "12-12-2024", 10);
        insertMedicalEquipment(4, "מנורה", "12-12-2024", 4);

    }

    private void initializeAppointments(){
        insertAppointments(1,5,"17-07-2019","10:00", "4", "3");
        insertAppointments(2,4,"17-07-2019","11:00", "4", "3");
        insertAppointments(3,2,"17-07-2019","12:00", "4", "3");
        insertAppointments(4,2,"17-07-2019","13:00", "4", "3");
        insertAppointments(5,2,"18-07-2019","08:00", "4", "3");
        insertAppointments(6,2,"18-07-2019","09:00", "5", "3");
        insertAppointments(7,3,"18-07-2019","10:00", "5", "3");
        insertAppointments(8,3,"18-07-2019","13:00", "5", "3");
        insertAppointments(9,4,"21-07-2019","08:00", "5", "3");
        insertAppointments(10,4,"17-07-2019","09:00", "5", "2");
        insertAppointments(11,4,"17-07-2019","10:00", "5", "2");
        insertAppointments(12,4,"17-07-2019","11:00", "4", "2");
        insertAppointments(13,2,"17-07-2019","12:00", "4", "2");
        insertAppointments(14,2,"17-07-2019","13:00", "4", "2");
        insertAppointments(15,2,"18-07-2019","15:00", "4", "2");
        insertAppointments(16,2,"18-07-2019","16:00", "4", "2");
        insertAppointments(17,3,"21-07-2019","10:00", "4", "2");
        insertAppointments(18,3,"21-07-2019","12:00", "4", "2");
        insertAppointments(19,4,"22-07-2019","08:00", "5", "2");
        insertAppointments(20,4,"22-07-2019","09:00", "5", "2");
        insertAppointments(21,4,"12-07-2019","10:00", "5", "2");

    }

    public String insertMedicalEquipment(int id,String name, String expiredate,int quantity){
        String sql="INSERT INTO medical_equipment(id, treatmentname, expiredate, quantity)"+
                " VALUES ('"+id+"', '"+name+"', '"+expiredate+"', '"+quantity+"');";
        return dbInitializer.connectAndExecute(sql);

    }

    public String insertTreatment(int id,String name, int duration, double price){
        String sql="INSERT INTO treatments(id, treatmentname, durationmin, price)"+"" +
                " VALUES ('"+id+"', '"+name+"', '"+duration+"', '"+price+"');";
        return dbInitializer.connectAndExecute(sql);
    }

    public String insertAppointments(int id,int treatmentID,String date, String time, String clientid, String doctorid){
//        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
//        Date date_format;
//        try {
//            date_format=format.parse(date);
//        } catch (ParseException e) {
//            return "date error";
//        }
        String sql="INSERT INTO appointments(id, treatmentID,appointmentDATE, appointmentTIME,clientID,doctorID)"+
                " VALUES ('"+id+"', '"+treatmentID+"', '"+date+"', '"+time+"', '"+clientid+"', '"+doctorid+"');";
        return dbInitializer.connectAndExecute(sql);
    }

    public String insertMedicines(int medicineid,String expiredate, int quantity, String name){
        String sql="INSERT INTO mediciens(medicineid, expiredate, quantity,medicinename)"+
                " VALUES ('"+medicineid+"', '"+expiredate+"', '"+quantity+"', '"+name+"');";
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
