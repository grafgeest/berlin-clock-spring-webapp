package com.ubs.opsit.interviews.exception;

public class IllegalTimeFormatException extends RuntimeException {

    public IllegalTimeFormatException() {
        super();
    }

    public IllegalTimeFormatException(String message) {
        super(message);
    }

    public IllegalTimeFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTimeFormatException(Throwable cause) {
        super(cause);
    }

    public IllegalTimeFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
