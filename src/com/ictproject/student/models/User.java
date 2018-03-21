package com.ictproject.student.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final IntegerProperty snum = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty major = new SimpleStringProperty();
    private final StringProperty level = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();

    public User() {
    }

    public User(Integer snum, String name, String major, String level, Integer age) {
        this.snum.set(snum);
        this.name.set(name);
        this.major.set(major);
        this.level.set(level);
        this.age.set(age);
    }

    public int getSnum() {
        return snum.get();
    }

    public IntegerProperty snumProperty() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum.set(snum);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMajor() {
        return major.get();
    }

    public StringProperty majorProperty() {
        return major;
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }
}
