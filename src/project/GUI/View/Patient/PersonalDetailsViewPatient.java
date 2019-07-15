package project.GUI.View.Patient;

import project.Entities.Patient;
import project.GUI.General.PersonalDetailsView;
import javax.swing .*;
import java.awt.event.ActionListener;

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
        heightLabel.setBounds(60, 240, 100, 30);

        weightLabel.setFont(getButtonFont());
        weightLabel.setBounds(60, 280, 100, 30);

        heightTextField.setBounds(170, 240, 150, 30);
        weightTextFiled.setBounds(170, 280, 150, 30);
        getBackGround().setBounds(0,0,400,400);
    }

    private void addComponentsToFrame() {
        add(heightLabel);
        add(weightLabel);

        add(heightTextField);
        add(weightTextFiled);

        add(getBackGround());
    }

    public String getHeightText() {
        return heightTextField.getText();
    }

    public String getWeightText() {
        return weightTextFiled.getText();
    }

    protected void setHeightTextField(String height) {
        heightTextField.setText(height);
    }

    protected void setWeightTextFiled(String weight) {
        weightTextFiled.setText(weight);
    }

    public void initializeFields(Patient patient){
        initializeUserFields(patient);

        setHeightTextField(Integer.toString(patient.getHeight()));
        setWeightTextFiled(Double.toString(patient.getWeight()));
    }

    public void setActions(ActionListener edit, ActionListener cancel){
        getEditButton().addActionListener((edit));
        getCancelButton().addActionListener(cancel);
    }
}
