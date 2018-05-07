package repository.responsehandlers;

import javafx.scene.paint.Color;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.ApplicationRebooter;
import repository.fxapplication.changepasswordscene.ChangePasswordSceneCreator;
import repository.fxapplication.filescene.FileSceneCreator;

public class ChangePasswordHandler {
    public static void exec(String[] serverResponse) {
        String queryResult = serverResponse[2];
        if (queryResult.equals(ConfigReader.getTokenIsInvalid())) {
            ApplicationRebooter.exec();
        } else {
            if (queryResult.equals(ConfigReader.getPasswordChanged())) {
                Main.getStage().setScene(FileSceneCreator.getFileScene());
            } else if (queryResult.equals(ConfigReader.getUserNameOrPasswordIsIncorrect())) {
                ChangePasswordSceneCreator.refresh();
                ChangePasswordSceneCreator.getActionInfoLbl().setText("Password is incorrect.");
                ChangePasswordSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
            }
        }
    }
}
