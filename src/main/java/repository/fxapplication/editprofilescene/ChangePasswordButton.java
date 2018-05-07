package repository.fxapplication.editprofilescene;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.fxapplication.changepasswordscene.ChangePasswordSceneCreator;

public class ChangePasswordButton {
    public static Button create() {
        Button  changePasswordBtn = new Button("Change password");
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            ChangePasswordSceneCreator.refresh();
            Main.getStage().setScene(ChangePasswordSceneCreator.getChangePasswordScene());
        };
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                ChangePasswordSceneCreator.refresh();
                Main.getStage().setScene(ChangePasswordSceneCreator.getChangePasswordScene());
            }
        };

        changePasswordBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        changePasswordBtn.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return  changePasswordBtn;
    }
}
