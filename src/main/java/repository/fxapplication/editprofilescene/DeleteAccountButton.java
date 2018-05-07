package repository.fxapplication.editprofilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.fxapplication.deleteaccountscene.DeleteAccountSceneCreator;

public class DeleteAccountButton {
    public static Button create() {
        Button  deleteAccountBtn = new Button("Delete current account");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            DeleteAccountSceneCreator.refresh();
            Main.getStage().setScene(DeleteAccountSceneCreator.getDeleteAccountScene());
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                DeleteAccountSceneCreator.refresh();
                Main.getStage().setScene(DeleteAccountSceneCreator.getDeleteAccountScene());
            }
        };

        deleteAccountBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        deleteAccountBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  deleteAccountBtn;
    }
}
