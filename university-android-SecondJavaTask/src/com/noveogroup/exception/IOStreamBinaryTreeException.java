package com.noveogroup.exception;

import java.io.IOException;

/**
 * Created by serg on 24.02.16.
 */
public class IOStreamBinaryTreeException extends IOException {
    public IOStreamBinaryTreeException() {
        super("writing or reading exception");
    }

    public IOStreamBinaryTreeException(String message) {
        super(message);
    }

    public IOStreamBinaryTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOStreamBinaryTreeException(Throwable cause) {
        super(cause);
    }
}
