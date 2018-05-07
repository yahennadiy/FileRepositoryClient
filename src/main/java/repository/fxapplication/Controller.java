package repository.fxapplication;

import javafx.geometry.Insets;
import repository.fxapplication.changepasswordscene.ChangePasswordSceneCreator;
import repository.fxapplication.deleteaccountscene.DeleteAccountSceneCreator;
import repository.fxapplication.editprofilescene.EditProfileSceneCreator;
import repository.fxapplication.filescene.FileSceneCreator;
import repository.fxapplication.loginscene.LogInSceneCreator;
import repository.fxapplication.registrationscene.RegistrationSceneCreator;
import repository.fxapplication.uploadfilescene.UploadFileSceneCreator;

public class Controller {
    private static final int SIZE = 610;
    private static final int GAP = 10;
    private static final Insets INSETS = new Insets(10);

    public static void init() {
        FileSceneCreator.create();
        LogInSceneCreator.create();
        RegistrationSceneCreator.create();
        EditProfileSceneCreator.create();
        DeleteAccountSceneCreator.create();
        ChangePasswordSceneCreator.create();
        UploadFileSceneCreator.create();
    }

    public static int getSize() {
        return SIZE;
    }

    public static Insets getInsets() {
        return INSETS;
    }

    public static int getGap() {
        return GAP;
    }
}
