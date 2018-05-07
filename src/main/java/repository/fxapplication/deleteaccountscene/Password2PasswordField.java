package repository.fxapplication.deleteaccountscene;

import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.config.ConfigReader;

public class Password2PasswordField {
    public static PasswordField create() {
        PasswordField password2Pf = new PasswordField();
        password2Pf.setPromptText("Your password");
        int fieldLength = ConfigReader.getFieldLength();
        password2Pf.setPrefColumnCount(fieldLength);
        password2Pf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (password2Pf.getText().length() > fieldLength) {
                String currentFirstName = password2Pf.getText().substring(0, fieldLength);
                password2Pf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                DeleteAccountSceneCreator.getDeleteAccountBtn().requestFocus();
            }
        };

        password2Pf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return password2Pf;
    }
}
