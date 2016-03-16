package com.noveogroup.task2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by serg on 10.03.16.
 */
public class Employee implements Parcelable {

    private String name;
    private String surname;
    private String skills;

    public Employee(String name, String surname, String skills) {
        this.name = name;
        this.surname = surname;
        this.skills = skills;
    }

    public Employee(Parcel source) {
        String[] data = new String[3];
        source.readStringArray(data);
        name = data[0];
        surname = data[1];
        skills = data[2];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] { name, surname, skills });
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {

        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}
