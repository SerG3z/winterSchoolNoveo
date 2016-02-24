package com.noveogroup.exception;

/**
 * Created by serg on 23.02.16.
 */
public class WritingToFileException extends IOStreamBinaryTreeException {
    public WritingToFileException() {
        super("Writing to file exception");
    }

    public WritingToFileException(String message) {
        super(message);
    }

    public WritingToFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WritingToFileException(Throwable cause) {
        super(cause);
    }
}
