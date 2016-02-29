package com.noveogroup.producer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;

/**
 * Created by serg3z on 24.02.16.
 */
public class ProducerImpl implements Producer, Runnable {
    private Buffer buffer;
    private static int countProducer = 0;
    private static int indexProducer = 0;

    private volatile boolean stop = false;

    public ProducerImpl(Buffer buffer) {
        this.buffer = buffer;
        countProducer++;
        indexProducer = countProducer;
    }

    @Override
    public Data produceData() {
        return null;
    }

    @Override
    public void run() {
        while (!stop) {
            buffer.push();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("producer - exception interrupt");
                stop = true;
            }
        }
    }
}
