package project.GUI.Login;

public class StartLoginView {

    public StartLoginView(){
        LoginModel loginM = new LoginModel();
        LoginView loginV = new LoginView();
        LoginController loginC = new LoginController(loginM, loginV);
        loginM.addObserver(loginC);
        loginV.addObserver(loginC);
    }
}
