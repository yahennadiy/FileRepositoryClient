package repository.fxapplication.uploadfilescene.eventhandlers;

import repository.NewFile;
import repository.config.ConfigReader;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;

public class SelectFileHandler {
    public static void exec() {
        String fileName = UploadFileSceneCreator.getFileNamesLv().getSelectionModel().getSelectedItem();
        int maxFileNameLength = ConfigReader.getFileNameLength();
        if (fileName.length() > maxFileNameLength) {
            UploadFileSceneCreator.getActionInfoLbl().setText("File name too long(max "
                    .concat(Integer.toString(maxFileNameLength)).concat(" characters)."));
        } else {
            NewFile.setFileName(fileName);
            UploadFileSceneCreator.getDescriptionTextArea().setText("");
            UploadFileSceneCreator.getSelectedFileLbl().setText("Selected: " +  fileName);
            UploadFileSceneCreator.getActionInfoLbl().setText("");
            UploadFileSceneCreator.getDescriptionTextArea().requestFocus();
            UploadFileSceneCreator.getUploadBtn().setDisable(false);
        }
    }
}
