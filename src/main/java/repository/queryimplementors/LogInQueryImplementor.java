package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.loginscene.LogInSceneCreator;

public class LogInQueryImplementor extends Thread {
    public LogInQueryImplementor() {
        super();
        start();
    }

    public void run() {
        String userName = LogInSceneCreator.getUserName();
        String password = LogInSceneCreator.getPassword();
        String separator = ConfigReader.getSeparator();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getLogInQuery()).append(separator)
                .append(userName).append(separator).append(password).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
