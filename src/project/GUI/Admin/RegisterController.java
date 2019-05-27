package project.GUI.Admin;

public class RegisterController {

    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(RegisterModel registerModel, RegisterView registerView)
    {
        this.registerModel=registerModel;
        this.registerView=registerView;

        addViewActionListeners();
    }

    private void addViewActionListeners()
    {

    }
}
