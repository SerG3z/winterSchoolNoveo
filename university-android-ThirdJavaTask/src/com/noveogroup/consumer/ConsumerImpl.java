package com.noveogroup.consumer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;

/**
 * Created by serg3z on 24.02.16.
 */
public class ConsumerImpl implements Consumer, Runnable {
    private Buffer<Data> buffer;
    public ConsumerImpl(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void consumeData(Data data) {
        if (data == null) {
            return;
        }
        String message = data.getName();
        System.out.format("MESSAGE RECEIVED: %s%n", message);
    }

    @Override
    public void run() {
        consumeData(buffer.pop());
    }

}
