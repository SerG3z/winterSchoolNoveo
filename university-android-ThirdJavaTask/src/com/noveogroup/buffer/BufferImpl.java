package com.noveogroup.buffer;

import com.noveogroup.data.Data;

import java.util.LinkedList;

/**
 * Created by serg3z on 24.02.16.
 */
public class BufferImpl implements Buffer<Data> {

    private Data message;

    private LinkedList<Data> list = new LinkedList<Data>();

    @Override
    public synchronized Data pop() {

        while (list.size()<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        notifyAll();
        message = list.getFirst();
        list.removeFirst();
        return message;
    }

    @Override
    public synchronized void push(Data data) {

        while (list.size() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        list.addLast(data);
        notifyAll();
        System.out.println("create " + data.getName() + " size - " + list.size());
    }
}
