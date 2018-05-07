package repository.fxapplication.filescene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import repository.Main;
import repository.fxapplication.filescene.infoarroundkeepers.FilesInfoArrKeeper;

public class FileNamesListView {
    public static ListView<String> create() {
        ObservableList<String> filesNameObsList =
                FXCollections.observableArrayList(FilesInfoArrKeeper.getFilesNameArr());
        ListView<String> fileNamesLv = new ListView<String>(filesNameObsList);
        MultipleSelectionModel<String> lvSelModelFiles =
                fileNamesLv.getSelectionModel();
        lvSelModelFiles.selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    int index = FileSceneCreator.getFilesNamesLv().getSelectionModel().getSelectedIndex();
                    Main.getFile().setAll(FilesInfoArrKeeper.getFileId(index),
                            FilesInfoArrKeeper.getFileName(index),
                            FilesInfoArrKeeper.getFileOwner(index),
                            FilesInfoArrKeeper.getFileDescription(index),
                            FilesInfoArrKeeper.getFileUrl(index));
                    FileSceneCreator.fileDescriptionScrollPainRepaint();
                    Main.getStage().setScene(FileSceneCreator.getFileScene());
                }
        );
        return fileNamesLv;
    }
}
