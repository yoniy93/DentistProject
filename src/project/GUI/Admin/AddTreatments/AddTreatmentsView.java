package project.GUI.Admin.AddTreatments;

import project.Database.Locations;
import project.Entities.Treatments;
import project.GUI.General.CancelButton;
import project.GUI.General.MessageWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddTreatmentsView extends JFrame
{
    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);


    private JLabel treatmentName=new JLabel(" Name:");
    private JLabel treatmentDuration=new JLabel("Duration:");
    private JLabel treatmentPrice=new JLabel("Price:");

    private JTextField treatmentNameTextField=new JTextField();
    private JTextField treatmentDurationTextField=new JTextField();
    private JTextField treatmentPriceTextField=new JTextField();

    private JButton addTreatment=new JButton("Submit");
    CancelButton cancelButton=new CancelButton();

    public AddTreatmentsView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Add New Treatment:");
        setBounds(300, 20, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

        treatmentName.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentName.setBounds(60,80,100,30);
        treatmentNameTextField.setBounds(160, 80, 100, 30);

        treatmentDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentDuration.setBounds(60,120,100,30);
        treatmentDurationTextField.setBounds(160,120,100,30);

        treatmentPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentPrice.setBounds(60,160,100,30);
        treatmentPriceTextField.setBounds(160, 160, 100, 30);

        addTreatment.setBounds(150,250,120,30);
        addTreatment.setFont(new Font("Ariel",Font.BOLD, 12));
        cancelButton.setLocation(310,250,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame() {
        add(treatmentName);
        add(treatmentNameTextField);
        add(treatmentDuration);
        add(treatmentDurationTextField);

        add(treatmentPrice);
        add(treatmentPriceTextField);
        add(cancelButton);
        add(addTreatment);
        add(backGround);

    }

    public void setActions(ActionListener add,ActionListener cancel) {
        getAddTreatment().addActionListener(add);
        getCancel().addActionListener(cancel);
    }

    public Treatments addAction() {

        if (checkAllFields()) {
            return new Treatments("0", getTreatmentNameTextField().getText(),
                    Integer.parseInt(getTreatmentDurationTextField().getText()), Double.parseDouble(getTreatmentPriceTextField().getText()));
        }

        return null;
    }
    private boolean checkAllFields() {

        if(!getTreatmentNameTextField().getText().equals("") &&
           !getTreatmentDurationTextField().getText().equals("") &&
           !getTreatmentPriceTextField().getText().equals(""))
            return  true;
        else
            return false;
    }



    private JTextField getTreatmentNameTextField() {
        return treatmentNameTextField;
    }

    private JTextField getTreatmentDurationTextField() {
        return treatmentDurationTextField;
    }

    private JTextField getTreatmentPriceTextField() {
        return treatmentPriceTextField;
    }

    private JButton getAddTreatment() {
        return addTreatment;
    }

    private  JButton getCancel() {
        return cancelButton;
    }




}
