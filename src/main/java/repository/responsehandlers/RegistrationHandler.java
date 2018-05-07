package repository.responsehandlers;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.registrationscene.RegistrationSceneCreator;
import repository.queryimplementors.NextFilesInfoQueryImplementor;

public class RegistrationHandler {
    public static void exec(String[] serverResponse) {
        String responseType = serverResponse[2];
        Label actionInfoLbl = RegistrationSceneCreator.getActionInfoLbl();
        if (responseType.equals(ConfigReader.getProfileStored())) {
            String token = serverResponse[3];
            int userId = Integer.parseInt(serverResponse[4]);
            String userName = serverResponse[5];
            String firstName = serverResponse[6];
            String lastName = serverResponse[7];
            Main.getUser().setAll(token, userId, userName, firstName, lastName);
            new NextFilesInfoQueryImplementor(Main.getFile().getFileName());
        } else if (responseType.equals(ConfigReader.getUserAlreadyExist())) {
            RegistrationSceneCreator.refresh();
            actionInfoLbl.setText("Sorry, user already exist");
            actionInfoLbl.setTextFill(Color.RED);
        }
    }
}
