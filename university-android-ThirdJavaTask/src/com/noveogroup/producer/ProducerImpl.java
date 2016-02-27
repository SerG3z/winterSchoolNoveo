package com.noveogroup.producer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;

import java.util.Random;

/**
 * Created by serg3z on 24.02.16.
 */
public class ProducerImpl implements Producer, Runnable {
    private Buffer buffer;
    private static int countProducer = 0;
    private static int indexProducer = 0;

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
        while (true) {
            buffer.push();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
