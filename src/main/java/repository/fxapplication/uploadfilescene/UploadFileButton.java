package repository.fxapplication.uploadfilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.uploadfilescene.eventhandlers.UploadFileHandler;

public class UploadFileButton {
    public static Button create() {
        Button UploadFileBtn = new Button("Upload");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            UploadFileHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                UploadFileHandler.exec();
            }
        };

        UploadFileBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        UploadFileBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return UploadFileBtn;
    }
}
