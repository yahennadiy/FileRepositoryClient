package repository.fxapplication.changepasswordscene;

import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.config.ConfigReader;

public class NewPasswordPasswordField {
    public static PasswordField create() {
        PasswordField newPasswordPf = new PasswordField();
        newPasswordPf.setPromptText("Your new password");
        int fieldLength = ConfigReader.getFieldLength();
        newPasswordPf.setPrefColumnCount(fieldLength);
        newPasswordPf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newPasswordPf.getText().length() > fieldLength) {
                String currentFirstName = newPasswordPf.getText().substring(0, fieldLength);
                newPasswordPf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                ChangePasswordSceneCreator.getNewPassword2Pf().requestFocus();
            }
        };

        newPasswordPf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return newPasswordPf;
    }
}
