package repository.fxapplication.uploadfilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.uploadfilescene.eventhandlers.CancelHandler;

public class CancelButton {
    public static Button create() {
        Button cancelBtn = new Button("Cancel");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            CancelHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                CancelHandler.exec();
            }
        };

        cancelBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        cancelBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  cancelBtn;
    }
}
