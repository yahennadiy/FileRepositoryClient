package repository.fileoperations.upload;

import java.io.File;
import java.util.Arrays;

public class SourceFilesNameArrCreator {
    public static String[] exec() {
        String[] sourceFilesNameArr;
        String sourceFileDir = SourceFilesPathCreator.get();
        File fileSourceDirFile = new File(sourceFileDir);
        if (!fileSourceDirFile.exists()) {
            fileSourceDirFile.mkdir();
        }

        sourceFilesNameArr = fileSourceDirFile.list();
        if (sourceFilesNameArr != null) {
            Arrays.sort(sourceFilesNameArr);
        }

        return sourceFilesNameArr;
    }
}
