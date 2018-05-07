package repository.fxapplication.registrationscene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.registrationscene.eventhandlers.RegistrationHandler;

public class RegistrationButton {
    public static Button create() {
        Button registrationBtn = new Button("Registration");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
                RegistrationHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                    RegistrationHandler.exec();
            }
        };

        registrationBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        registrationBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return registrationBtn;
    }
}

