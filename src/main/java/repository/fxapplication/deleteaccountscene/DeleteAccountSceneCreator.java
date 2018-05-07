package repository.fxapplication.deleteaccountscene;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import repository.fxapplication.Controller;
import repository.fxapplication.RepositorySceneInterface;

public class DeleteAccountSceneCreator implements RepositorySceneInterface {
    private static Scene deleteAccountScene;
    private static TextField passwordPf;
    private static TextField password2Pf;
    private static Label actionInfoLbl;
    private static Button cancelBtn;
    private static Button deleteAccountBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        GridPane deleteAccountRoot = new GridPane();
        deleteAccountRoot.setPadding(Controller.getInsets());
        deleteAccountRoot.setHgap(GAP);
        deleteAccountRoot.setVgap(GAP);
        Label passwordLbl = new Label("Password:");
        GridPane.setHalignment(passwordLbl, HPos.RIGHT);
        passwordPf = PasswordPasswordField.create();
        Label Password2Lbl = new Label("Repeat password:");
        GridPane.setHalignment(passwordLbl, HPos.RIGHT);
        password2Pf = Password2PasswordField.create();
        actionInfoLbl = new Label("Enter password, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        cancelBtn = CancelButton.create();
        GridPane.setHalignment(cancelBtn, HPos.RIGHT);
        deleteAccountBtn = DeleteAccountButton.create();
        GridPane.setHalignment(deleteAccountBtn, HPos.RIGHT);
        final int SIZE = Controller.getSize();
        deleteAccountScene = new Scene(deleteAccountRoot, SIZE, SIZE);
        deleteAccountRoot.add(passwordLbl, 0, 0);
        deleteAccountRoot.add(passwordPf, 1, 0);
        deleteAccountRoot.add(Password2Lbl, 0, 1);
        deleteAccountRoot.add(password2Pf, 1, 1);
        deleteAccountRoot.add(actionInfoLbl, 1, 2);
        deleteAccountRoot.add(cancelBtn, 0, 3);
        deleteAccountRoot.add(deleteAccountBtn, 1, 3);
    }

    public static void refresh() {
        passwordPf.clear();
        password2Pf.clear();
        passwordPf.requestFocus();
        actionInfoLbl.setText("Enter password, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        deleteAccountBtn.setDisable(false);
        passwordPf.setDisable(false);
        password2Pf.setDisable(false);
        cancelBtn.setDisable(false);
    }

    public static String getPassword() {
        return passwordPf.getText();
    }

    public static String getPassword2() {
        return password2Pf.getText();
    }

    public static Scene getDeleteAccountScene() {
        return deleteAccountScene;
    }

    public static TextField getPasswordPf() {
        return passwordPf;
    }

    public static TextField getPassword2Pf() {
        return password2Pf;
    }

    public static Label getActionInfoLbl() {
        return actionInfoLbl;
    }

    public static Button getCancelBtn() {
        return cancelBtn;
    }

    public static Button getDeleteAccountBtn() {
        return deleteAccountBtn;
    }
}
