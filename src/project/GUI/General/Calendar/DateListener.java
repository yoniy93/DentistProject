package project.GUI.General.Calendar;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

public class DateListener implements DateChangeListener {

    private TimePicker timePicker;
    private String doctorID;

    public DateListener(TimePicker timePicker, String doctorID) {
        this.timePicker = timePicker;
        this.doctorID = doctorID;
    }

    public void dateChanged(DateChangeEvent event) {

        if(event.getNewDate() != null){
            String date = convertDateToString(event.getNewDate().getDayOfMonth() , event.getNewDate().getMonthValue() , event.getNewDate().getYear());
            timePicker.getSettings().setVetoPolicy(new VetoPolicy(date, doctorID));
            timePicker.clear();
        }
    }

    private String convertDateToString (int day, int month, int year) {
        String dayString=Integer.toString(day);
        String monthString=Integer.toString(month);
        if (day<10)
            dayString="0"+dayString;
        if (month<10)
            monthString="0"+monthString;
        return year+"-"+monthString+"-"+dayString;
    }
}
