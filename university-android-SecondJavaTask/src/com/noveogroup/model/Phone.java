package com.noveogroup.model;

import java.io.Serializable;

/**
 * Simple implementation for demo proposes.
 * You should use your own classes.
 */
public class Phone implements TreeElement, Serializable {

    protected String name;
    protected int id;

    public Phone(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return "This phone " + name + " on unknown platform - beware)";
    }
}
