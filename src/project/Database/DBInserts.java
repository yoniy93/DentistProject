package project.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBInserts extends DBInitializer {

    public void insertInitialData(){
        insertForAdmin("1", "1", "Admin", "Admin", "admin@gmail.com", "01-01-2000", "male","0547690760");
        insertForDoctor("2", "1", "Amit", "Aflalo", "amit@gmail.com", "13-05-1993", "female", 3,"0547690750");
        insertForPatient("3", "1", "Yonatan", "Yardeni", "yoni@gmail.com", 60.5, 178, "13-05-1993", "male","0547690740");
        insertForPatient("4", "1", "Ofir", "Gan", "offirgan@gmail.com", 56.5, 170, "04-09-1992", "male","0547690730");
        insertTreatment(2, "סתימה", 60, 99);
        insertTreatment(3, "גשר", 90, 150);
        insertTreatment(4, "הלבנה", 60, 69.9);
        insertTreatment(5, "שיננית", 30, 75);
        insertMedicalEquipment(11, "מזרק", "12-12-2020", 5);
        insertMedicalEquipment(12, "מספריים", "12-12-2022", 5);
        insertMedicalEquipment(13, "סכין", "12-12-2024", 10);
        insertMedicalEquipment(14, "מנורה", "12-12-2024", 4);
        insertAppointments(1,"17-07-2019","10:00", "4", "2");
    }

    public String insertMedicalEquipment(int id,String name, String expiredate,int quantity){
        String sql="INSERT INTO medical_equipment(id, treatmentname, expiredate, quantity)"+
                " VALUES ('"+id+"', '"+name+"', '"+expiredate+"', '"+quantity+"');";
        return connectAndExecute(sql);

    }

    public String insertTreatment(int id,String name, int duration, double price){
        String sql="INSERT INTO treatments(id, treatmentname, durationmin, price)"+"" +
                " VALUES ('"+id+"', '"+name+"', '"+duration+"', '"+price+"');";
        return connectAndExecute(sql);
    }

    public String insertAppointments(int appointmentid,String date, String time, String clientid, String doctorid){
        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
        Date date_format;
        try {
            date_format=format.parse(date);
        } catch (ParseException e) {
            return "date error";
        }
        String sql="INSERT INTO appointments(treatmentID, appointmentDATE, appointmentTIME,clientID,doctorID)"+
                " VALUES ('"+appointmentid+"', '"+date_format+"', '"+time+"', '"+clientid+"', '"+doctorid+"');";
        return connectAndExecute(sql);
    }

    public String insertMedicines(int medicineid,String expiredate, int quantity, String name){
        String sql="INSERT INTO mediciens(medicineid, expiredate, quantity,medicinename)"+
                " VALUES ('"+medicineid+"', '"+expiredate+"', '"+quantity+"', '"+name+"');";
        return connectAndExecute(sql);
    }

    public String insertForAdmin (String id, String pswd, String name, String lname, String email, String bdate, String gender,String phoneNumber ){
        String sql="INSERT INTO users (id, password, firstname, lastname, email, birthdate, userRole, gender,phoneNumber)"+
                " VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"', 'A','" +gender+"', '"+phoneNumber+"');";
        return connectAndExecute(sql);
    }

    public String insertForPatient (String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, String gender,String phoneNumber) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, weight, height, birthdate, userRole, gender, phoneNumber)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+wieght+"', '"+height+"', '"+bdate+"', 'P','"+gender +"', '"+phoneNumber+"');";
        return connectAndExecute(sql);
    }

    public String insertForDoctor (String id, String pswd, String name, String lname, String email, String bdate, String gender,int yearofEx,String phoneNumber) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, birthdate, userRole,yearOfExperiens,gender,phoneNumber)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"','D','"+yearofEx+"', '"+gender+"', '"+phoneNumber+"');";
        return connectAndExecute(sql);
    }

}
