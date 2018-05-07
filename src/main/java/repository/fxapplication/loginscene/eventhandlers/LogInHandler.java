package repository.fxapplication.loginscene.eventhandlers;

import javafx.scene.paint.Color;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.loginscene.LogInSceneCreator;
import repository.queryimplementors.LogInQueryImplementor;

public class LogInHandler implements EventHandlerInterface {
    public static void exec() {
        String userName = LogInSceneCreator.getUserName();
        String password = LogInSceneCreator.getPassword();
        if (userName.length() > 0 && password.length() > 0) {
            LogInSceneCreator.getLogInBtn().setDisable(true);
            LogInSceneCreator.getRegistrationBtn().setDisable(true);
            LogInSceneCreator.getUserNameTf().setDisable(true);
            LogInSceneCreator.getPasswordPf().setDisable(true);
            LogInSceneCreator.getActionInfoLbl().setText("Wait, please.");
            LogInSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
            new LogInQueryImplementor();
        } else {
            LogInSceneCreator.getUserNameTf().requestFocus();
            LogInSceneCreator.getActionInfoLbl().setText("Input username and password both, please.");
            LogInSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
        }
    }
}
