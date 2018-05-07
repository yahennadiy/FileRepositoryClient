package repository.fxapplication.filescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.filescene.eventhandlers.EditProfileHandler;

public class EditProfileButton {
    public static Button create() {
        Button  editProfileBtn = new Button("User edit");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            EditProfileHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                EditProfileHandler.exec();
            }
        };

        editProfileBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        editProfileBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  editProfileBtn;
    }
}
