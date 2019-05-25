package project.GUI;

public class StartApp {

    public StartApp(){
        LoginModel loginM = new LoginModel();
        LoginView loginV = new LoginView();
        new LoginController(loginM, loginV);
    }
}
