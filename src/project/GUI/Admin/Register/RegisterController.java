package project.GUI.Admin.Register;
import project.GUI.Admin.StartAdminView;


public class RegisterController {


    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(RegisterModel registerModel, RegisterView registerView) {
        this.registerModel = registerModel;
        this.registerView = registerView;

        initController();
    }

    private void initController() {

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

        registerView.setVisible(false);
        new StartAdminView(registerModel.admin);
    }
     private boolean checkNotNullFields()
     {
         if (registerView.getIdTextFiled().getText().equals("")|| registerView.getPasswordField().toString().equals("")||
                 registerView.getFirstnameTextField().getText().equals("")||registerView.getLastnameTextField().getText().equals("")||
                 registerView.getEmailTextField().getText().equals("")|| registerView.getDayBox().toString().equals("") ||registerView.getMonthBox().toString().equals("")||
                 registerView.getYearBox().toString().equals("") || checkGender().equals("") )
         {
            return false;
         }
         return true;
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

