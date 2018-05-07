package repository.fxapplication.changepasswordscene;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import repository.fxapplication.Controller;
import repository.fxapplication.RepositorySceneInterface;

public class ChangePasswordSceneCreator implements RepositorySceneInterface {
    private static Scene changePasswordScene;
    private static TextField passwordPf;
    private static TextField newPasswordPf;
    private static TextField newPassword2Pf;
    private static Label actionInfoLbl;
    private static Button cancelBtn;
    private static Button changePasswordBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        GridPane changePasswordRoot = new GridPane();
        changePasswordRoot.setPadding(Controller.getInsets());
        changePasswordRoot.setHgap(GAP);
        changePasswordRoot.setVgap(GAP);
        Label passwordLbl = new Label("Old password:");
        GridPane.setHalignment(passwordLbl, HPos.RIGHT);
        passwordPf = PasswordPasswordField.create();
        Label newPasswordLbl = new Label("New password:");
        GridPane.setHalignment(newPasswordLbl, HPos.RIGHT);
        newPasswordPf = NewPasswordPasswordField.create();
        Label newPassword2Lbl = new Label("Repeat new password:");
        GridPane.setHalignment(newPassword2Lbl, HPos.RIGHT);
        newPassword2Pf = NewPassword2PasswordField.create();
        actionInfoLbl = new Label("Enter all fields, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        cancelBtn = CancelButton.create();
        GridPane.setHalignment(cancelBtn, HPos.RIGHT);
        changePasswordBtn = ChangePasswordButton.create();
        GridPane.setHalignment(changePasswordBtn, HPos.RIGHT);
        final int SIZE = Controller.getSize();
        changePasswordScene = new Scene(changePasswordRoot, SIZE, SIZE);
        changePasswordRoot.add(passwordLbl, 0, 0);
        changePasswordRoot.add(passwordPf, 1, 0);
        changePasswordRoot.add(newPasswordLbl, 0, 1);
        changePasswordRoot.add(newPasswordPf, 1, 1);
        changePasswordRoot.add(newPassword2Lbl, 0, 2);
        changePasswordRoot.add(newPassword2Pf, 1, 2);
        changePasswordRoot.add(actionInfoLbl, 1, 3);
        changePasswordRoot.add(cancelBtn, 0, 4);
        changePasswordRoot.add(changePasswordBtn, 1, 4);
    }

    public static void refresh() {
        passwordPf.clear();
        newPasswordPf.clear();
        newPassword2Pf.clear();
        passwordPf.requestFocus();
        actionInfoLbl.setText("Enter all fields, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        changePasswordBtn.setDisable(false);
        passwordPf.setDisable(false);
        newPasswordPf.setDisable(false);
        newPassword2Pf.setDisable(false);
        cancelBtn.setDisable(false);
    }

    public static String getPassword() {
        return passwordPf.getText();
    }

    public static String getNewPassword() {
        return newPasswordPf.getText();
    }

    public static String getNewPassword2() {
        return newPassword2Pf.getText();
    }

    public static Scene getChangePasswordScene() {
        return changePasswordScene;
    }

    public static TextField getPasswordPf() {
        return passwordPf;
    }

    public static TextField getNewPasswordPf() {
        return newPasswordPf;
    }

    public static TextField getNewPassword2Pf() {
        return newPassword2Pf;
    }

    public static Label getActionInfoLbl() {
        return actionInfoLbl;
    }

    public static Button getCancelBtn() {
        return cancelBtn;
    }

    public static Button getChangePasswordBtn() {
        return changePasswordBtn;
    }
}
