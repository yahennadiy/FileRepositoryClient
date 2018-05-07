package repository.fxapplication.editprofilescene;

import javafx.scene.control.TextField;
import repository.config.ConfigReader;

public class UserNameTextField {
    public static TextField create() {
        TextField userNameTf = new TextField();
        int fieldLength = ConfigReader.getFieldLength();
        userNameTf.setPrefColumnCount(fieldLength);
        userNameTf.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (userNameTf.getText().length() > fieldLength) {
                String currentFirstName = userNameTf.getText().substring(0, fieldLength);
                userNameTf.setText(currentFirstName);
            }
        });
        return userNameTf;
    }
}
