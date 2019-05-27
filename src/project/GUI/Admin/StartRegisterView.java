package project.GUI.Admin;

import project.Entities.Admin;

public class StartRegisterView {

        public StartRegisterView(Admin admin){
            RegisterModel registerModel = new RegisterModel(admin);
            RegisterView registerView = new RegisterView();
            new RegisterController(registerModel, registerView);
        }
}
