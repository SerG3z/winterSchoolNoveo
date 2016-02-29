package com.noveogroup.device;

/**
 * Created by serg on 12.02.16.
 */
public abstract class BaseDevice implements Device {
    protected int price;
    protected String name;

    public BaseDevice(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public void showDevice() {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public synchronized void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Device o) {
        Device tmp = o;
        if (this.price < tmp.getPrice()) {
            return -1;
        } else if (this.price > tmp.getPrice()) {
            return 1;
        }
        return 0;
    }

    @Override
    public void swap(Device b) {
        String tmpName = null;
        int tmpPrice = 0;

        tmpName = this.getName();
        this.setName(b.getName());
        this.setName(tmpName);

        tmpPrice = this.getPrice();
        this.setPrice(b.getPrice());
        b.setPrice(tmpPrice);
    }

    @Override
    public String toString() {
        return name;
    }
}
