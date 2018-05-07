package repository.fxapplication.filescene;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import repository.Main;

public class FileDescriptionScrollPain {
    public static ScrollPane create () {
        Label label = new Label(Main.getFile().getFileDescription());
        label.setWrapText(true);
        ScrollPane fileDescriptionScrollPain = new ScrollPane(label);
        fileDescriptionScrollPain.setFitToWidth(true);
        return fileDescriptionScrollPain;
    }
}
