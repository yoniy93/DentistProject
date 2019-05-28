package project.GUI.Patient.Treatments;

import project.Entities.Treatments;
import project.Logic.DBQuerys;

import javax.swing.*;
import java.util.Vector;

public class TreatmentsPricesView extends JFrame {

    private DBQuerys dbQuerys=new DBQuerys();
    private Vector<Treatments> treatmentsVector=dbQuerys.getTreatments();
    private String [] treatmentsName=new String[treatmentsVector.size()];
    private JComboBox treatmentList=new JComboBox(treatmentsName);
    private JLabel treatmentPrices= new JLabel(" ");

    public TreatmentsPricesView()
    {
        setTreatmentsVector();
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();


        setTitle("Search Your Treatment: ");
        setBounds(300, 100, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {
        treatmentList.setBounds(300, 200, 200, 30);
        treatmentPrices.setBounds(250, 200, 200 , 30);
    }

    private void addComponentsToFrame()
    {
        add(treatmentList);
        add(treatmentPrices);

    }

    public void setTreatmentsVector()
    {
        for(int i=0;i<treatmentsVector.size();i++)
        {
            treatmentsName[i]=(treatmentsVector.get(i).getName());
        }
    }
    public JComboBox getTreatmentList() {
        return treatmentList;
    }

    public JLabel getTreatmentPrices() {
        return treatmentPrices;
    }

    public void setTreatmentPrices(String price)
    {
        treatmentPrices.setText((String)price);
    }

}
