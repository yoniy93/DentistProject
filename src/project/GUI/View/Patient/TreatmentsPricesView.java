package project.GUI.View.Patient;

import project.Database.Locations;
import project.Entities.Treatments;
import project.GUI.View.ExitButton;

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
    private JTextArea treatmentDescription= new JTextArea();


    private Font font = new Font("Ariel",Font.BOLD,14);

    ExitButton exitButton = new ExitButton();

    public TreatmentsPricesView() {
        setLayout(null);
        setLocationAndSize();
        setLablesFont();
        addComponentsToFrame();

        setTitle("Search Your Treatment: ");
        setBounds(550, 150, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        this.
        treatmentsComboBox.setBounds(450, 100, 200, 50);

        treatmentPrices.setBounds(150, 300, 50 , 30);
        treatmentPricesLable.setBounds(100,300,100,30);
        treatmentPrices.setBackground(Color.WHITE);
        treatmentPrices.setOpaque(true);
        treatmentPrices.setHorizontalAlignment(JTextField.CENTER);
        treatmentPrices.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        treatmentDescription.setBounds(200,350, 400,40);
        treatmentDescriptionLable.setBounds(100 , 350, 200,30);
        treatmentDescription.setBackground(Color.WHITE);
        treatmentDescription.setOpaque(true);

        treatmentDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        treatmentDuration.setBounds(430, 300,50,30);
        treatmentDuration.setOpaque(true);
        treatmentDuration.setHorizontalAlignment(JTextField.CENTER);
        treatmentDurationLable.setBounds(300,300,150,30);
        treatmentDuration.setBackground(Color.WHITE);
        treatmentDuration.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));




        exitButton.setLocation(500,400,120,30);

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
        this.add(exitButton);
        this.add(backGround);
    }

    private void setLablesFont(){
        treatmentPricesLable.setFont(font);
        treatmentDurationLable.setFont(font);
        treatmentDescriptionLable.setFont(font);
    }

    public void setTreatmentList(List<Treatments> treatmentsList) {
        treatmentsComboBox.removeAllItems();
        treatmentsList.forEach(treatment -> treatmentsComboBox.addItem(treatment));
        treatmentsComboBox.setSelectedIndex(-1);
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
        exitButton.addActionListener((cancel));
    }
}
