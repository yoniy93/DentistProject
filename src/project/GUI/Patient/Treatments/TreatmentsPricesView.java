package project.GUI.Patient.Treatments;

import project.Database.Locations;
import project.Entities.Treatments;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TreatmentsPricesView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);

    Treatments a=new Treatments("1","default",50,100);
    private JComboBox<Treatments> treatmentList=new JComboBox<Treatments>();
    private JLabel treatmentPrices= new JLabel("מחיר");

    public TreatmentsPricesView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Search Your Treatment: ");
        setResizable(false);
    }

    private void setLocationAndSize() {
        this.setBounds(300, 100, 700, 500);
        treatmentList.setBounds(300, 200, 200, 30);
        treatmentPrices.setBounds(250, 200, 200 , 30);
        backGround.setBounds(0,0,700,500);
    }


    private void addComponentsToFrame() {
        treatmentList.addItem(a);
        this.add(treatmentList);
        this.add(treatmentPrices);
        this.add(backGround);
    }

    public JComboBox getTreatmentList() {
        return treatmentList;
    }

    public JLabel getTreatmentPrices() {
        return treatmentPrices;
    }

    public void setTreatmentPrices(String price) {
        treatmentPrices.setFont(new Font("Ariel",Font.BOLD,14));
        treatmentPrices.setText((String)price);
    }

    public void setTreatmentList(JComboBox treatmentList) {
        this.treatmentList = treatmentList;
    }

    public void setTreatmentList(List<Treatments> values) {
        this.treatmentList.removeAllItems();
        values.forEach(x -> this.treatmentList.addItem(x));
    }

    public void setVisible() {
        setVisible(true);
    }

}
