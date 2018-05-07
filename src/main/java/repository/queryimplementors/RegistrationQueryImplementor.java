package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.registrationscene.RegistrationSceneCreator;

public class RegistrationQueryImplementor extends Thread {
    public RegistrationQueryImplementor() {
        super();
        start();
    }

    public void run() {
        String userName = RegistrationSceneCreator.getUserNameTf().getText();
        String password = RegistrationSceneCreator.getPasswordPf().getText();
        String firstName = RegistrationSceneCreator.getFirstNameTf().getText();
        String lastName = RegistrationSceneCreator.getLastNameTf().getText();
        String separator = ConfigReader.getSeparator();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getRegistrationQuery()).append(separator)
                .append(userName).append(separator).append(password).append(separator)
                .append(firstName).append(separator).append(lastName).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
