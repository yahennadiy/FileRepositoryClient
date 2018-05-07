package repository.fxapplication.editprofilescene;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import repository.Main;
import repository.fxapplication.Controller;
import repository.fxapplication.RepositorySceneInterface;

public class EditProfileSceneCreator implements RepositorySceneInterface {
    private static Scene editProfileScene;
    private static TextField userNameTf;
    private static TextField firstNameTf;
    private static TextField lastNameTf;
    private static Label actionInfoLbl;
    private static Button saveChangesBtn;
    private static Button changePasswordBtn;
    private static Button deleteAccountBtn;
    private static Button cancelBtn;

    public static void create() {
        final int GAP = Controller.getGap();
        GridPane editProfileRoot = new GridPane();
        editProfileRoot.setPadding(Controller.getInsets());
        editProfileRoot.setHgap(GAP);
        editProfileRoot.setVgap(GAP);
        Label emailLbl = new Label("Username:");
        GridPane.setHalignment(emailLbl, HPos.RIGHT);
        userNameTf = UserNameTextField.create();
        userNameTf.setDisable(true);
        Label firstNameLbl = new Label("First name:");
        GridPane.setHalignment(firstNameLbl, HPos.RIGHT);
        firstNameTf = FirstNameTextField.create();
        Label lastNameLbl = new Label("Last name");
        GridPane.setHalignment(lastNameLbl, HPos.RIGHT);
        lastNameTf = LastNameTextField.create();
        actionInfoLbl = new Label("Enter all fields, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        saveChangesBtn = SaveChangesButton.create();
        GridPane.setHalignment(saveChangesBtn, HPos.RIGHT);
        cancelBtn = CancelButton.create();
        GridPane.setHalignment(cancelBtn, HPos.RIGHT);
        changePasswordBtn = ChangePasswordButton.create();
        GridPane.setHalignment(changePasswordBtn, HPos.RIGHT);
        deleteAccountBtn = DeleteAccountButton.create();
        GridPane.setHalignment(deleteAccountBtn, HPos.RIGHT);
        final int SIZE = Controller.getSize();
        editProfileScene = new Scene(editProfileRoot, SIZE, SIZE);
        editProfileRoot.add(emailLbl, 0, 0);
        editProfileRoot.add(userNameTf, 1, 0);
        editProfileRoot.add(firstNameLbl, 0, 1);
        editProfileRoot.add(firstNameTf, 1, 1);
        editProfileRoot.add(lastNameLbl, 0, 2);
        editProfileRoot.add(lastNameTf, 1, 2);
        editProfileRoot.add(actionInfoLbl, 1, 3);
        editProfileRoot.add(cancelBtn, 0, 4);
        editProfileRoot.add(saveChangesBtn, 1, 4);
        editProfileRoot.add(changePasswordBtn, 1, 5);
        editProfileRoot.add(deleteAccountBtn, 1, 6);
    }

    public static void refresh() {
        userNameTf.setText(Main.getUser().getUserName());
        firstNameTf.setText(Main.getUser().getFirstName());
        lastNameTf.setText(Main.getUser().getLastName());
        firstNameTf.requestFocus();
        actionInfoLbl.setText("Enter all fields, please.");
        actionInfoLbl.setTextFill(Color.BLACK);
        saveChangesBtn.setDisable(true);
        changePasswordBtn.setDisable(false);
        deleteAccountBtn.setDisable(false);
        firstNameTf.setDisable(false);
        lastNameTf.setDisable(false);
        cancelBtn.setDisable(false);
    }

    public static String getFirstName() {
        return firstNameTf.getText();
    }

    public static String getLastName() {
        return lastNameTf.getText();
    }

    public static Scene getEditProfileScene() {
        return editProfileScene;
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

    public static Button getSaveChangesBtn() {
        return saveChangesBtn;
    }

    public static Button getChangePasswordBtn() {
        return changePasswordBtn;
    }

    public static Button getDeleteAccountBtn() {
        return deleteAccountBtn;
    }

    public static Button getCancelBtn() {
        return cancelBtn;
    }
}
