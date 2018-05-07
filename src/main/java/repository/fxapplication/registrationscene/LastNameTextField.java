package repository.fxapplication.registrationscene;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.config.ConfigReader;

public class LastNameTextField {
    public static TextField create() {
        TextField lastNameTf = new TextField();
        lastNameTf.setPromptText("Your first name");
        int fieldLength = ConfigReader.getFieldLength();
        lastNameTf.setPrefColumnCount(fieldLength);
        lastNameTf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (lastNameTf.getText().length() > fieldLength) {
                String currentFirstName = lastNameTf.getText().substring(0, fieldLength);
                lastNameTf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                RegistrationSceneCreator.getPasswordPf().requestFocus();
            }
        };

        lastNameTf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return lastNameTf;
    }
}
