package com.noveogroup.main;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.buffer.BufferImpl;
import com.noveogroup.consumer.ConsumerImpl;
import com.noveogroup.producer.ProducerImpl;

public class Main {

    public static void main(String[] args) {
        //You can check your solution here.
        Buffer buffer = new BufferImpl();
        (new Thread(new ProducerImpl(buffer))).start();
        (new Thread(new ConsumerImpl(buffer))).start();
    }
}
