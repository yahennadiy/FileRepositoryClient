package repository.fileoperations.download;

import repository.config.ConfigReader;
import repository.fileoperations.RootPathCreator;

public class TargetFilesPathCreator {

    public static String get() {
        return RootPathCreator.getRootDirPath().concat(ConfigReader.getFileTargetDir());
    }
}
