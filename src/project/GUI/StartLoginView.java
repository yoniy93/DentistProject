package project.GUI;

public class StartLoginView {
    public StartLoginView(){
        LoginModel loginM = new LoginModel();
        LoginView loginV = new LoginView();
        new LoginController(loginM, loginV);
    }
}
