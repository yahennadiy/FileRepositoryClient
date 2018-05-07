package repository.fxapplication.editprofilescene;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.config.ConfigReader;

public class LastNameTextField {
    public static TextField create() {
        TextField lastNameTf = new TextField();
        lastNameTf.setPromptText("Your last name");
        int fieldLength = ConfigReader.getFieldLength();
        lastNameTf.setPrefColumnCount(fieldLength);
        lastNameTf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (lastNameTf.getText().length() > fieldLength) {
                String currentFirstName = lastNameTf.getText().substring(0, fieldLength);
                lastNameTf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.TAB) {
                if (!EditProfileSceneCreator.getFirstNameTf().getText().equals(Main.getUser().getFirstName())
                        || !EditProfileSceneCreator.getLastNameTf().getText().equals(Main.getUser().getLastName())) {
                    EditProfileSceneCreator.getSaveChangesBtn().setDisable(false);
                } else {
                    EditProfileSceneCreator.getSaveChangesBtn().setDisable(true);
                }

                EditProfileSceneCreator.getSaveChangesBtn().requestFocus();
            }
        };
        EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
            if (!EditProfileSceneCreator.getFirstNameTf().getText().equals(Main.getUser().getFirstName())
                    || !EditProfileSceneCreator.getLastNameTf().getText().equals(Main.getUser().getLastName())) {
                EditProfileSceneCreator.getSaveChangesBtn().setDisable(false);
            } else {
                EditProfileSceneCreator.getSaveChangesBtn().setDisable(true);
            }
        };

        lastNameTf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        lastNameTf.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        return lastNameTf;
    }
}
