package repository.responsehandlers;

import repository.Main;
import repository.config.ConfigReader;
import repository.fileoperations.upload.FileFtpUploader;
import repository.fxapplication.ApplicationRebooter;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;

public class FileInfoUploadHandler {
    public static void exec(String[] serverResponse) {
        String queryResult = serverResponse[2];
        if (queryResult.equals(ConfigReader.getTokenIsInvalid())) {
            ApplicationRebooter.exec();
        } else {
            if (queryResult.equals(ConfigReader.getFileInfoStored())) {
                int fileId  = Integer.parseInt(serverResponse[3]);
                String fileName = serverResponse[4];
                int fileOwner = Integer.parseInt(serverResponse[5]);
                String fileDescription = serverResponse[6];
                String fileUrl = serverResponse[7];
                Main.getFile().setAll(fileId, fileName, fileOwner, fileDescription, fileUrl);
                new FileFtpUploader(fileName);
            } else if (queryResult.equals(ConfigReader.getFileNameAlreadyExist())) {
                UploadFileSceneCreator.getUploadBtn().setDisable(true);
                UploadFileSceneCreator.buttonOpener();
                UploadFileSceneCreator.getSelectedFileLbl().setText("Selected: ");
                UploadFileSceneCreator.getActionInfoLbl().setText("Sorry, file name already exist.");
            } else {
                UploadFileSceneCreator.getUploadBtn().setDisable(true);
                UploadFileSceneCreator.buttonOpener();
                UploadFileSceneCreator.getDescriptionTextArea().setText("");
                UploadFileSceneCreator.getSelectedFileLbl().setText("Selected: ");
                UploadFileSceneCreator.getActionInfoLbl().setText("Sorry, file not uploaded.");
            }
        }
    }
}
