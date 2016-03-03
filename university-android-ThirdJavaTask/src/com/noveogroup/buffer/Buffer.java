package com.noveogroup.buffer;

/**
 * Data buffer.
 */
public interface Buffer<T> {
    public T pop();

    public void push(T data);
}
