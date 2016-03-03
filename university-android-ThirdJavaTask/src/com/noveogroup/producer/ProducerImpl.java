package com.noveogroup.producer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Laptop;

/**
 * Created by serg3z on 24.02.16.
 */
public class ProducerImpl implements Producer, Runnable {
    private Buffer buffer;
    private static int countProducer = 0;
    private static int indexProducer = 0;
    private static int i = 0;

    private volatile boolean stop = false;

    public ProducerImpl(Buffer buffer) {
        this.buffer = buffer;
        countProducer++;
        indexProducer = countProducer;
    }

    @Override
    public void produceData() {
        Laptop str = new Laptop("asus" + i);
        i++;
        buffer.push(str);
    }

    @Override
    public void run() {
        produceData();
    }
}
