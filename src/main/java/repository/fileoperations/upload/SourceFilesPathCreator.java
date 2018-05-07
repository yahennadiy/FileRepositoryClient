package repository.fileoperations.upload;

import repository.config.ConfigReader;
import repository.fileoperations.RootPathCreator;

public class SourceFilesPathCreator {
    public static String get() {
        return RootPathCreator.getRootDirPath().concat(ConfigReader.getFileSourceDir());
    }

}
