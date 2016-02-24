package com.noveogroup.model;

/**
 * Created by serg on 24.02.16.
 */
public class AndroidPlatform extends Phone {

    public AndroidPlatform(String name, int id) {
        super(name, id);
    }

    @Override
    public String getName() {
        return "This phone " + name + " on platform android - it's cool";
    }
}
