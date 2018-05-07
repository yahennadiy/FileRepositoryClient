package repository.fxapplication.uploadfilescene;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import repository.NewFile;
import repository.fileoperations.upload.SourceFilesPathCreator;
import repository.fxapplication.Controller;
import repository.fxapplication.RepositorySceneInterface;

public class UploadFileSceneCreator implements RepositorySceneInterface {
    private static Scene uploadFileScene;
    private static GridPane uploadRoot;
    private static ListView<String> fileNamesLv;
    private static TextArea descriptionTextArea;
    private static Button selectFileBtn;
    private static Label selectedFileLbl;
    private static Label actionInfoLbl;
    private static Button cancelBtn;
    private static Button uploadBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        uploadRoot = new GridPane();
        uploadRoot.setPadding(Controller.getInsets());
        uploadRoot.setHgap(GAP);
        uploadRoot.setVgap(GAP);
        uploadRoot.setAlignment(Pos.CENTER);
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHgrow(Priority.NEVER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.ALWAYS);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHgrow(Priority.ALWAYS);
        uploadRoot.getColumnConstraints().addAll(col0, col1, col2, col3, col4);
        RowConstraints row0 = new RowConstraints();
        row0.setVgrow(Priority.NEVER);
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.NEVER);
        RowConstraints row4 = new RowConstraints();
        row4.setVgrow(Priority.NEVER);
        uploadRoot.getRowConstraints().addAll(row0, row1, row2, row3, row4);
        Label sourceDirNameLbl = new Label(SourceFilesPathCreator.get());
        Label sourceFileNameLbl = new Label("Source files:");
        Label fileDescriptionLbl = new Label("New file's description:");
        fileNamesLv = FileNamesListView.create();
        descriptionTextArea = DescriptionTextArea.create();
        selectFileBtn = SelectFileButton.create();
        selectedFileLbl = new Label("Selected: ");
        actionInfoLbl = new Label("");
        uploadBtn = UploadFileButton.create();
        GridPane.setHalignment(uploadBtn, HPos.RIGHT);
        cancelBtn = CancelButton.create();
        final int SIZE = Controller.getSize();
        uploadFileScene = new Scene(uploadRoot, SIZE, SIZE);
        uploadRoot.add(sourceDirNameLbl, 0, 0);
        uploadRoot.add(sourceFileNameLbl, 0, 1);
        uploadRoot.add(fileDescriptionLbl, 2, 1);
        uploadRoot.add(fileNamesLv, 0, 2, 2, 1);
        uploadRoot.add(descriptionTextArea, 2, 2, 3, 1);
        uploadRoot.add(selectFileBtn, 0, 3);
        uploadRoot.add(selectedFileLbl, 2, 3);
        uploadRoot.add(cancelBtn, 0, 4);
        uploadRoot.add(actionInfoLbl, 2, 4);
        uploadRoot.add(uploadBtn, 4, 4);
    }

    public static void refresh() {
        actionInfoLbl.setText("");
        NewFile.setFileName("");
        selectedFileLbl.setText("Selected: ");
        filesNamesListViewRepaint();
        selectFileBtn.setDisable(false);
        uploadBtn.setDisable(true);
    }

    public static void buttonOpener() {
        selectFileBtn.setDisable(false);
        cancelBtn.setDisable(false);
    }

    public static void filesNamesListViewRepaint() {
        uploadRoot.getChildren().remove(fileNamesLv);
        fileNamesLv = FileNamesListView.create();
        uploadRoot.add(fileNamesLv, 0, 2, 2, 1);
    }

    public static Scene getUploadFileScene() {
        return uploadFileScene;
    }

    public static ListView<String> getFileNamesLv() {
        return fileNamesLv;
    }

    public static TextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public static Button getSelectFileBtn() {
        return selectFileBtn;
    }

    public static Label getSelectedFileLbl() {
        return selectedFileLbl;
    }

    public static Label getActionInfoLbl() {
        return actionInfoLbl;
    }

    public static Button getCancelBtn() {
        return cancelBtn;
    }

    public static Button getUploadBtn() {
        return uploadBtn;
    }
}
