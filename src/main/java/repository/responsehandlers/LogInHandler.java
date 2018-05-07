package repository.responsehandlers;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.loginscene.LogInSceneCreator;
import repository.queryimplementors.NextFilesInfoQueryImplementor;

public class LogInHandler {
    public static void exec(String[] serverResponse) {
        String responseType = serverResponse[2];
        Label actionInfoLbl = LogInSceneCreator.getActionInfoLbl();
        if (responseType.equals(ConfigReader.getUserOK())) {
            String token = serverResponse[3];
            int userId = Integer.parseInt(serverResponse[4]);
            String userName = serverResponse[5];
            String firstName = serverResponse[6];
            String lastName = serverResponse[7];
            Main.getUser().setAll(token, userId, userName, firstName, lastName);
            new NextFilesInfoQueryImplementor(Main.getFile().getFileName());
        } else if (responseType.equals(ConfigReader.getUserNameOrPasswordIsIncorrect())) {
            LogInSceneCreator.refresh();
            actionInfoLbl.setText("Username or password is incorrect.");
            actionInfoLbl.setTextFill(Color.RED);
        } else {
            actionInfoLbl.setText("Input username and password, please.");
            actionInfoLbl.setTextFill(Color.BLACK);
        }
    }
}
