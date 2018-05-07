package repository.fxapplication.deleteaccountscene.eventhandler;

import javafx.scene.paint.Color;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.deleteaccountscene.DeleteAccountSceneCreator;
import repository.queryimplementors.DeleteAccountQueryImplementor;

public class DeleteAccountEventHandler implements EventHandlerInterface {
    public static void exec() {
        String password = DeleteAccountSceneCreator.getPassword();
        String password2 = DeleteAccountSceneCreator.getPassword2();
        if (password.length() > 0 && password2.length() > 0) {
            if (!(password.equals(password2))) {
                DeleteAccountSceneCreator.refresh();
                DeleteAccountSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
            } else {
                DeleteAccountSceneCreator.getDeleteAccountBtn().setDisable(true);
                DeleteAccountSceneCreator.getPasswordPf().setDisable(true);
                DeleteAccountSceneCreator.getPassword2Pf().setDisable(true);
                DeleteAccountSceneCreator.getCancelBtn().setDisable(true);
                DeleteAccountSceneCreator.getActionInfoLbl().setText("Wait, please");
                DeleteAccountSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
                new DeleteAccountQueryImplementor();
            }
        } else {
            DeleteAccountSceneCreator.refresh();
            DeleteAccountSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
        }
    }
}
