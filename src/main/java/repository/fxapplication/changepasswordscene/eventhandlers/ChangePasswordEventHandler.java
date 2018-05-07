package repository.fxapplication.changepasswordscene.eventhandlers;

import javafx.scene.paint.Color;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.changepasswordscene.ChangePasswordSceneCreator;
import repository.queryimplementors.ChangePasswordQueryImplementor;

public class ChangePasswordEventHandler implements EventHandlerInterface {
    public static void exec() {
        String password = ChangePasswordSceneCreator.getPassword();
        String newPassword = ChangePasswordSceneCreator.getNewPassword();
        String newPassword2 = ChangePasswordSceneCreator.getNewPassword2();
        if (password.length() > 0 && newPassword.length() > 0 && newPassword2.length() > 0) {
            if (!password.equals(newPassword) && newPassword.equals(newPassword2)) {
                ChangePasswordSceneCreator.getChangePasswordBtn().setDisable(true);
                ChangePasswordSceneCreator.getPasswordPf().setDisable(true);
                ChangePasswordSceneCreator.getNewPasswordPf().setDisable(true);
                ChangePasswordSceneCreator.getNewPassword2Pf().setDisable(true);
                ChangePasswordSceneCreator.getCancelBtn().setDisable(true);
                ChangePasswordSceneCreator.getActionInfoLbl().setText("Wait, please");
                ChangePasswordSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
                new ChangePasswordQueryImplementor();
            } else {
                ChangePasswordSceneCreator.refresh();
            }
        } else {
            ChangePasswordSceneCreator.getActionInfoLbl().setText("Enter all fields, please.");
            ChangePasswordSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
        }
    }
}
