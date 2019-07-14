package project.GUI.Login;

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
