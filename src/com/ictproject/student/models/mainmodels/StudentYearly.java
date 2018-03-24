package com.ictproject.student.models.mainmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentYearly extends Student {
    private final StringProperty year = new SimpleStringProperty("");

    public StudentYearly() {
    }

    public StudentYearly(String firstName, String lastName, int studentID, String gender, String birthday, String phone, String email, String address, String year) {
        super(firstName, lastName, studentID, gender, birthday, phone, email, address, "Yearly");
        this.year.set(year);
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
