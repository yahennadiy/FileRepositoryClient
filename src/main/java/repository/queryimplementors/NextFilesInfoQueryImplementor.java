package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;

public class NextFilesInfoQueryImplementor extends Thread {
    private String fromFileName;

    public NextFilesInfoQueryImplementor(String fromFileName) {
        super();
        this.fromFileName = fromFileName;
        start();
    }

    public void run() {
        String separator = ConfigReader.getSeparator();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getNextFilesInfoQuery()).append(separator)
                .append(Main.getUser().getToken()).append(separator)
                .append(fromFileName).append(separator)
                .append(ConfigReader.getNumberOfRowsToSelect()).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
