package repository.responsehandlers;

import repository.config.ConfigReader;
import repository.errorhandlers.FatalErrorHandler;

public class ResponseHandler {
    private static final String START_OF_TRANSMISSION = ConfigReader.getStartOfTransmission();
    private static final String END_OF_TEXT = ConfigReader.getEndOfText();
    private static final String NEXT_FILES_INFO_QUERY = ConfigReader.getNextFilesInfoQuery();
    private static final String PREV_FILES_INFO_QUERY = ConfigReader.getPrevFilesInfoQuery();
    private static final String FILE_INFO_UPLOAD_QUERY = ConfigReader.getFileInfoUploadQuery();
    private static final String LOG_IN_QUERY = ConfigReader.getLogInQuery();
    private static final String REGISTRATION_QUERY = ConfigReader.getRegistrationQuery();
    private static final String EDIT_PROFILE_QUERY = ConfigReader.getEditProfileQuery();
    private static final String CHANGE_PASSWORD_QUERY = ConfigReader.getChangePasswordQuery();
    private static final String DELETE_ACCOUNT_QUERY = ConfigReader.getDeleteAccountQuery();
    private static final String DELETE_FILE_INFO_QUERY = ConfigReader.getDeleteFileInfoQuery();
    private static final String DATA_BASE_OPERATION_ERROR = ConfigReader.getDataBaseOperationError();
    private static final String DATA_INTEGRITY_ERROR = ConfigReader.getDataIntegrityError();
    private static final String TRANSMISSION_ERROR = ConfigReader.getTransmissionError();
    private static final String UNKNOWN_QUERY_ERROR = ConfigReader.getUnknownQueryError();

    public static void exec(String[] serverResponse) {
        for (String item : serverResponse) {
            if (item.equals("")) {
                FatalErrorHandler.exec();
            }
        }

        String startOfTransmission = serverResponse[0];
        String queryType = serverResponse[1];
        String endOfTransmission = serverResponse[serverResponse.length - 1];
        if (startOfTransmission.equals(START_OF_TRANSMISSION)
                && endOfTransmission.equals(END_OF_TEXT)) {
            if (queryType.equals(NEXT_FILES_INFO_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                NextFilesInfoHandler.exec(serverResponse);
            } else if (queryType.equals(PREV_FILES_INFO_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                PrevFilesInfoHandler.exec(serverResponse);
            } else if (queryType.equals(FILE_INFO_UPLOAD_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                FileInfoUploadHandler.exec(serverResponse);
            } else if (queryType.equals(LOG_IN_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                LogInHandler.exec(serverResponse);
            } else if (queryType.equals(REGISTRATION_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                RegistrationHandler.exec(serverResponse);
            } else if (queryType.equals(EDIT_PROFILE_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                EditProfileHandler.exec(serverResponse);
            } else if (queryType.equals(CHANGE_PASSWORD_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                ChangePasswordHandler.exec(serverResponse);
            } else if (queryType.equals(DELETE_ACCOUNT_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                DeleteAccountHandler.exec(serverResponse);
            } else if (queryType.equals(DELETE_FILE_INFO_QUERY)) {
                FatalErrorHandler.resetNumberOfErrors();
                DeleteFileInfoHandler.exec(serverResponse);
            } else if (queryType.equals(DATA_BASE_OPERATION_ERROR)) {
                System.out.println("DATA_BASE_OPERATION_ERROR");
                FatalErrorHandler.exec();
            } else if (queryType.equals(DATA_INTEGRITY_ERROR)) {
                System.out.println("DATA_INTEGRITY_ERROR");
                FatalErrorHandler.exec();
            } else if (queryType.equals(TRANSMISSION_ERROR)) {
                System.out.println("TRANSMISSION_ERROR");
                FatalErrorHandler.exec();
            } else if (queryType.equals(UNKNOWN_QUERY_ERROR)) {
                System.out.println("UNKNOWN_QUERY_ERROR");
                FatalErrorHandler.exec();
            }
        } else {
            System.out.println("response data integrity error");
            FatalErrorHandler.exec();
        }
    }
}
