package repository.fxapplication.filescene.eventhandlers;

import repository.Main;
import repository.fileoperations.upload.SourceFilesNameArrCreator;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;

public class UploadHandler {
    public static void exec() {
        UploadFileSceneCreator.refresh();
        if (SourceFilesNameArrCreator.exec().length == 0) {
            UploadFileSceneCreator.getSelectFileBtn().setDisable(true);
        } else {
            UploadFileSceneCreator.getSelectFileBtn().setDisable(false);
        }

        Main.getStage().setScene(UploadFileSceneCreator.getUploadFileScene());
        UploadFileSceneCreator.getFileNamesLv().getSelectionModel().select(0);
        UploadFileSceneCreator.getFileNamesLv().requestFocus();
    }
}
