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
        heightLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        heightLabel.setBounds(60, 200, 100, 30);

        weightLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        weightLabel.setBounds(60, 240, 100, 30);

        heightTextField.setBounds(170, 200, 150, 30);
        weightTextFiled.setBounds(170, 240, 150, 30);
    }

    private void addComponentsToFrame() {
        add(heightLabel);
        add(weightLabel);

        add(heightTextField);
        add(weightTextFiled);
    }

    public JTextField getHeightTextField() {
        return heightTextField;
    }

    public JTextField getWeightTextFiled() {
        return weightTextFiled;
    }
}
