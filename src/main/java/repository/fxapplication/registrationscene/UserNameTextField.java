package repository.fxapplication.registrationscene;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.config.ConfigReader;

public class UserNameTextField {
    public static TextField create() {
        TextField userNameTf = new TextField();
        userNameTf.setPromptText("Your username");
        int fieldLength = ConfigReader.getFieldLength();
        userNameTf.setPrefColumnCount(fieldLength);
        userNameTf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (userNameTf.getText().length() > fieldLength) {
                String currentFirstName = userNameTf.getText().substring(0, fieldLength);
                userNameTf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                RegistrationSceneCreator.getFirstNameTf().requestFocus();
            }
        };

        userNameTf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return userNameTf;
    }
}
