package repository.fxapplication.changepasswordscene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.changepasswordscene.eventhandlers.ChangePasswordEventHandler;

public class ChangePasswordButton {
    public static Button create() {
        Button  changePasswordBtn = new Button("Change password");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            ChangePasswordEventHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                ChangePasswordEventHandler.exec();
            }
        };

        changePasswordBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        changePasswordBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  changePasswordBtn;
    }
}
