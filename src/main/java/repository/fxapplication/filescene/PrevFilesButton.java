package repository.fxapplication.filescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.filescene.eventhandlers.PrevFilesHandler;

public class PrevFilesButton {
    public static Button create() {
        Button  prevFilesNamesBtn = new Button("Prev");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            PrevFilesHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                PrevFilesHandler.exec();
            }
        };

        prevFilesNamesBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        prevFilesNamesBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return prevFilesNamesBtn;
    }
}
