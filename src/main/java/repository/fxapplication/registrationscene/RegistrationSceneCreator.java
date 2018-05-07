package repository.fxapplication.registrationscene;

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

public class RegistrationSceneCreator implements RepositorySceneInterface {
    private static Scene registrationScene;
    private static TextField userNameTf;
    private static PasswordField passwordPf;
    private static PasswordField password2Pf;
    private static TextField firstNameTf;
    private static TextField lastNameTf;
    private static Label actionInfoLbl;
    private static Button cancelBtn;
    private static Button registrationBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        GridPane registrationRoot = new GridPane();
        registrationRoot.setPadding(Controller.getInsets());
        registrationRoot.setHgap(GAP);
        registrationRoot.setVgap(GAP);
        Label userNameLbl = new Label("Username:");
        GridPane.setHalignment(userNameLbl, HPos.RIGHT);
        userNameTf = UserNameTextField.create();
        Label firstNameLbl = new Label("First name:");
        GridPane.setHalignment(firstNameLbl, HPos.RIGHT);
        firstNameTf = FirstNameTextField.create();
        Label lastNameLbl = new Label("Last name");
        GridPane.setHalignment(lastNameLbl, HPos.RIGHT);
        lastNameTf = LastNameTextField.create();
        Label passwordLbl = new Label("Password:");
        GridPane.setHalignment(passwordLbl, HPos.RIGHT);
        passwordPf = PasswordPasswordField.create();
        Label password2Lbl = new Label("Repeat password:");
        GridPane.setHalignment(password2Lbl, HPos.RIGHT);
        password2Pf = Password2PasswordField.create();
        actionInfoLbl = new Label("Enter all fields, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        cancelBtn = CancelButton.create();
        GridPane.setHalignment(cancelBtn, HPos.RIGHT);
        registrationBtn = RegistrationButton.create();
        GridPane.setHalignment(registrationBtn, HPos.RIGHT);
        final int SIZE = Controller.getSize();
        registrationScene = new Scene(registrationRoot, SIZE, SIZE);
        registrationRoot.add(userNameLbl, 0, 0);
        registrationRoot.add(userNameTf, 1, 0);
        registrationRoot.add(firstNameLbl, 0, 1);
        registrationRoot.add(firstNameTf, 1, 1);
        registrationRoot.add(lastNameLbl, 0, 2);
        registrationRoot.add(lastNameTf, 1, 2);
        registrationRoot.add(passwordLbl, 0, 3);
        registrationRoot.add(passwordPf, 1, 3);
        registrationRoot.add(password2Lbl, 0, 4);
        registrationRoot.add(password2Pf, 1, 4);
        registrationRoot.add(actionInfoLbl, 1, 5);
        registrationRoot.add(cancelBtn, 0, 6);
        registrationRoot.add(registrationBtn, 1, 6);
    }

    public static void refresh() {
        userNameTf.clear();
        passwordPf.clear();
        password2Pf.clear();
        firstNameTf.clear();
        lastNameTf.clear();
        userNameTf.requestFocus();
        actionInfoLbl.setText("Enter all fields, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        userNameTf.setDisable(false);
        firstNameTf.setDisable(false);
        lastNameTf.setDisable(false);
        passwordPf.setDisable(false);
        password2Pf.setDisable(false);
        registrationBtn.setDisable(false);
        cancelBtn.setDisable(false);
    }

    public static Scene getRegistrationScene() {
        return registrationScene;
    }

    public static TextField getUserNameTf() {
        return userNameTf;
    }

    public static PasswordField getPasswordPf() {
        return passwordPf;
    }

    public static PasswordField getPassword2Pf() {
        return password2Pf;
    }

    public static TextField getFirstNameTf() {
        return firstNameTf;
    }

    public static TextField getLastNameTf() {
        return lastNameTf;
    }

    public static Label getActionInfoLbl() {
        return actionInfoLbl;
    }

    public static Button getCancelBtn() {
        return cancelBtn;
    }

    public static Button getRegistrationBtn() {
        return registrationBtn;
    }
}
