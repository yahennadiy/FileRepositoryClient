package repository.fxapplication.filescene.eventhandlers;

import repository.Main;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.loginscene.LogInSceneCreator;

public class QuitHandler implements EventHandlerInterface {
    public static void exec() {
        Main.getUser().clear();
        Main.getFile().clear();
        LogInSceneCreator.refresh();
        Main.getStage().setScene(LogInSceneCreator.getLogInScene());
    }
}
