package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.changepasswordscene.ChangePasswordSceneCreator;

public class ChangePasswordQueryImplementor extends Thread {
    public ChangePasswordQueryImplementor() {
        super();
        start();
    }

    public void run() {
        String separator = ConfigReader.getSeparator();
        String password = ChangePasswordSceneCreator.getPassword();
        String newPassword = ChangePasswordSceneCreator.getNewPassword();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getChangePasswordQuery()).append(separator)
                .append(Main.getUser().getToken()).append(separator)
                .append(Main.getUser().getUserName()).append(separator)
                .append(password).append(separator)
                .append(newPassword).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
