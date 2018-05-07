package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;

public class DeleteFileQueryImplementor extends Thread {
    public DeleteFileQueryImplementor() {
        super();
        start();
    }

    public void run() {
        String fileName = Main.getFile().getFileName();
        String separator = ConfigReader.getSeparator();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getDeleteFileInfoQuery()).append(separator)
                .append(Main.getUser().getToken()).append(separator)
                .append(fileName).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
