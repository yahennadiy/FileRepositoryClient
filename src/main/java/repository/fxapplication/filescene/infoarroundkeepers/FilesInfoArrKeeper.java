package repository.fxapplication.filescene.infoarroundkeepers;

import repository.File;

import static java.util.Objects.isNull;

public class FilesInfoArrKeeper {
    private static File filesInfoArr[] = new File[0];
    private static String[] filesNameArr;

    public static void create(int numberOfFilesInfo) {
        filesInfoArr = new File[numberOfFilesInfo];
    }

    public static void addFileInfo(int currentFileInfoIndex, File fileInfo) {
        filesInfoArr[currentFileInfoIndex] = fileInfo;
    }

    public static int getFileId(int index) {
        return filesInfoArr[index].getFileId();
    }

    public static String getFileName(int index) {
        return filesInfoArr[index].getFileName();
    }

    public static int getFileOwner(int index) {
        return filesInfoArr[index].getFileOwner();
    }

    public static String getFileDescription(int index) {
        return filesInfoArr[index].getFileDescription();
    }

    public static String getFileUrl(int index) {
        return filesInfoArr[index].getFileUrl();
    }

    private static void createFilesNameArr() {
        int arrLength = filesInfoArr.length;
        filesNameArr = new String[arrLength];
        for (int i = 0; i < arrLength; i++) {
            if (isNull(filesInfoArr[i])) {
                filesNameArr[i] = "";
            } else {
                filesNameArr[i] = filesInfoArr[i].getFileName();
            }
        }
    }

    public static String[] getFilesNameArr() {
        createFilesNameArr();
        return filesNameArr;
    }

    public static String getFirstFileName() {
        return filesNameArr[0];
    }

    public static String getLastFileName() {
        return filesNameArr[filesNameArr.length - 1];
    }
}
