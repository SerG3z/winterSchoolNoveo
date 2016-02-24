package com.noveogroup.exception;

/**
 * Created by serg on 24.02.16.
 */
public class ReadingFromFileException extends IOStreamBinaryTreeException {
    public ReadingFromFileException() {
        super("reading from file exception");
    }

    public ReadingFromFileException(String message) {
        super(message);
    }

    public ReadingFromFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadingFromFileException(Throwable cause) {
        super(cause);
    }
}
