package com.ictproject.student.models.mainmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Course class for Yearly Student
 */
public class Course {
    private final StringProperty courseCode = new SimpleStringProperty();
    private final StringProperty courseName = new SimpleStringProperty();

    // TODO: 31/03/2018 chỉnh lại cái seat lúc cần
    private int availableSeats;
    private int seatsTaken;

    public Course() {
    }

    public Course(String courseCode, String courseName) {
        this.courseName.set(courseName);
        this.courseCode.set(courseCode);
    }

    public String getCourseName() {
        return courseName.get();
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public StringProperty courseNameProperty() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public void setCourseCode(String courseCode) {
        this.courseCode.set(courseCode);
    }

    public StringProperty courseCodeProperty() {
        return courseCode;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getSeatsTaken() {
        return seatsTaken;
    }

    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken = seatsTaken;
    }

    @Override
    public String toString() {
        return this.getCourseCode();
    }
}
