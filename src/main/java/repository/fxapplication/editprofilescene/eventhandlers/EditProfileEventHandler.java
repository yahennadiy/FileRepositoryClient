package repository.fxapplication.editprofilescene.eventhandlers;

import javafx.scene.paint.Color;
import repository.Main;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.editprofilescene.EditProfileSceneCreator;
import repository.queryimplementors.EditProfileQueryImplementor;

public class EditProfileEventHandler implements EventHandlerInterface {
    public static void exec() {
        String firstName = EditProfileSceneCreator.getFirstNameTf().getText();
        String lastName = EditProfileSceneCreator.getLastNameTf().getText();
        if (firstName.length() > 0 && lastName.length() > 0) {
            if (!(firstName.equals(Main.getUser().getFirstName())
                    && lastName.equals(Main.getUser().getLastName()))) {
                EditProfileSceneCreator.getSaveChangesBtn().setDisable(true);
                EditProfileSceneCreator.getChangePasswordBtn().setDisable(true);
                EditProfileSceneCreator.getDeleteAccountBtn().setDisable(true);
                EditProfileSceneCreator.getFirstNameTf().setDisable(true);
                EditProfileSceneCreator.getLastNameTf().setDisable(true);
                EditProfileSceneCreator.getCancelBtn().setDisable(true);
                EditProfileSceneCreator.getActionInfoLbl().setText("Wait, please.");
                EditProfileSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
                new EditProfileQueryImplementor();
            } else {
                EditProfileSceneCreator.getActionInfoLbl().setText("Enter changes, please.");
                EditProfileSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
                EditProfileSceneCreator.getSaveChangesBtn().setDisable(true);
                EditProfileSceneCreator.getFirstNameTf().requestFocus();
            }
        } else {
            EditProfileSceneCreator.getActionInfoLbl().setText("Enter all fields, please.");
            EditProfileSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
        }
    }
}
