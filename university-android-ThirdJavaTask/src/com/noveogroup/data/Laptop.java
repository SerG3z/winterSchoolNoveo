package com.noveogroup.data;

/**
 * Created by serg on 03.03.16.
 */
public class Laptop implements Data {

    private String name;

    public Laptop(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
