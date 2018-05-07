package repository.fxapplication.registrationscene.eventhandlers;

import javafx.scene.paint.Color;
import repository.fxapplication.EventHandlerInterface;
import repository.fxapplication.registrationscene.RegistrationSceneCreator;
import repository.queryimplementors.RegistrationQueryImplementor;

public class RegistrationHandler implements EventHandlerInterface {
    public static void exec() {
        String userName = RegistrationSceneCreator.getUserNameTf().getText();
        String password = RegistrationSceneCreator.getPasswordPf().getText();
        String password2 = RegistrationSceneCreator.getPassword2Pf().getText();
        String firstName = RegistrationSceneCreator.getFirstNameTf().getText();
        String lastName = RegistrationSceneCreator.getLastNameTf().getText();
        if (userName.length() > 0 && password.length() > 0 && password2.length() > 0
                && firstName.length() > 0 && lastName.length() > 0) {
            if (!password.equals(password2)) {
                RegistrationSceneCreator.getActionInfoLbl().setText("Repeat input password, please.");
                RegistrationSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
                RegistrationSceneCreator.getPasswordPf().clear();
                RegistrationSceneCreator.getPassword2Pf().clear();
            } else {
                RegistrationSceneCreator.getRegistrationBtn().setDisable(true);
                RegistrationSceneCreator.getUserNameTf().setDisable(true);
                RegistrationSceneCreator.getFirstNameTf().setDisable(true);
                RegistrationSceneCreator.getLastNameTf().setDisable(true);
                RegistrationSceneCreator.getPasswordPf().setDisable(true);
                RegistrationSceneCreator.getPassword2Pf().setDisable(true);
                RegistrationSceneCreator.getCancelBtn().setDisable(true);
                RegistrationSceneCreator.getActionInfoLbl().setText("Wait, please.");
                RegistrationSceneCreator.getActionInfoLbl().setTextFill(Color.BLACK);
                new RegistrationQueryImplementor();
            }
        } else {
            RegistrationSceneCreator.getActionInfoLbl().setText("Enter all fields, please.");
            RegistrationSceneCreator.getActionInfoLbl().setTextFill(Color.RED);
        }
    }
}
