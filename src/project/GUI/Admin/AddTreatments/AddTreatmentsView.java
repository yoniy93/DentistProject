package project.GUI.Admin.AddTreatments;

import project.Database.Locations;
import project.Entities.Treatments;
import project.GUI.General.CancelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//Window to add new treatment to clinic . Possible only for Admin.
public class AddTreatmentsView extends JFrame
{
    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);


    private JLabel treatmentName=new JLabel(" Name:");
    private JLabel treatmentDuration=new JLabel("Duration:");
    private JLabel treatmentPrice=new JLabel("Price:");

    private JTextField treatmentNameTextField=new JTextField(); //field to enter name of treatment
    private JTextField treatmentDurationTextField=new JTextField();//field to enter duration of treatment
    private JTextField treatmentPriceTextField=new JTextField();//field to enter price of treatment

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

    //set action listener to window
    public void setActions(ActionListener add,ActionListener cancel) {
        getAddTreatment().addActionListener(add); //action listener to add button
        getCancel().addActionListener(cancel); //action listener to cancl button
    }


    public Boolean addAction() {

        if (checkAllFields())
           return true;
        return false;
    }

    //Check if all information about the new treatment is filled by Admin
    private boolean checkAllFields() {

        if(!getTreatmentNameText().equals("") &&
           !getTreatmentDurationText().equals("") &&
           !getTreatmentPriceText().equals(""))
            return  true;
        else
            return false;
    }


    //get the string value entered to field
    public String getTreatmentNameText() {
        return treatmentNameTextField.getText();
    }

    //get the string value entered to field
    public String getTreatmentDurationText() {
        return treatmentDurationTextField.getText();
    }

    //get the string value entered to field
    public String getTreatmentPriceText() {
        return treatmentPriceTextField.getText();
    }

    private JButton getAddTreatment() {
        return addTreatment;
    }

    private  JButton getCancel() {
        return cancelButton;
    }




}
