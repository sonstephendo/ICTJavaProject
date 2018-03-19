package com.ictproject.student.models;

import javafx.beans.property.*;

public class StudentCredit extends Student {
    private final IntegerProperty totalCredits; // Total credits taken (totalCreditsTowardsDegree... bla bla
    private ObjectProperty<Major> major;

    public StudentCredit(String firstName, String lastName, int studentID, String gender, String birthday, String phone, String email, String address, int totalCredits) {
        super(firstName, lastName, studentID, gender, birthday, phone, email, address, "Credit");
        this.totalCredits = new SimpleIntegerProperty(totalCredits);
    }

    public Major getMajor() {
        return major.get();
    }

    public void setMajor(Major major) {
        this.major.set(major);
    }

    public ObjectProperty<Major> majorProperty() {
        return major;
    }

    public int getTotalCredits() {
        return totalCredits.get();
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits.set(totalCredits);
    }

    public IntegerProperty totalCreditsProperty() {
        return totalCredits;
    }
}
