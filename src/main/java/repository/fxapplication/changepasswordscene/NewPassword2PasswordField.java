package repository.fxapplication.changepasswordscene;

import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.config.ConfigReader;

public class NewPassword2PasswordField {
    public static PasswordField create() {
        PasswordField newPassword2Pf = new PasswordField();
        newPassword2Pf.setPromptText("Your new password");
        int fieldLength = ConfigReader.getFieldLength();
        newPassword2Pf.setPrefColumnCount(fieldLength);
        newPassword2Pf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newPassword2Pf.getText().length() > fieldLength) {
                String currentFirstName = newPassword2Pf.getText().substring(0, fieldLength);
                newPassword2Pf.setText(currentFirstName);
            }
        });
        EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                ChangePasswordSceneCreator.getChangePasswordBtn().requestFocus();
            }
        };

        newPassword2Pf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return newPassword2Pf;
    }
}
