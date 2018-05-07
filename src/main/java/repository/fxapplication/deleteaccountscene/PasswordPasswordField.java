package repository.fxapplication.deleteaccountscene;

import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.config.ConfigReader;

public class PasswordPasswordField {
    public static PasswordField create() {
        PasswordField passwordPf = new PasswordField();
        passwordPf.setPromptText("Your password");
        int fieldLength = ConfigReader.getFieldLength();
        passwordPf.setPrefColumnCount(fieldLength);
        passwordPf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (passwordPf.getText().length() > fieldLength) {
                String currentFirstName = passwordPf.getText().substring(0, fieldLength);
                passwordPf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                DeleteAccountSceneCreator.getPassword2Pf().requestFocus();
            }
        };

        passwordPf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return passwordPf;
    }
}
