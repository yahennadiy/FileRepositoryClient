package repository.fxapplication.editprofilescene;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import repository.Main;
import repository.config.ConfigReader;

public class FirstNameTextField {
    public static TextField create() {
        TextField firstNameTf = new TextField();
        firstNameTf.setPromptText("Your first name");
        int fieldLength = ConfigReader.getFieldLength();
        firstNameTf.setPrefColumnCount(fieldLength);
        firstNameTf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (firstNameTf.getText().length() > fieldLength) {
                String currentFirstName = firstNameTf.getText().substring(0, fieldLength);
                firstNameTf.setText(currentFirstName);
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

                EditProfileSceneCreator.getLastNameTf().requestFocus();
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

        firstNameTf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        firstNameTf.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        return firstNameTf;
    }
}
