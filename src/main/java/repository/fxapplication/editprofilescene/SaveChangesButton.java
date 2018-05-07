package repository.fxapplication.editprofilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.editprofilescene.eventhandlers.EditProfileEventHandler;

public class SaveChangesButton {
    public static Button create() {
        Button  saveChangesBtn = new Button("Save changes");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            EditProfileEventHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                EditProfileEventHandler.exec();
            }
        };

        saveChangesBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        saveChangesBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  saveChangesBtn;
    }
}
