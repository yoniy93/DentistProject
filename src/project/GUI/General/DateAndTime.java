package project.GUI.General;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import static com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement.OneHour;

import javax.swing.JPanel;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


public class DateAndTime extends JPanel {

    DateTimePicker dateTimePicker = new DateTimePicker();

    public DateAndTime(){
        setBackground(Color.CYAN);
        setDateSettings();
        setTimeSettings();
        dateTimePicker.setVisible(true);
        add(dateTimePicker);
        setVisible(true);
    }

    private void setDateSettings() {
        DatePickerSettings dateSettings = dateTimePicker.datePicker.getSettings();
        dateSettings.setVetoPolicy(new VetoPolicy());
        dateSettings.setVisibleTodayButton(false);
        dateSettings.setVisibleNextYearButton(false);
        dateSettings.setVisiblePreviousYearButton(false);
        dateSettings.setFirstDayOfWeek(DayOfWeek.SUNDAY);
    }

    private void setTimeSettings() {
        TimePickerSettings timeSettings = dateTimePicker.timePicker.getSettings();
        LocalTime start = LocalTime.of(8,0);
        LocalTime finish = LocalTime.of(17, 0);
        timeSettings.generatePotentialMenuTimes(OneHour,start,finish);
        timeSettings.setFormatForDisplayTime("hh:mm");
        timeSettings.use24HourClockFormat();
    }

    private static class VetoPolicy implements DateVetoPolicy {
        @Override
        public boolean isDateAllowed(LocalDate date)
        {
            if(date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusDays(90)) || date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY )
                return false;
            else
                return true;
        }
    }

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y,260,35);
    }

    public String getTime(){
        return dateTimePicker.getTimePicker().getText();
    }


    public String getDate() {
        return dateTimePicker.getDatePicker().getText();
    }
}
