package org.group.portfolio.Response;


// this enum is responsible for creating general error messages for specific ones we can call the AppExceptions and give it an error message
public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing require field"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
    NO_RECORD_FOUND("Record with provided id is not found");

    private String errorMessage;

    private ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
