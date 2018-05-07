package repository.queryimplementors;

import repository.ClientContainer;
import repository.Main;
import repository.config.ConfigReader;

public class RepeatQueryImplementor {
    public static void exec() {
        String toServerQuery = Main.getQuery().getQueryString();
        new ClientContainer(ConfigReader.getHost(), ConfigReader.getPort(), toServerQuery);
    }
}
