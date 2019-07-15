package project.GUI.View.Patient;

import project.Database.Locations;
import project.Entities.Treatments;
import project.GUI.General.CancelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TreatmentsPricesView extends JFrame {

    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JComboBox<Treatments> treatmentsComboBox = new JComboBox<Treatments>();

    private JLabel treatmentPricesLable = new JLabel("Price:");
    private JLabel treatmentDurationLable = new JLabel("Duration (min):");
    private JLabel treatmentDescriptionLable = new JLabel("Description:");

    private JLabel treatmentPrices = new JLabel();
    private JLabel treatmentDuration = new JLabel();
    private JLabel treatmentDescription= new JLabel();

    private Font font = new Font("Ariel",Font.BOLD,14);

    CancelButton cancelButton = new CancelButton();

    public TreatmentsPricesView() {
        setLayout(null);
        setLocationAndSize();
        setLablesFont();
        addComponentsToFrame();
        setTitle("Search Your Treatment: ");
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        this.setBounds(300, 100, 700, 500);
        treatmentsComboBox.setBounds(400, 100, 200, 50);

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
        this.add(treatmentsComboBox);
        this.add(treatmentPrices);
        this.add(cancelButton);
        this.add(backGround);
    }

    private void setLablesFont(){
        treatmentPricesLable.setFont(getFont());
        treatmentDurationLable.setFont(getFont());
        treatmentDescriptionLable.setFont(getFont());
    }

    public void setTreatmentList(List<Treatments> values) {
        this.treatmentsComboBox.removeAllItems();
        values.forEach(treatment -> this.treatmentsComboBox.addItem(treatment));
    }

    public Treatments getTreatment() {
        return (Treatments)treatmentsComboBox.getSelectedItem();
    }

    public void setTreatmentInfo(String price,String duration, String description) {
        treatmentPrices.setFont(getFont());
        treatmentPrices.setText(price);
        treatmentDuration.setFont(getFont());
        treatmentDuration.setText(duration);
        treatmentDescription.setFont(getFont());
        treatmentDescription.setText(description);
    }

    public void setActions(ActionListener select, ActionListener cancel) {
        treatmentsComboBox.addActionListener(select);
        cancelButton.addActionListener((cancel));
    }

    public Font getFont() {
        return font;
    }
}
