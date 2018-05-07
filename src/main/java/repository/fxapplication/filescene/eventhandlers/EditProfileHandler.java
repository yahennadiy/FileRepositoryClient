package repository.fxapplication.filescene.eventhandlers;

import repository.Main;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.editprofilescene.EditProfileSceneCreator;

public class EditProfileHandler implements EventHandlerInterface {
    public static void exec() {
        EditProfileSceneCreator.refresh();
        Main.getStage().setScene(EditProfileSceneCreator.getEditProfileScene());
    }
}
