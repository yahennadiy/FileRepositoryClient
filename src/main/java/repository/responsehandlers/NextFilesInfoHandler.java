package repository.responsehandlers;

import repository.File;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.ApplicationRebooter;
import repository.fxapplication.filescene.FileSceneCreator;
import repository.fxapplication.filescene.infoarroundkeepers.FilesInfoArrKeeper;

public class NextFilesInfoHandler {
    private static boolean moreFilesInfoInDb;

    public static void exec(String[] serverResponse) {
        String queryResult = serverResponse[2];
        if (queryResult.equals(ConfigReader.getTokenIsInvalid())) {
            ApplicationRebooter.exec();
        } else {
            int numberOfFilesInfo = Integer.parseInt(serverResponse[3]);
            int currentFileInfoIndex = Integer.parseInt(serverResponse[4]);
            String haveMore = serverResponse[5];
            int fileId = Integer.parseInt(serverResponse[6]);
            String fileName = serverResponse[7];
            int fileOwner = Integer.parseInt(serverResponse[8]);
            String description = serverResponse[9];
            String url = serverResponse[10];
            if (currentFileInfoIndex == 0) {
                FilesInfoArrKeeper.create(numberOfFilesInfo);
            }

            File fileInfo = new File();
            fileInfo.setAll(fileId, fileName, fileOwner, description, url);
            FilesInfoArrKeeper.addFileInfo(currentFileInfoIndex, fileInfo);
            if (currentFileInfoIndex == numberOfFilesInfo - 1) {
                if (haveMore.equals(ConfigReader.getHaveMore())) {
                    moreFilesInfoInDb = true;
                } else if (haveMore.equals(ConfigReader.getHaveNotMore())) {
                    moreFilesInfoInDb = false;
                }

                FileSceneCreator.filesNamesListViewRepaint();
                FileSceneCreator.fileDescriptionScrollPainRepaint();
                FileSceneCreator.getPrevFilesBtn().setDisable(false);
                if (moreFilesInfoInDb) {
                    FileSceneCreator.getNextFilesBtn().setDisable(false);
                } else {
                    FileSceneCreator.getNextFilesBtn().setDisable(true);
                }

                fileName = Main.getFile().getFileName();
                if (fileName.equals(" ")) {
                    FileSceneCreator.getPrevFilesBtn().setDisable(true);
                }

                Main.getFile().setAll(FilesInfoArrKeeper.getFileId(0), FilesInfoArrKeeper.getFileName(0),
                        FilesInfoArrKeeper.getFileOwner(0), FilesInfoArrKeeper.getFileDescription(0),
                        FilesInfoArrKeeper.getFileUrl(0));
                FileSceneCreator.getActionInfoLbl().setText("");
                Main.getStage().setScene(FileSceneCreator.getFileScene());
                FileSceneCreator.getFilesNamesLv().getSelectionModel().select(0);
                FileSceneCreator.getFilesNamesLv().requestFocus();
            }
        }
    }
}
