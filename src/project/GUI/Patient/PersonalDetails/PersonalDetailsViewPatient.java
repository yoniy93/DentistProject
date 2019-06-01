package project.GUI.Patient.PersonalDetails;
import project.GUI.General.PersonalDetailsView;
import javax.swing .*;
import java.awt.*;

public class PersonalDetailsViewPatient extends PersonalDetailsView {

    private JLabel heightLabel = new JLabel("Height: ");
    private JLabel weightLabel = new JLabel("Weight: ");

    private JTextField heightTextField = new JTextField();
    private JTextField weightTextFiled = new JTextField();

    public PersonalDetailsViewPatient() {
        setLocationAndSize();
        addComponentsToFrame();
    }

    private void setLocationAndSize() {
        heightLabel.setFont(getButtonFont());
        heightLabel.setBounds(60, 200, 100, 30);

        weightLabel.setFont(getButtonFont());
        weightLabel.setBounds(60, 240, 100, 30);

        heightTextField.setBounds(170, 200, 150, 30);
        weightTextFiled.setBounds(170, 240, 150, 30);
        getBackGround().setBounds(0,0,400,400);
    }

    private void addComponentsToFrame() {
        add(heightLabel);
        add(weightLabel);

        add(heightTextField);
        add(weightTextFiled);

        add(getBackGround());
    }

    public JTextField getHeightTextField() {
        return heightTextField;
    }

    public JTextField getWeightTextFiled() {
        return weightTextFiled;
    }
}
