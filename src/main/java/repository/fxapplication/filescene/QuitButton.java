package repository.fxapplication.filescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.filescene.eventhandlers.QuitHandler;

public class QuitButton {
    public static Button create() {
        Button  quitBtn = new Button("Quit");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            QuitHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                QuitHandler.exec();
            }
        };

        quitBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        quitBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  quitBtn;
    }
}
