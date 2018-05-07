package repository.fxapplication.uploadfilescene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import repository.fileoperations.upload.SourceFilesNameArrCreator;

public class FileNamesListView {
    public static ListView<String> create() {
        ObservableList<String> filesNameObsList =
                FXCollections.observableArrayList(SourceFilesNameArrCreator.exec());
        ListView<String> fileNamesLv = new ListView<String>(filesNameObsList);
        return fileNamesLv;
    }
}
