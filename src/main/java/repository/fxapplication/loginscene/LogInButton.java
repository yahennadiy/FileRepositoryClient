package repository.fxapplication.loginscene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.loginscene.eventhandlers.LogInHandler;

public class LogInButton {
    public static Button create() {
        Button logInBtn = new Button("Log in");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            LogInHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                LogInHandler.exec();
            }
        };

        logInBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        logInBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return logInBtn;
    }
}
