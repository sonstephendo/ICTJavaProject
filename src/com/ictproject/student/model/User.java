package com.ictproject.student.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final IntegerProperty snum;
    private final StringProperty name;
    private final StringProperty major;
    private final StringProperty level;
    private final IntegerProperty age;

    public User(int snum, String name, String major, String level, int age) {
        this.snum = new SimpleIntegerProperty(snum);
        this.name = new SimpleStringProperty(name);
        this.major = new SimpleStringProperty(major);
        this.level = new SimpleStringProperty(level);
        this.age = new SimpleIntegerProperty(age);
    }


    public int getSnum() {
        return snum.get();
    }

    public IntegerProperty snumProperty() {
        return snum;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getMajor() {
        return major.get();
    }

    public StringProperty majorProperty() {
        return major;
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setSnum(int snum) {
        this.snum.set(snum);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public void setAge(int age) {
        this.age.set(age);
    }
}
