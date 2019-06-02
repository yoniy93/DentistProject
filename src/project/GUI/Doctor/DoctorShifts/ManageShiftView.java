/*
package project.GUI.Doctor.DoctorShifts;

import com.github.lgooddatepicker.components.*;
import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import static com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement.OneHour;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;

public class ManageShiftView extends JFrame {

    JPanel dateTimePanel = new JPanel();
    DateTimePicker dateTimePicker = new DateTimePicker();

    public ManageShiftView(){
        setLayout(null);
        setLocationAndSize();

        setDateSettings();
        setTimeSettings();

        addComponentsToFrame();

        setBounds(0, 0, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        dateTimePanel.setBounds(100, 100, 400, 400);
    }

    private void addComponentsToFrame() {
        dateTimePanel.add(dateTimePicker);
        add(dateTimePanel);
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

    private static class VetoPolicy implements DateVetoPolicy
    {
        @Override
        public boolean isDateAllowed(LocalDate date)
        {
            if(date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusDays(90)) || date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY )
                return false;
            else
                return true;
        }
    }
}

 */