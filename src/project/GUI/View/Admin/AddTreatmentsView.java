package project.GUI.View.Admin;

import project.Database.Locations;
import project.GUI.View.ExitButton;

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
    private JLabel treatmentDescription=new JLabel("Description:");


    private JTextField treatmentNameTextField=new JTextField(); //field to enter name of treatment
    private JTextField treatmentDurationTextField=new JTextField();//field to enter duration of treatment
    private JTextField treatmentPriceTextField=new JTextField();//field to enter price of treatment



    private JTextField treatmentDescriptionTextField=new JTextField();//field to enter description of treatment


    private JButton addTreatment=new JButton("Submit");
    ExitButton exitButton =new ExitButton();

    public AddTreatmentsView() {

        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Add New Treatment:");
        setBounds(550, 150, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

        treatmentName.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentName.setBounds(60,100,100,30);
        treatmentNameTextField.setBounds(160, 100, 150, 30);

        treatmentDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentDuration.setBounds(60,150,100,30);
        treatmentDurationTextField.setBounds(160,150,150,30);

        treatmentPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentPrice.setBounds(60,200,100,30);
        treatmentPriceTextField.setBounds(160, 200, 150, 30);

        treatmentDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentDescription.setBounds(60,250,100,30);
        treatmentDescriptionTextField.setBounds(160,250,400,60);

        addTreatment.setBounds(150,400,120,30);
        addTreatment.setFont(new Font("Ariel",Font.BOLD, 12));
        exitButton.setLocation(400,400,120,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame() {
        add(treatmentName);
        add(treatmentNameTextField);
        add(treatmentDuration);
        add(treatmentDurationTextField);
        add(treatmentDescription);
        add(treatmentDescriptionTextField);

        add(treatmentPrice);
        add(treatmentPriceTextField);
        add(exitButton);
        add(addTreatment);
        add(backGround);

    }

    //set action listener to window
    public void setActions(ActionListener add,ActionListener cancel) {
        getAddTreatment().addActionListener(add); //action listener to add button
        getCancel().addActionListener(cancel); //action listener to cancel button
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
           !getTreatmentPriceText().equals("") &&
           !getTreatmentDescriptionText().equals(""))
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

    //get the string value entered to field

    public String getTreatmentDescriptionText() {
        return treatmentDescriptionTextField.getText();
    }

    private JButton getAddTreatment() {
        return addTreatment;
    }

    private  JButton getCancel() {
        return exitButton;
    }




}
