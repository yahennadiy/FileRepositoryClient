package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;
import repository.fxapplication.editprofilescene.EditProfileSceneCreator;

public class EditProfileQueryImplementor extends Thread {
    public EditProfileQueryImplementor() {
       super();
       start();
    }

    public void run() {
        String separator = ConfigReader.getSeparator();
        String toServerQuery = new StringBuilder().append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getEditProfileQuery()).append(separator)
                .append(Main.getUser().getToken()).append(separator)
                .append(Main.getUser().getUserName()).append(separator)
                .append(EditProfileSceneCreator.getFirstName()).append(separator)
                .append(EditProfileSceneCreator.getLastName()).append(separator)
                .append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        Main.getQuery().setQueryString(toServerQuery);
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
