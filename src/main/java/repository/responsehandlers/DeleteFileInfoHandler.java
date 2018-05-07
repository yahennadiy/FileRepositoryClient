package repository.responsehandlers;

import javafx.application.Platform;
import repository.config.ConfigReader;
import repository.fxapplication.ApplicationRebooter;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;

public class DeleteFileInfoHandler {
    public static void exec(String[] serverResponse) {
        String queryResult = serverResponse[2];
        if (queryResult.equals(ConfigReader.getTokenIsInvalid())) {
            ApplicationRebooter.exec();
        } else {
            if (queryResult.equals(ConfigReader.getFileInfoDeleted())) {
                Platform.runLater(() -> {
                    UploadFileSceneCreator.buttonOpener();
                    UploadFileSceneCreator.getDescriptionTextArea().setText("");
                    UploadFileSceneCreator.getSelectedFileLbl().setText("Selected: ");
                    UploadFileSceneCreator.getActionInfoLbl().setText("Sorry, upload was crashed.");
                });
            }
        }
    }
}
