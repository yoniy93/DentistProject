package project.GUI.Patient.Payment;
import project.Database.Locations;
import project.GUI.General.CancleButton;

import javax.swing.*;
import java.util.Vector;

public class PaymentView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("register.png"));
    private JLabel backGround=new JLabel(imageForBG);
    private JLabel id=new JLabel("ID: ");
    private JLabel creditCard= new JLabel("Credit Card: ");
    private JLabel validity=new JLabel("Validity:");
    private JLabel CVV= new JLabel("CVV :");
    private JButton submit=new JButton("Submit");
    private CancleButton cancel=new CancleButton();
    private JTextField idTextField=new JTextField(9);
    private JTextField creditTextField=new JTextField(16);
    private JTextField CVVTextField=new JTextField(3);

    private Vector yearVector = new Vector(15);
    private Vector monthVector = new Vector(12) ;

    private JComboBox yearBox = new JComboBox(yearVector);
    private JComboBox monthBox = new JComboBox(monthVector);



    public PaymentView()
    {
        setValidity();
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Make Your Payment: ");
        setBounds(300, 100, 800, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setValidity() {
        for(int i=0;i<12; i++)
        {
            monthVector.insertElementAt(i+1,i);
        }
        int max=2035;
        for (int i=0; i<=15; i++)
        {
            yearVector.insertElementAt(max--,i);
        }
    }

    private void setLocationAndSize()
    {
        id.setBounds(100,100,200,30);
        idTextField.setBounds(350,100,200,30);

        creditCard.setBounds(100,150,200,30);
        creditTextField.setBounds(350,150,200,30);

        validity.setBounds(100,200,200,30);
        monthBox.setSelectedItem(monthVector.get(0));
        monthBox.setBounds(350,200,100,30);
        yearBox.setSelectedItem(yearVector.get(0));
        yearBox.setBounds(470,200,100,30);

        CVV.setBounds(100,250,200,30);
        CVVTextField.setBounds(350,250,200,30);
        submit.setBounds(100,350,200,30);

        backGround.setBounds(0,0,800,700);
        cancel.setLocation(350,350,200,30);
    }

    private void addComponentsToFrame()
    {
        add(id);
        add(cancel);
        add(idTextField);
        add(creditCard);
        add(validity);
        add(CVV);
        add(idTextField);
        add(creditTextField);
        add(monthBox);
        add(yearBox);
        add(CVVTextField);
        add(submit);
        add(backGround);
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getCreditTextField() {
        return creditTextField;
    }

    public void setCreditTextField(JTextField creditTextField) {
        this.creditTextField = creditTextField;
    }

    public JTextField getCVVTextField() {
        return CVVTextField;
    }

    public void setCVVTextField(JTextField CVVTextField) {
        this.CVVTextField = CVVTextField;
    }

    public JComboBox getYearBox() {
        return yearBox;
    }

    public void setYearBox(JComboBox yearBox) {
        this.yearBox = yearBox;
    }

    public JComboBox getMonthBox() {
        return monthBox;
    }

    public void setMonthBox(JComboBox monthBox) {
        this.monthBox = monthBox;
    }

    public CancleButton getCancel() {
        return cancel;
    }

}