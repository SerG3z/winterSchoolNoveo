package com.noveogroup.model;

/**
 * Created by serg on 24.02.16.
 */
public class IosPlatform extends Phone {

    public IosPlatform(String name, int id) {
        super(name, id);
    }

    @Override
    public String getName() {
        return "This phone " + name + " on platform ios - it's dull";
    }
}
