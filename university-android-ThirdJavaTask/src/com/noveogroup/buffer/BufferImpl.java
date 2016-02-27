package com.noveogroup.buffer;

import java.util.LinkedList;

/**
 * Created by serg3z on 24.02.16.
 */
public class BufferImpl implements Buffer {

    private String message;
    private static int i = 0;

    private LinkedList<String> list = new LinkedList<String>();

    @Override
    public synchronized String pop() {

        while (list.size()<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();
        message = list.getFirst();
        list.removeFirst();
        return message;
    }

    @Override
    public synchronized void push() {

        while (list.size() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.message = "new record - " + i;
        i++;
        list.addLast(message);
        notifyAll();
        System.out.println("create " + this.message + " size - " + list.size());
    }
}
