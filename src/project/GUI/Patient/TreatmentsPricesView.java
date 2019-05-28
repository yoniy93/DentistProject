package project.GUI.Patient;

import project.Logic.DBQuerys;

import javax.swing.*;

public class TreatmentsPricesView extends JFrame {


    private DBQuerys dbQuerys=new DBQuerys();
    private JComboBox treatmentList=new JComboBox(dbQuerys.getTreatments());
    private JTextField treatmentPrices= new JTextField();

    public TreatmentsPricesView()
    {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Search Your Treatment: ");
        setBounds(300, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {
        treatmentList.setBounds(170, 200, 200, 30);
        treatmentPrices.setBounds(250, 200, 200 , 30);
    }

    private void addComponentsToFrame()
    {
        add(treatmentList);
        add(treatmentPrices);
    }

    public JComboBox getTreatmentList() {
        return treatmentList;
    }

    public JTextField getTreatmentPrices() {
        return treatmentPrices;
    }


}
