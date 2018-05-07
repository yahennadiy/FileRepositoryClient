package repository.responsehandlers;

import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.ApplicationRebooter;
import repository.fxapplication.filescene.FileSceneCreator;

public class EditProfileHandler {
    public static void exec(String[] serverResponse) {
        String queryResult = serverResponse[2];
        if (queryResult.equals(ConfigReader.getTokenIsInvalid())) {
            ApplicationRebooter.exec();
        } else {
            String currentToken = Main.getUser().getToken();
            int userId = Integer.parseInt(serverResponse[3]);
            String userName = serverResponse[4];
            String firstName = serverResponse[5];
            String lastName = serverResponse[6];
            Main.getUser().setAll(currentToken, userId, userName, firstName, lastName);
            Main.getStage().setScene(FileSceneCreator.getFileScene());
        }
    }
}
