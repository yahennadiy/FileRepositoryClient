package repository.fxapplication.filescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.filescene.eventhandlers.NextFilesHandler;

public class NextFilesButton {
    public static Button create() {
        Button  nextFilesNamesBtn = new Button("Next");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            NextFilesHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                NextFilesHandler.exec();
            }
        };

        nextFilesNamesBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        nextFilesNamesBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return nextFilesNamesBtn;
    }
}
