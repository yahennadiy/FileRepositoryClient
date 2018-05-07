package repository.fxapplication.uploadfilescene;

import javafx.scene.control.TextArea;
import repository.config.ConfigReader;

public class DescriptionTextArea {
    public static TextArea create() {
        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setWrapText(true);
        int fileDescriptionLength = ConfigReader.getFileDescriptionLength();
        descriptionTextArea.setPromptText("Write description for selected file(max "
                .concat(Integer.toString(fileDescriptionLength)).concat(" characters)."));
        descriptionTextArea.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (descriptionTextArea.getText().length() > fileDescriptionLength) {
                String currentFirstName = descriptionTextArea.getText().substring(0, fileDescriptionLength);
                descriptionTextArea.setText(currentFirstName);
            }
        });
        return descriptionTextArea;
    }
}
