package com.noveogroup.consumer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;

/**
 * Created by serg3z on 24.02.16.
 */
public class ConsumerImpl implements Consumer, Runnable {
    private Buffer buffer;

    private volatile boolean stop = false;

    public ConsumerImpl(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void consumeData(Data data) {

    }

    @Override
    public void run() {
        while (!stop) {
            String message = buffer.pop();
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("consumer - exception interrupt");
                stop = true;
            }
        }
    }
}
