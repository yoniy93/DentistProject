package project.GUI.Patient.Treatments;

import project.Database.Locations;
import javax.swing.*;

public class TreatmentsPricesView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);
    private JComboBox treatmentList;
    private JLabel treatmentPrices= new JLabel(" ");
    private JButton payForTreatment=new JButton("PAY");

    public TreatmentsPricesView(JComboBox treatmentList) {
        setLayout(null);
        setTreatmentList(treatmentList);
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Search Your Treatment: ");
        setBounds(300, 100, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

        treatmentList.setBounds(100, 400, 200, 30);
        treatmentPrices.setBounds(320, 400, 100 , 30);
        payForTreatment.setBounds(450,400,100,30);
        backGround.setBounds(0,0,700,500);
    }


    private void addComponentsToFrame() {
        add(payForTreatment);
        payForTreatment.setVisible(false);
        add(treatmentList);
        add(treatmentPrices);
        add(backGround);

    }

    public JComboBox getTreatmentList() {
        return treatmentList;
    }

    public JLabel getTreatmentPrices() {
        return treatmentPrices;
    }

    public void setTreatmentPrices(String price) {
        treatmentPrices.setText((String)price);
    }

    public void setTreatmentList(JComboBox treatmentList) {
        this.treatmentList = treatmentList;

    }

    public JButton getPayForTreatment()
    {
        return payForTreatment;
    }
    public void setPayForTreatment() {
         payForTreatment.setVisible(true);
    }

}
