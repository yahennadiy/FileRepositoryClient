package repository;

import javafx.application.Application;
import javafx.stage.Stage;
import repository.config.ConfigReader;
import repository.fxapplication.Controller;
import repository.fxapplication.loginscene.LogInSceneCreator;

public class Main extends Application {
    private static User user;
    private static File file;
    private static Query query;
    private static Stage stage;
    public static void main(String[] args) {
        user = new User();
        file = new File();
        query = new Query();
        ConfigReader.exec();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        stage.setTitle("File repository");
        Controller.init();
        stage.setScene(LogInSceneCreator.getLogInScene());
        stage.show();
    }

    public static User getUser() {
        return user;
    }

    public static File getFile() {
        return file;
    }

    public static Query getQuery() {
        return query;
    }

    public static Stage getStage() {
        return stage;
    }
}
