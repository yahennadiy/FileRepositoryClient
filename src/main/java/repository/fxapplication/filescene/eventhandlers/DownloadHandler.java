package repository.fxapplication.filescene.eventhandlers;

import repository.fileoperations.download.FileFtpDownloader;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.filescene.FileSceneCreator;

public class DownloadHandler implements EventHandlerInterface {
    public static void exec() {
        FileSceneCreator.getDownloadBtn().setDisable(true);
        FileSceneCreator.getEditProfileBtn().setDisable(true);
        FileSceneCreator.getQuitBtn().setDisable(true);
        FileSceneCreator.getUploadBtn().setDisable(true);
        FileSceneCreator.getActionInfoLbl().setText("Wait, please.");
        FileSceneCreator.getFilesNamesLv().requestFocus();
        new FileFtpDownloader();
    }
}
