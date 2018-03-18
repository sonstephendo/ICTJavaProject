package com.ictproject.student.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentYearly extends Student {
    private final StringProperty year;

    public StudentYearly(String firstName, String lastName, int studentID, String gender, String birthday, String phone, String email, String year) {
        super(firstName, lastName, studentID, gender, birthday, phone, email);
        this.year = new SimpleStringProperty(year);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }
}
