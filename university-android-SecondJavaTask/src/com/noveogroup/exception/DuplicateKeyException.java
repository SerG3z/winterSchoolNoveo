package com.noveogroup.exception;

/**
 * Created by serg on 24.02.16.
 */
public class DuplicateKeyException extends BinaryTreeException {
    public DuplicateKeyException() {
        super("this key is already in binary tree exception");
    }

    public DuplicateKeyException(String message) {
        super(message);
    }

    public DuplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateKeyException(Throwable cause) {
        super(cause);
    }

    public DuplicateKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
