package repository.fxapplication.filescene.eventhandlers;

import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.filescene.FileSceneCreator;
import repository.fxapplication.filescene.infoarroundkeepers.FilesInfoArrKeeper;
import repository.queryimplementors.PrevFilesInfoQueryImplementor;

public class PrevFilesHandler implements EventHandlerInterface {
    public static void exec() {
        FileSceneCreator.getNextFilesBtn().setDisable(true);
        FileSceneCreator.getPrevFilesBtn().setDisable(true);
        new PrevFilesInfoQueryImplementor(FilesInfoArrKeeper.getFirstFileName());
    }
}
