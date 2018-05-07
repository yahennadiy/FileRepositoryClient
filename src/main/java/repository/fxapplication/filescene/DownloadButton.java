package repository.fxapplication.filescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.filescene.eventhandlers.DownloadHandler;

public class DownloadButton {
    public static Button create() {
        Button downloadBtn = new Button("Download");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            DownloadHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                DownloadHandler.exec();
            }
        };

        downloadBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        downloadBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return downloadBtn;
    }
}
