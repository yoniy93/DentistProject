package project.GUI.Admin.Register;

import project.GUI.General.ErrorWindow;

import java.awt.*;

public class RegisterController {

    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(RegisterModel registerModel, RegisterView registerView) {
        this.registerModel = registerModel;
        this.registerView = registerView;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        registerView.getAddUser().addActionListener(e -> addUserAction());
        registerView.getDoctor().addActionListener(e-> setVisibleTextFieldForDoctor());
        registerView.getPatient().addActionListener(e-> setVisibleTextFieldForPatient());
        registerView.getCancleButton().addActionListener(e-> registerView.dispose());
    }

    private void setVisibleTextFieldForDoctor(){
        registerView.getYearsOfExTextField().setBackground(Color.WHITE);
        registerView.getYearsOfExTextField().setEditable(true);
        registerView.hidePatientWeightAndHeightButtoms();
    }

    private void setVisibleTextFieldForPatient(){
        registerView.getWeightTextField().setEditable(true);
        registerView.getWeightTextField().setBackground(Color.WHITE);
        registerView.getHeightTextField().setEditable(true);
        registerView.getHeightTextField().setBackground(Color.WHITE);
        registerView.hideDoctorYearsOfExperiensButtoms();
    }


    private void addUserAction() {
     if (isAllFieldsFilled()) {
         if (registerView.getPatient().isSelected()) {
             registerModel.dbInserts.insertForPatient
                     (registerView.getIdTextFiled().getText(), getPassword(),
                             registerView.getFirstnameTextField().getText(), registerView.getLastnameTextField().getText(),
                             registerView.getEmailTextField().getText(), Double.parseDouble(registerView.getWeightTextField().getText()),
                             Integer.parseInt(registerView.getHeightTextField().getText()), getDate(), convertGenderToString());
         } else if (registerView.getDoctor().isSelected()) {
             registerModel.dbInserts.insertForDoctor
                     (registerView.getIdTextFiled().getText(), getPassword(),
                             registerView.getFirstnameTextField().getText(), registerView.getLastnameTextField().getText(),
                             registerView.getEmailTextField().getText(), getDate(), convertGenderToString(), Integer.parseInt(registerView.getYearsOfExTextField().getText()));
         }
         new ErrorWindow(registerView,"New use created successfully");
         registerView.dispose();
     }
     else
        new ErrorWindow(registerView,"Error: please fill all fields");
    }

    private boolean isAllFieldsFilled() {
        if ( registerView.getIdTextFiled().getText().equals("") || getPassword().equals("") || registerView.getFirstnameTextField().getText().equals("") ||
                registerView.getLastnameTextField().getText().equals("")|| registerView.getEmailTextField().getText().equals("")|| getDate().equals("") ||
                (!registerView.getPatient().isSelected() && !registerView.getDoctor().isSelected()) ||
                (!registerView.getFemale().isSelected() && !registerView.getMale().isSelected()) ) {
            return false;
        }
        else {
            if (registerView.getDoctor().isSelected())
                return registerView.getYearsOfExTextField().getText().equals("");
            else
                return !registerView.getWeightTextField().getText().equals("") && !registerView.getHeightTextField().getText().equals("");
        }
    }

    private String getPassword() {
        return new String(registerView.getPasswordField().getPassword());
    }

    private String getDate() {
        int day = (Integer)registerView.getDayBox().getSelectedItem();
        int month = (Integer)registerView.getMonthBox().getSelectedItem();
        int year =(Integer)registerView.getYearBox().getSelectedItem();
        return convertDateToString(day,month,year);
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


    private String convertGenderToString() {
        String genderSelection;
        if (registerView.getMale().isSelected())
            genderSelection = "Male";
        else
            genderSelection = "Female";
        return genderSelection;
    }

}

