package repository.fxapplication.loginscene;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import repository.fxapplication.Controller;
import repository.fxapplication.RepositorySceneInterface;

public class LogInSceneCreator implements RepositorySceneInterface {
    private static Scene logInScene;
    private static TextField userNameTf;
    private static PasswordField passwordPf;
    private static Label actionInfoLbl;
    private static Button logInBtn;
    private static Button registrationBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        GridPane logInRoot = new GridPane();
        logInRoot.setPadding(Controller.getInsets());
        logInRoot.setHgap(GAP);
        logInRoot.setVgap(GAP);
        Label userNameLbl = new Label("Username:");
        GridPane.setHalignment(userNameLbl, HPos.RIGHT);
        userNameTf = UserNameTextField.create();
        Label passwordLbl = new Label("Password:");
        GridPane.setHalignment(passwordLbl, HPos.RIGHT);
        passwordPf = PasswordPasswordField.create();
        actionInfoLbl = new Label("Enter username and password, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        logInBtn = LogInButton.create();
        GridPane.setHalignment(logInBtn, HPos.RIGHT);
        registrationBtn = RegistrationButton.create();
        GridPane.setHalignment(registrationBtn, HPos.RIGHT);
        final int SIZE = Controller.getSize();
        logInScene = new Scene(logInRoot, SIZE, SIZE);
        logInRoot.add(userNameLbl, 0, 0);
        logInRoot.add(userNameTf, 1, 0);
        logInRoot.add(passwordLbl, 0, 1);
        logInRoot.add(passwordPf, 1, 1);
        logInRoot.add(actionInfoLbl, 1, 2);
        logInRoot.add(logInBtn, 1, 3);
        logInRoot.add(registrationBtn, 1, 4);
    }

    public static void refresh() {
        userNameTf.clear();
        passwordPf.clear();
        userNameTf.requestFocus();
        actionInfoLbl.setText("Enter username and password, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        userNameTf.setDisable(false);
        passwordPf.setDisable(false);
        logInBtn.setDisable(false);
        registrationBtn.setDisable(false);
    }

    public static Scene getLogInScene() {
        return logInScene;
    }

    public static String getUserName() {
        return userNameTf.getText();
    }

    public static String getPassword() {
        return passwordPf.getText();
    }

    public static TextField getUserNameTf() {
        return userNameTf;
    }

    public static PasswordField getPasswordPf() {
        return passwordPf;
    }

    public static Label getActionInfoLbl() {
        return actionInfoLbl;
    }

    public static Button getLogInBtn() {
        return logInBtn;
    }

    public static Button getRegistrationBtn() {
        return registrationBtn;
    }
}
