package project.GUI.Patient.Treatments;

import project.Database.Locations;
import project.Entities.Treatments;
import project.GUI.General.CancelButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TreatmentsPricesView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private JComboBox<Treatments> treatmentListComboBox =new JComboBox<Treatments>();
    private JLabel treatmentPricesLable= new JLabel("Price:");
    private JLabel treatmentDurationLable = new JLabel("Duration (min):");
    private JLabel treatmentDescriptionLable= new JLabel("Description:");
    private JLabel treatmentPrices= new JLabel();
    private JLabel treatmentDuration = new JLabel();
    private JLabel treatmentDescription= new JLabel();



    private Font buttonFont=new Font("Ariel",Font.BOLD,14);

    CancelButton cancelButton=new CancelButton();



    public TreatmentsPricesView() {
        setLayout(null);
        setLocationAndSize();
        setLablesFont();
        addComponentsToFrame();
        setTitle("Search Your Treatment: ");
        setResizable(false);
    }

    private void setLocationAndSize() {
        this.setBounds(300, 100, 700, 500);
        treatmentListComboBox.setBounds(400, 100, 200, 50);

        treatmentPrices.setBounds(300, 300, 100 , 30);
        treatmentPricesLable.setBounds(250,300,100,30);

        treatmentDescription.setBounds(450,250, 200,30);
        treatmentDescriptionLable.setBounds(350 , 250, 100,30);

        treatmentDuration.setBounds(550, 300,100,30);
        treatmentDurationLable.setBounds(430,300,150,30);

        cancelButton.setLocation(500,400,120,30);

        backGround.setBounds(0,0,700,500);
    }


    private void addComponentsToFrame() {
        this.add(treatmentDescription);
        this.add(treatmentDescriptionLable);
        this.add(treatmentDuration);
        this.add(treatmentDurationLable);
        this.add(treatmentPricesLable);
        this.add(treatmentListComboBox);
        this.add(treatmentPrices);
        this.add(cancelButton);
        this.add(backGround);
    }

    private void setLablesFont(){
        this.treatmentPricesLable.setFont(getButtonFont());
        this.treatmentDurationLable.setFont(getButtonFont());
        this.treatmentDescriptionLable.setFont(getButtonFont());

    }

    public JComboBox getTreatmentListComboBox() {
        return treatmentListComboBox;
    }

    public void setTreatmentInfo(String price,String duration, String description) {
        treatmentPrices.setFont(getButtonFont());
        treatmentPrices.setText(price);
        treatmentDuration.setFont(getButtonFont());
        treatmentDuration.setText(duration);
        treatmentDescription.setFont(getButtonFont());
        treatmentDescription.setText(description);
    }

    public void setTreatmentList(List<Treatments> values) {
        this.treatmentListComboBox.removeAllItems();
        values.forEach(x -> this.treatmentListComboBox.addItem(x));
    }

    public void setVisible() {
        setVisible(true);
    }

    public Font getButtonFont() {
        return buttonFont;
    }

}
