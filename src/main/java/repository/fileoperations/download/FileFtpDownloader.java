package repository.fileoperations.download;

import javafx.application.Platform;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.filescene.FileSceneCreator;

import java.io.*;

public class FileFtpDownloader extends Thread {
    public FileFtpDownloader() {
        super();
        start();
    }

    public void run() {
        String host = ConfigReader.getHost();
        int port = ConfigReader.getFtpPort();
        String keyWord = ConfigReader.getKeyWord();
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(host, port);
            ftpClient.login(keyWord, keyWord);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String fileName = Main.getFile().getFileName();
            String targetFileDir = TargetFilesPathCreator.get();
            File targetFileDirFile = new File(targetFileDir);
            if (!targetFileDirFile.exists()) {
                targetFileDirFile.mkdir();
            }

            String targetFilePath = targetFileDir.concat(Main.getFile().getFileName());
            File targetFilePathFile = new File(targetFilePath);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFilePathFile));
            InputStream inputStream = ftpClient.retrieveFileStream(fileName);
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
                    FileSceneCreator.buttonOpener();
                    FileSceneCreator.getActionInfoLbl().setText("File downloaded.");
                });
                new BrowseRunner();
            } else {
                Platform.runLater(() -> {
                    FileSceneCreator.buttonOpener();
                    FileSceneCreator.getActionInfoLbl().setText("Sorry, file not downloaded.");
                });
            }
        } catch (NullPointerException | IOException exc) {
            exc.printStackTrace();
            Platform.runLater(() -> {
                FileSceneCreator.buttonOpener();
                FileSceneCreator.getActionInfoLbl().setText("Sorry, file not downloaded.");
            });
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
