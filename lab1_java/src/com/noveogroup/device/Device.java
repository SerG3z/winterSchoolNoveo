package com.noveogroup.device;

/**
 * This interface represents a Device for sorting algorithms.
 */
public interface Device extends Comparable<Device> {

    int getPrice();

    void setPrice(int price);

    String getName();

    void setName(String name);

    void showDevice();
}
