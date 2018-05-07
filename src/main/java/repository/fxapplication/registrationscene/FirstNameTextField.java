package repository.fxapplication.registrationscene;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
            if (keyEvent.getCode() == KeyCode.ENTER) {
                RegistrationSceneCreator.getLastNameTf().requestFocus();
            }
        };

        firstNameTf.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler);
        return firstNameTf;
    }
}
