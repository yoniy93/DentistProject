package project.GUI.General.Calendar;

import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import java.time.LocalDate;

public class DateListener implements DateChangeListener {

    private TimePickerSettings timeSettings;
    public DateListener(TimePickerSettings settings)
    {
        timeSettings = settings;
    }

    public void dateChanged(DateChangeEvent event) {
        String date = convertDateToString(event.getNewDate().getDayOfMonth() , event.getNewDate().getMonthValue() , event.getNewDate().getYear());
        timeSettings.setVetoPolicy(new VetoPolicy(date));
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
