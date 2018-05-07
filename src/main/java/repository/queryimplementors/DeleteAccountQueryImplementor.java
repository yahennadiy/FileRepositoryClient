package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.deleteaccountscene.DeleteAccountSceneCreator;

public class DeleteAccountQueryImplementor extends Thread {
    public DeleteAccountQueryImplementor() {
        super();
        start();
    }

    public void run() {
        String userName = Main.getUser().getUserName();
        String separator = ConfigReader.getSeparator();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getDeleteAccountQuery()).append(separator)
                .append(Main.getUser().getToken()).append(separator)
                .append(userName).append(separator)
                .append(DeleteAccountSceneCreator.getPassword()).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
