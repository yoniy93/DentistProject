package project.GUI.Admin.UnRegister;

import project.GUI.General.MessageWindow;

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
        String id = unRegisterView.getIdTextField().getText();
        if (!unRegisterModel.isUserExists(id))
            new MessageWindow(unRegisterView, "User doesnt exist");
        else {
            if (id.equals("1"))
                new MessageWindow(unRegisterView, "Cannot delete Admin user");
            else {

                msg_recived = unRegisterModel.deleteUser(id);
                if (msg_recived.equals("Sucssesfuly")) {
                    new MessageWindow(unRegisterView, "User has been deleted successfully");
                    unRegisterView.dispose();
                } else new MessageWindow(unRegisterView, msg_recived);
            }
        }
    }
}
