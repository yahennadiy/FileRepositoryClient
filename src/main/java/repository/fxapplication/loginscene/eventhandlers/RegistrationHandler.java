package repository.fxapplication.loginscene.eventhandlers;

import javafx.scene.paint.Color;
import repository.Main;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.registrationscene.RegistrationSceneCreator;

public class RegistrationHandler implements EventHandlerInterface {
    public static void exec() {
        RegistrationSceneCreator.getActionInfoLbl().setText("Input all fields, please.");
        RegistrationSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
        RegistrationSceneCreator.refresh();
        Main.getStage().setScene(RegistrationSceneCreator.getRegistrationScene());
    }
}
