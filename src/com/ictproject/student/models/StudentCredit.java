package com.ictproject.student.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentCredit extends Student {
    private ObjectProperty<Major> major;
    private final StringProperty totalCredits; // Total credits taken (totalCreditsTowardsDegree... bla bla

    public StudentCredit(String firstName, String lastName, int studentID, String gender, String birthday, String phone, String email, ObjectProperty<Major> major, String totalCredits) {
        super(firstName, lastName, studentID, gender, birthday, phone, email);
        this.major = major;
        this.totalCredits = new SimpleStringProperty(totalCredits);
    }

    public Major getMajor() {
        return major.get();
    }

    public ObjectProperty<Major> majorProperty() {
        return major;
    }

    public void setMajor(Major major) {
        this.major.set(major);
    }

    public String getTotalCredits() {
        return totalCredits.get();
    }

    public StringProperty totalCreditsProperty() {
        return totalCredits;
    }

    public void setTotalCredits(String totalCredits) {
        this.totalCredits.set(totalCredits);
    }
}
