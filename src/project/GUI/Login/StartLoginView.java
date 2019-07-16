package project.GUI.Login;

import project.GUI.Login.Interfaces.Controller;
import project.GUI.Login.Interfaces.Model;
import project.GUI.Login.Interfaces.View;

public class StartLoginView {

    public StartLoginView(){
        Model loginM = new LoginModel();
        View loginV = new LoginView();
        Controller loginC = new LoginController(loginM, loginV);
        ((LoginModel)loginM).addObserver(loginC);
        ((LoginView)loginV).addObserver(loginC);

        loginV.startView();
    }
}
