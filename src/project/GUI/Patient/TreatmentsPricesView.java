package project.GUI.Patient;

import project.Entities.Treatments;
import project.Logic.DBQuerys;

import javax.swing.*;
import java.util.Vector;

public class TreatmentsPricesView extends JFrame {



   private DBQuerys dbQuerys=new DBQuerys();
    private JComboBox treatmentList=new JComboBox(dbQuerys.getTreatments());
    private JLabel treatmentPrices= new JLabel(" ");

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

    public JLabel getTreatmentPrices() {
        return treatmentPrices;
    }

    public void setTreatmentPrices(String price)
    {
        treatmentPrices=new JLabel(((String) price));
    }

   /* public void setTreatmentList(Vector<Treatments> treatmentList) {
      this.treatmentList=new JComboBox(treatmentList);
    }*/

}
