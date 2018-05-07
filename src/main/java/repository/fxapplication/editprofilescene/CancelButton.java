package repository.fxapplication.editprofilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.fxapplication.filescene.FileSceneCreator;

public class CancelButton {
    public static Button create() {
        Button cancelBtn = new Button("Cancel");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            Main.getStage().setScene(FileSceneCreator.getFileScene());
            FileSceneCreator.getFileRoot().requestFocus();
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                Main.getStage().setScene(FileSceneCreator.getFileScene());
                FileSceneCreator.getFileRoot().requestFocus();
            }
        };

        cancelBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        cancelBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  cancelBtn;
    }
}
