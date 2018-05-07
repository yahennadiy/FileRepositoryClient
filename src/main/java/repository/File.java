package repository;

public class File {
    private int fileId = 0;
    private String fileName = " "; // space
    private int fileOwner = 0;
    private String fileDescription = "";
    private String fileUrl = "";

    public void setAll(int fileId, String fileName, int fileOwner, String fileDescription, String fileUrl) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileOwner = fileOwner;
        this.fileDescription = fileDescription;
        this.fileUrl = fileUrl;
    }

    public void clear() {
        this.fileId = 0;
        this.fileName = " "; // space
        this.fileOwner = 0;
        this.fileDescription = "";
        this.fileUrl = "";
    }

    public int getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileOwner() {
        return fileOwner;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public String getFileUrl() {
        return fileUrl;
    }
}
