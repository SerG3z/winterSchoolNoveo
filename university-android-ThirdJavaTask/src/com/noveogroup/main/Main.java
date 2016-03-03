package com.noveogroup.main;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.buffer.BufferImpl;
import com.noveogroup.consumer.ConsumerImpl;
import com.noveogroup.producer.ProducerImpl;

public class Main {

    public static void main(String[] args) {
        //You can check your solution here.
        Buffer buffer = new BufferImpl();

        int nProd = 11;
        int nCons = 15;

        Thread[] threadP = new Thread[nProd];
        for (int i = 0; i < nProd; i++) {
            threadP[i] = new Thread( new ProducerImpl(buffer));
            threadP[i].start();
        }

        Thread[] thread = new Thread[nCons];
        for (int i = 0; i < nCons; i++) {
            thread[i] = new Thread(new ConsumerImpl(buffer));
            thread[i].start();
            thread[i].interrupt();
        }
    }
}
