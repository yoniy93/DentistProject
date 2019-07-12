package project.GUI.Admin.UnRegister;

import project.Database.Locations;
import project.GUI.General.CancelButton;

import javax.swing.*;
import java.awt.*;

public class UnRegisterView extends JFrame
{
    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("unregister.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private JButton submit = new JButton("SUBMIT");
    private JTextField idTextField = new JTextField();
    private JLabel idLabel = new JLabel("Enter id of user :");
    CancelButton cancelButton =new CancelButton();

    public UnRegisterView()
    {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("UnRegister an User");
        setBounds(300, 100, 450, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        idLabel.setBounds(20, 40, 150, 30);

        idTextField.setBounds(200,45,100,20);

        submit.setBounds(100,100,120,30);
        cancelButton.setLocation(240,100,120,30);

        backGround.setBounds(0,0,450,200);
    }

    private void addComponentsToFrame()
    {
        add(idLabel);
        add(idTextField);
        add(submit);
        add(cancelButton);
        add(backGround);
    }

    public JButton getSubmit() {
        return submit;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getCancel() {
        return cancelButton;
    }

}
