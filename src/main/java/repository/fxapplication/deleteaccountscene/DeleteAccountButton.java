package repository.fxapplication.deleteaccountscene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.fxapplication.deleteaccountscene.eventhandler.DeleteAccountEventHandler;

public class DeleteAccountButton {
    public static Button create() {
        Button  deleteAccountBtn = new Button("Delete current account");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            DeleteAccountEventHandler.exec();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                DeleteAccountEventHandler.exec();
            }
        };

        deleteAccountBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        deleteAccountBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  deleteAccountBtn;
    }
}
