package project.GUI.Admin.UnRegister;

import project.Entities.Admin;

public class StartUnRegister
{

    public StartUnRegister(Admin admin){
        UnRegisterModel registerModel = new UnRegisterModel( admin);
        UnRegisterView registerView = new UnRegisterView();
        new UnRegisterController(registerView, registerModel);
    }
}
