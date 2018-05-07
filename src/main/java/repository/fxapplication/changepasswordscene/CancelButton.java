package repository.fxapplication.changepasswordscene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.fxapplication.editprofilescene.EditProfileSceneCreator;

public class CancelButton {
    public static Button create() {
        Button cancelBtn = new Button("Cancel");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            Main.getStage().setScene(EditProfileSceneCreator.getEditProfileScene());
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {

                Main.getStage().setScene(EditProfileSceneCreator.getEditProfileScene());
            }
        };

        cancelBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        cancelBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  cancelBtn;
    }
}
