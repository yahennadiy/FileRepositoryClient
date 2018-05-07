package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.NewFile;
import repository.config.ConfigReader;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;

public class UploadFileQueryImplementor extends Thread {
    public UploadFileQueryImplementor() {
        super();
        start();
    }

    public void run() {
        String separator = ConfigReader.getSeparator();
        String fileName = NewFile.getFileName();
        String fileOwner = Integer.toString(Main.getUser().getUserId());
        String fileDescriptor = UploadFileSceneCreator.getDescriptionTextArea().getText();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getFileInfoUploadQuery()).append(separator)
                .append(Main.getUser().getToken()).append(separator)
                .append(fileName).append(separator)
                .append(fileOwner).append(separator)
                .append(fileDescriptor).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
