package project.GUI.Controller.Calender;

import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;
import project.Database.DBQuerys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class VetoPolicy implements DateVetoPolicy, TimeVetoPolicy {
    private String date;
    private String doctorID;

    public VetoPolicy(){ }

    public VetoPolicy(String date, String doctorID){
        this.date = date;
        this.doctorID = doctorID;
    }

    @Override
    public boolean isDateAllowed(LocalDate date) {
        if(date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusDays(90)) || date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY )
            return false;
        else
            return true;
    }

    @Override
    public boolean isTimeAllowed(LocalTime localTime) {
        String time = localTime.toString();
        DBQuerys databaseQueries = new DBQuerys();

        return databaseQueries.isAvailableTime(doctorID,date,time);
    }
}