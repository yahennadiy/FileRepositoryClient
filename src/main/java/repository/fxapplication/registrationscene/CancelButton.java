package repository.fxapplication.registrationscene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.fxapplication.loginscene.LogInSceneCreator;

public class CancelButton {
    public static Button create() {
        Button cancelBtn = new Button("Cancel");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            RegistrationSceneCreator.refresh();
            LogInSceneCreator.refresh();
            Main.getStage().setScene(LogInSceneCreator.getLogInScene());
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                RegistrationSceneCreator.refresh();
                LogInSceneCreator.refresh();
                Main.getStage().setScene(LogInSceneCreator.getLogInScene());
            }
        };

        cancelBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        cancelBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  cancelBtn;
    }
}
