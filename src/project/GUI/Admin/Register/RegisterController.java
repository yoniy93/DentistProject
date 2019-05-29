package project.GUI.Admin.Register;
import project.GUI.Admin.StartAdminView;

import javax.swing.*;
import java.util.Vector;


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
         String bDay = registerView.getDayBox().toString() +"-"+ registerView.getMonthBox().toString() +"-"+ registerView.getYearBox().toString();
         if (registerView.getPatient().isSelected()) {
             registerModel.dbInserts.insertForPatient
                     (registerView.getIdTextFiled().getText(), registerView.getPasswordField().toString(),
                             registerView.getFirstnameTextField().getText(), registerView.getLastnameTextField().getText(),
                             registerView.getEmailTextField().getText(), Double.parseDouble(registerView.getWeightTextField().getText()),
                             Integer.parseInt(registerView.getHeightTextField().getText()), bDay, checkGender());
         } else {
             registerModel.dbInserts.insertForDoctor
                     (registerView.getIdTextFiled().getText(), registerView.getPasswordField().toString(),
                             registerView.getFirstnameTextField().getText(), registerView.getLastnameTextField().getText(),
                             registerView.getEmailTextField().getText(), bDay, checkGender(), Integer.parseInt(registerView.getYearsOfExTextField().getText()));
         }
     }
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
        
       String dayStr = Integer.toString((Integer)registerView.getDayBox().getSelectedItem());
       String monthStr = Integer.toString((Integer)registerView.getMonthBox().getSelectedItem());
       String yearStr = Integer.toString ((Integer)registerView.getYearBox().getSelectedItem());

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

