package repository.fxapplication.filescene.eventhandlers;

import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.filescene.FileSceneCreator;
import repository.fxapplication.filescene.infoarroundkeepers.FilesInfoArrKeeper;
import repository.queryimplementors.NextFilesInfoQueryImplementor;

public class NextFilesHandler implements EventHandlerInterface {
    public static void exec() {
        FileSceneCreator.getNextFilesBtn().setDisable(true);
        FileSceneCreator.getPrevFilesBtn().setDisable(true);
        new NextFilesInfoQueryImplementor(FilesInfoArrKeeper.getLastFileName());
    }
}
