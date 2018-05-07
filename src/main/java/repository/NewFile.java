package repository;

public class NewFile {
    private static String fileName = "";

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        NewFile.fileName = fileName;
    }
}
