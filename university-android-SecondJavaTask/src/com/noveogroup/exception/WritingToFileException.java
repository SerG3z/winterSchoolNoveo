package com.noveogroup.exception;

import java.io.IOException;

/**
 * Created by serg on 23.02.16.
 */
public class WritingToFileException extends IOException {
    public WritingToFileException() {
        super("Writing to file Exception");
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
