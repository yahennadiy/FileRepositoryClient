package repository.fxapplication.uploadfilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.uploadfilescene.eventhandlers.SelectFileHandler;

public class SelectFileButton {
    public static Button create() {
        Button selectFileBtn = new Button("Select file");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            SelectFileHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                SelectFileHandler.exec();
            }
        };

        selectFileBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        selectFileBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return selectFileBtn;
    }
}
