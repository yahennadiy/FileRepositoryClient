package repository.errorhandlers;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.filescene.FileSceneCreator;
import repository.fxapplication.loginscene.LogInSceneCreator;
import repository.queryimplementors.RepeatQueryImplementor;

public class FatalErrorHandler implements EventHandlerInterface {
    private static int numberOfErrors = 0;
    public static void exec() {
        if (numberOfErrors < ConfigReader.getNumberOfQueriesIfError()) {
            numberOfErrors ++;
            RepeatQueryImplementor.exec();
        } else {
            numberOfErrors = 0;
            Main.getUser().clear();
            Main.getFile().clear();
            FileSceneCreator.fileDescriptionScrollPainRepaint();
            FileSceneCreator.getDownloadBtn().setDisable(true);
            LogInSceneCreator.refresh();
            Label actionInfoLbl = LogInSceneCreator.getActionInfoLbl();
            actionInfoLbl.setText("Fatal error");
            actionInfoLbl.setTextFill(Color.RED);
            Main.getStage().setScene(LogInSceneCreator.getLogInScene());
        }
    }

    public static void resetNumberOfErrors() {
        numberOfErrors = 0;
    }
}
