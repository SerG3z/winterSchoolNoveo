package com.noveogroup.exception;

/**
 * Created by serg on 23.02.16.
 */
public class NotFoundElementToTreeException extends BinaryTreeException {
    public NotFoundElementToTreeException() {
        super("Not found element to binary tree exception");
    }

    public NotFoundElementToTreeException(String message) {
        super(message);
    }

    public NotFoundElementToTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundElementToTreeException(Throwable cause) {
        super(cause);
    }

    public NotFoundElementToTreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
