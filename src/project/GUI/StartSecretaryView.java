package project.GUI;

public class StartSecretaryView {
    public StartSecretaryView(){
        SecretaryModel secretaryM = new SecretaryModel();
        SecretaryView secretaryV = new SecretaryView();
        new SecretaryController(secretaryM, secretaryV);
    }
}
