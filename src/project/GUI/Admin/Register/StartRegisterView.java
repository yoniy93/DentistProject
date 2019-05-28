package project.GUI.Admin.Register;

import project.Entities.Admin;
import project.GUI.Admin.Register.RegisterController;
import project.GUI.Admin.Register.RegisterModel;
import project.GUI.Admin.Register.RegisterView;

public class StartRegisterView {

        public StartRegisterView(Admin admin){
            RegisterModel registerModel = new RegisterModel( admin);
            RegisterView registerView = new RegisterView();
            new RegisterController(registerModel, registerView);
        }
}
