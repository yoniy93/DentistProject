package project.GUI.General.Calendar;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

public class DateListener implements DateChangeListener {

    private DateTimePicker dateTimePicker;
    private String doctorID;

    public DateListener(DateTimePicker dateTimePicker, String doctorID) {
        this.dateTimePicker = dateTimePicker;
        this.doctorID = doctorID;
    }

    public void dateChanged(DateChangeEvent event) {

        if(event.getNewDate() != null){
            String date = convertDateToString(event.getNewDate().getDayOfMonth() , event.getNewDate().getMonthValue() , event.getNewDate().getYear());
            dateTimePicker.timePicker.getSettings().setVetoPolicy(new VetoPolicy(date, doctorID));
            dateTimePicker.timePicker.clear();
        }
    }

    private String convertDateToString (int day, int month, int year) {
        String dayString=Integer.toString(day);
        String monthString=Integer.toString(month);
        if (day<10)
            dayString="0"+dayString;
        if (month<10)
            monthString="0"+monthString;
        return dayString+"-"+monthString+"-"+year;
    }
}
