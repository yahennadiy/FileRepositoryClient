package repository.fileoperations.upload;

import javafx.application.Platform;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import repository.config.ConfigReader;
import repository.fileoperations.RootPathCreator;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;
import repository.queryimplementors.DeleteFileQueryImplementor;

import java.io.*;

public class FileFtpUploader extends Thread {
    private String fileName;

    public FileFtpUploader(String fileName) {
        super();
        this.fileName = fileName;
        start();
    }

    public void run() {
        String sourceFilePath = RootPathCreator.getRootDirPath().concat(ConfigReader.getFileSourceDir())
                .concat(fileName);
        System.out.println(sourceFilePath);
        String host = ConfigReader.getHost();
        int port = ConfigReader.getFtpPort();
        String keyWord = ConfigReader.getKeyWord();
        File sourceFilePathFile = new File(sourceFilePath);
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(host, port);
            ftpClient.login(keyWord, keyWord);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            InputStream inputStream = new FileInputStream(sourceFilePathFile);
            OutputStream outputStream = ftpClient.storeFileStream(fileName);
            byte[] bytesArray = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream.write(bytesArray, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
            boolean completed = ftpClient.completePendingCommand();
            if (completed) {
                Platform.runLater(() -> {
                    UploadFileSceneCreator.buttonOpener();
                    UploadFileSceneCreator.getDescriptionTextArea().setText("");
                    UploadFileSceneCreator.getSelectedFileLbl().setText("Selected: ");
                    UploadFileSceneCreator.getActionInfoLbl().setText("File ".concat(fileName).concat(" uploaded."));
                });
            } else {
                new DeleteFileQueryImplementor();
            }
        } catch (IOException exc) {
            System.out.println("IOException in FileFtpUploader: " + exc.getMessage());
            exc.printStackTrace();
            new DeleteFileQueryImplementor();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
