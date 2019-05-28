package project.GUI.Admin.Register;

import project.Entities.Admin;
import project.GUI.Admin.Register.RegisterController;
import project.GUI.Admin.Register.RegisterModel;
import project.GUI.Admin.Register.RegisterView;

public class StartRegisterView {

        public StartRegisterView(){
            RegisterModel registerModel = new RegisterModel();
            RegisterView registerView = new RegisterView();
            new RegisterController(registerModel, registerView);
        }
}
