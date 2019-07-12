package project.GUI.Admin.UnRegister;

import javax.swing.*;

public class UnRegisterController
{
    UnRegisterModel unRegisterModel;
    UnRegisterView unRegisterView;
    public UnRegisterController(UnRegisterView unRegisterView, UnRegisterModel unRegisterModel) {
        this.unRegisterModel=unRegisterModel;
        this.unRegisterView=unRegisterView;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        unRegisterView.getSubmit().addActionListener(e-> submitAction());
        unRegisterView.getCancel().addActionListener(e->unRegisterView.dispose());
    }

    private void submitAction() {
        String msg_recived;
        msg_recived=unRegisterModel.deleteUser(unRegisterView.getIdTextField().getText());
        if (msg_recived.equals("Sucssesfuly"))
            JOptionPane.showMessageDialog(unRegisterView, "User has been deleted successfully");
        else JOptionPane.showMessageDialog(unRegisterView, msg_recived);

    }

}
