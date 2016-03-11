package com.noveogroup.task2;

/**
 * Created by serg on 10.03.16.
 */
public class Employee {

    private String name;
    private String surname;
    private String skills;

    public Employee(String name, String surname, String skills) {
        this.name = name;
        this.surname = surname;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
