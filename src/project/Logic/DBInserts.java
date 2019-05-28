package project.Logic;

public class DBInserts extends DBHandler {

    public static void insertInitialData(){
        DBInserts dbInserts=new DBInserts();
        dbInserts.insertForAdmin("1", "1", "Admin", "Admin", "email", "01-01-2000", "male");
        dbInserts.insertForDoctor("2", "1", "check", "check", "check", "13-05-1993", "male", 3);
        dbInserts.insertForPatient("3", "1", "check", "check", "check", 60.5, 178, "13-05-1993", "female");
        dbInserts.insertTreatment(1, "שיננית", 30, 70.5);
        dbInserts.insertTreatment(2, "סתימה", 60, 99);
        dbInserts.insertTreatment(3, "גשר", 90, 150);
        dbInserts.insertTreatment(4, "הלבנה", 60, 69.9);
        dbInserts.insertMedicalEquipment(11, "מזלג", "12-12-2020", 4);
    }

    public void insertMedicalEquipment(int id,String name, String expiredate,int quantity){
        String sql="INSERT INTO medical_equipment(id, treatmentname, expiredate, quantity)"+
                " VALUES ('"+id+"', '"+name+"', '"+expiredate+"', '"+quantity+"');";
        connectAndExecute(sql);
    }

    public void insertTreatment(int id,String name, int duration, double price){
        String sql="INSERT INTO treatments(id, treatmentname, durationmin, price)"+"" +
                " VALUES ('"+id+"', '"+name+"', '"+duration+"', '"+price+"');";
        connectAndExecute(sql);
    }

    public void insertAppointments(int appointmentid,String date, String time, String clientid, String doctorid){
        String sql="INSERT INTO appointments(treatmentID, appointmentDATE, appointmentTIME,clientID,doctorID)"+
                " VALUES ('"+appointmentid+"', '"+date+"', '"+time+"', '"+clientid+"', '"+doctorid+"');";
        connectAndExecute(sql);
    }

    public void insertMedicines(int medicineid,String expiredate, int quantity, String name){
        String sql="INSERT INTO mediciens(medicineid, expiredate, quantity,medicinename)"+
                " VALUES ('"+medicineid+"', '"+expiredate+"', '"+quantity+"', '"+name+"');";
        connectAndExecute(sql);
    }

    public void insertForAdmin (String id, String pswd, String name, String lname, String email, String bdate, String gender ){
        String sql="INSERT INTO users (id, password, firstname, lastname, email, birthdate, userRole, gender)"+
                " VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"', 'A','" +gender+"');";
        connectAndExecute(sql);
    }

    public void insertForPatient (String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, String gender) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, weight, height, birthdate, userRole, gender)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+wieght+"', '"+height+"', '"+bdate+"', 'P','"+gender +"');";
        connectAndExecute(sql);
    }

    public void insertForDoctor (String id, String pswd, String name, String lname, String email, String bdate, String gender,int yearofEx) {
        String sql="INSERT INTO users(id, password, firstname, lastname, email, birthdate, userRole,yearOfExperiens,gender)" +
                "VALUES ('"+id+"', '"+pswd+"', '"+name+"', '"+lname+"', '"+email+"', '"+bdate+"','D','"+yearofEx+"', '"+gender+"');";
        connectAndExecute(sql);
    }

}
