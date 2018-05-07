package repository.fxapplication;

import repository.Main;
import repository.fxapplication.loginscene.LogInSceneCreator;

public class ApplicationRebooter {
    public static void exec() {
        Main.getUser().clear();
        Main.getFile().clear();
        LogInSceneCreator.refresh();
        Main.getStage().setScene(LogInSceneCreator.getLogInScene());
    }
}
