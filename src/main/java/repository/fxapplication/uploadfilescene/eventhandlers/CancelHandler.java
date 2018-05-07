package repository.fxapplication.uploadfilescene.eventhandlers;

import repository.Main;
import repository.queryimplementors.NextFilesInfoQueryImplementor;

public class CancelHandler {
    public static void exec() {
        Main.getFile().clear();
        new NextFilesInfoQueryImplementor(" ");
    }
}
