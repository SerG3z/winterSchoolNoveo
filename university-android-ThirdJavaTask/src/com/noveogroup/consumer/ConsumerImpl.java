package com.noveogroup.consumer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;

import java.util.Random;

/**
 * Created by serg3z on 24.02.16.
 */
public class ConsumerImpl implements Consumer, Runnable {
    private Buffer buffer;

    public ConsumerImpl(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void consumeData(Data data) {

    }

    @Override
    public void run() {
        while (true) {
            String message = buffer.pop();
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
