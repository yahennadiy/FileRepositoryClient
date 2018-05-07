package repository.fxapplication.uploadfilescene.eventhandlers;

import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;
import repository.queryimplementors.UploadFileQueryImplementor;

public class UploadFileHandler {
    public static void exec() {
        if (UploadFileSceneCreator.getDescriptionTextArea().getText().length() == 0) {
            UploadFileSceneCreator.getActionInfoLbl().setText("Write description to selected file, please.");
        } else {
            UploadFileSceneCreator.getUploadBtn().setDisable(true);
            UploadFileSceneCreator.getSelectFileBtn().setDisable(true);
            UploadFileSceneCreator.getCancelBtn().setDisable(true);
            UploadFileSceneCreator.getActionInfoLbl().setText("Wait, please.");
            new UploadFileQueryImplementor();
        }
    }
}
