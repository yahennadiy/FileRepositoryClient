package repository.fxapplication.filescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.filescene.eventhandlers.UploadHandler;

public class UploadButton {
    public static Button create() {
        Button uploadBtn = new Button("Add file");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            UploadHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                UploadHandler.exec();
            }
        };

        uploadBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        uploadBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return uploadBtn;
    }
}
