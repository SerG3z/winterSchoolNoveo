package com.noveogroup.exception;

/**
 * This is the base exception of your binary tree.
 * You can change it and create subclasses (ElementAlreadyExistsException, for example).
 */
public class BinaryTreeException extends Exception {
    public BinaryTreeException() {
        super("Binary tree exception");
    }

    public BinaryTreeException(String message) {
        super(message);
    }

    public BinaryTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinaryTreeException(Throwable cause) {
        super(cause);
    }

    public BinaryTreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
