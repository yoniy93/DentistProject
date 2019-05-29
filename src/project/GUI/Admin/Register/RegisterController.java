package project.GUI.Admin.Register;

import javax.swing.*;

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
    }

    private void addUserAction() {
     if(   checkNotNullFields()) {
         //String bDay = registerView.getDayBox().toString() +"-"+ registerView.getMonthBox().toString() +"-"+ registerView.getYearBox().toString();
         if (registerView.getPatient().isSelected()) {
             registerModel.dbInserts.insertForPatient
                     (registerView.getIdTextFiled().getText(), getPassword(),
                             registerView.getFirstnameTextField().getText(), registerView.getLastnameTextField().getText(),
                             registerView.getEmailTextField().getText(), Double.parseDouble(registerView.getWeightTextField().getText()),
                             Integer.parseInt(registerView.getHeightTextField().getText()), getDateStr(), checkGender());
         } else {
             registerModel.dbInserts.insertForDoctor
                     (registerView.getIdTextFiled().getText(), getPassword(),
                             registerView.getFirstnameTextField().getText(), registerView.getLastnameTextField().getText(),
                             registerView.getEmailTextField().getText(), getDateStr(), checkGender(), Integer.parseInt(registerView.getYearsOfExTextField().getText()));
         }
     }
        JOptionPane.showMessageDialog(registerView, "New User Created");
        registerView.dispose();
    }

    private boolean checkNotNullFields() {
        if (registerView.getIdTextFiled().getText().equals("")|| getPassword().equals("")||
                registerView.getFirstnameTextField().getText().equals("")||registerView.getLastnameTextField().getText().equals("")||
                registerView.getEmailTextField().getText().equals("")|| getDateStr().equals("") || checkGender().equals("") )
        {
            JOptionPane.showMessageDialog(registerView,"One or more of the values worng !");return false;
        }
        return true;
    }

    private String getPassword(){
        return new String(registerView.getPasswordField().getPassword());
    }

    private String getDateStr(){

        int dayInt = (Integer)registerView.getDayBox().getSelectedItem();
        int monthInt = (Integer)registerView.getMonthBox().getSelectedItem();

        String dayStr = Integer.toString(dayInt);
        String monthStr = Integer.toString(monthInt);
        String yearStr =  Integer.toString ((Integer)registerView.getYearBox().getSelectedItem());

        if(dayInt < 10)
            dayStr = "0" + dayStr;

        if (monthInt < 10)
            monthStr = "0" + monthStr;

        return dayStr + "-" + monthStr + "-" + yearStr;
    }

    private String checkGender() {
        String genderSelection;
        if (registerView.getMale().isSelected())
            genderSelection = "Male";
        else
            genderSelection = "Female";
        return genderSelection;
    }

}

