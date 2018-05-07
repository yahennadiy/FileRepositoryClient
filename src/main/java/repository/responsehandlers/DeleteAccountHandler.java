package repository.responsehandlers;

import javafx.scene.paint.Color;
import repository.config.ConfigReader;
import repository.fxapplication.ApplicationRebooter;
import repository.fxapplication.deleteaccountscene.DeleteAccountSceneCreator;

public class DeleteAccountHandler {
    public static void exec(String[] serverResponse) {
        String queryResult = serverResponse[2];
        if (queryResult.equals(ConfigReader.getTokenIsInvalid())) {
            ApplicationRebooter.exec();
        } else {
            if (queryResult.equals(ConfigReader.getAccountDeleted())) {
                ApplicationRebooter.exec();
            } else if (queryResult.equals(ConfigReader.getUserNameOrPasswordIsIncorrect())) {
                DeleteAccountSceneCreator.refresh();
                DeleteAccountSceneCreator.getActionInfoLbl().setText("Username or password is incorrect.");
                DeleteAccountSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
            }
        }
    }
}
