package project.GUI.Admin.Register;

import project.Logic.DBInserts;

public class RegisterController {


    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(RegisterModel registerModel, RegisterView registerView)
    {
        this.registerModel=registerModel;
        this.registerView=registerView;

       initController();
    }

    private void initController()
    {
        registerView.getAddUser().addActionListener(e->addUserAction());
    }

   private void addUserAction()
    {
        String roleSelection =registerView.getRoleGroup().getSelection().toString();
        String genderSelection=registerView.getGenderGroup().getSelection().toString();
        String bDay=registerView.getDayBox().toString() + registerView.getMonthBox() + registerView.getYearBox();
        if(roleSelection=="Patient")
        {
            registerModel.dbInserts.insertForPatient
                    (registerView.getIdTextFiled().toString(),registerView.getPasswordField().toString(),
                    registerView.getFirstnameTextField().toString(),registerView.getLastnameTextField().toString(),
                    registerView.getEmailTextField().toString(),Double.parseDouble(registerView.getWeightTextField().toString()),
                    Integer.parseInt(registerView.getHeightTextField().toString()),bDay,genderSelection);
        }
        else
        {
            registerModel.dbInserts.insertForDoctor
                    (registerView.getIdTextFiled().toString(),registerView.getPasswordField().toString(),
                    registerView.getFirstnameTextField().toString(),registerView.getLastnameTextField().toString(),
                    registerView.getEmailTextField().toString(),bDay,genderSelection,Integer.parseInt(registerView.getYearsOfExTextField().toString()));
        }
    }
}
