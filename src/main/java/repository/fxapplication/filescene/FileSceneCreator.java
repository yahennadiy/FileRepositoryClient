package repository.fxapplication.filescene;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import repository.Main;
import repository.fxapplication.Controller;
import repository.fxapplication.RepositorySceneInterface;

public class FileSceneCreator implements RepositorySceneInterface {
    private static Scene fileScene;
    private static GridPane fileRoot;
    private static Label userNameLbl;
    private static Button editProfileBtn;
    private static Button quitBtn;
    private static ListView<String> filesNamesLv;
    private static ScrollPane fileDescriptionSp;
    private static Button prevFilesBtn;
    private static Button nextFilesBtn;
    private static Button uploadBtn;
    private static Label actionInfoLbl;
    private static Button downloadBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        fileRoot = new GridPane();
        fileRoot.setPadding(Controller.getInsets());
        fileRoot.setHgap(GAP);
        fileRoot.setVgap(GAP);
        fileRoot.setAlignment(Pos.CENTER);
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHgrow(Priority.ALWAYS);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.ALWAYS);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHgrow(Priority.ALWAYS);
        fileRoot.getColumnConstraints().addAll(col0, col1, col2, col3, col4);
        RowConstraints row0 = new RowConstraints();
        row0.setVgrow(Priority.NEVER);
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.NEVER);
        fileRoot.getRowConstraints().addAll(row0, row1, row2, row3);
        userNameLbl = new Label(Main.getUser().getUserName());
        editProfileBtn = EditProfileButton.create();
        GridPane.setHalignment(editProfileBtn, HPos.RIGHT);
        quitBtn = QuitButton.create();
        GridPane.setHalignment(quitBtn, HPos.RIGHT);
        Label filesNamesLbl = new Label("Files names:");
        Label fileDescriptionLbl = new Label("File description:");
        filesNamesLv = FileNamesListView.create();
        fileDescriptionSp = FileDescriptionScrollPain.create();
        prevFilesBtn = PrevFilesButton.create();
        nextFilesBtn = NextFilesButton.create();
        GridPane.setHalignment(nextFilesBtn, HPos.RIGHT);
        actionInfoLbl = new Label();
        uploadBtn = UploadButton.create();
        downloadBtn = DownloadButton.create();
        GridPane.setHalignment(downloadBtn, HPos.RIGHT);
        final int SIZE = Controller.getSize();
        fileScene = new Scene(fileRoot, SIZE, SIZE);
        fileRoot.add(userNameLbl, 2, 0);
        fileRoot.add(editProfileBtn, 3, 0);
        fileRoot.add(quitBtn, 4, 0);
        fileRoot.add(filesNamesLbl, 0, 1);
        fileRoot.add(fileDescriptionLbl, 2, 1);
        fileRoot.add(filesNamesLv, 0, 2, 2, 1);
        fileRoot.add(fileDescriptionSp, 2, 2, 3, 1);
        fileRoot.add(prevFilesBtn, 0, 3);
        fileRoot.add(nextFilesBtn, 1, 3);
        fileRoot.add(uploadBtn, 2, 3);
        fileRoot.add(actionInfoLbl, 3, 3);
        fileRoot.add(downloadBtn, 4, 3);
    }

    public static void refresh() {
        userNameLbl.setText(Main.getUser().getUserName());
        actionInfoLbl.setText("");
        prevFilesBtn.setDisable(true);
        nextFilesBtn.setDisable(true);
        downloadBtn.setDisable(false);
    }

    public static void buttonOpener() {
        downloadBtn.setDisable(false);
        editProfileBtn.setDisable(false);
        quitBtn.setDisable(false);
        uploadBtn.setDisable(false);
    }

    public static void filesNamesListViewRepaint() {
        fileRoot.getChildren().remove(filesNamesLv);
        filesNamesLv = FileNamesListView.create();
        fileRoot.add(filesNamesLv, 0, 2, 2, 1);
    }

    public static void fileDescriptionScrollPainRepaint() {
        fileRoot.getChildren().remove(fileDescriptionSp);
        fileDescriptionSp = FileDescriptionScrollPain.create();
        fileRoot.add(fileDescriptionSp, 2, 2, 3, 1);
    }

    public static GridPane getFileRoot() {
        return fileRoot;
    }

    public static Scene getFileScene() {
        return fileScene;
    }

    public static Button getEditProfileBtn() {
        return editProfileBtn;
    }

    public static Button getQuitBtn() {
        return quitBtn;
    }

    public static ListView<String> getFilesNamesLv() {
        return filesNamesLv;
    }

    public static Button getPrevFilesBtn() {
        return prevFilesBtn;
    }

    public static Button getNextFilesBtn() {
        return nextFilesBtn;
    }

    public static Button getUploadBtn() {
        return uploadBtn;
    }

    public static Label getActionInfoLbl() {
        return actionInfoLbl;
    }

    public static Button getDownloadBtn() {
        return downloadBtn;
    }
}
