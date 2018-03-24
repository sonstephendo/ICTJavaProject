package com.ictproject.student.models.mainmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Course {
    // TODO: 17/03/2018  add some class like (Faculty = Khoa , Teacher(personalInfo => can separate
    // TODO: 17/03/2018  extend course to credit course(IntegerProperty credit

    private final IntegerProperty courseID;
    private final StringProperty courseName;
    private final StringProperty courseCode;
    private IntegerProperty availableSeats;
    private IntegerProperty seatsTaken;
    private ObservableList<Student> registeredStudents = FXCollections.observableArrayList();

    public Course(int courseID, String courseName, String courseCode) {
        this.courseID = new SimpleIntegerProperty(courseID);
        this.courseName = new SimpleStringProperty(courseName);
        this.courseCode = new SimpleStringProperty(courseCode);
    }

    public int getCourseID() {
        return courseID.get();
    }

    public IntegerProperty courseIDProperty() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID.set(courseID);
    }

    public String getCourseName() {
        return courseName.get();
    }

    public StringProperty courseNameProperty() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public StringProperty courseCodeProperty() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode.set(courseCode);
    }

    public int getAvailableSeats() {
        return availableSeats.get();
    }

    public IntegerProperty availableSeatsProperty() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats.set(availableSeats);
    }

    public int getSeatsTaken() {
        return seatsTaken.get();
    }

    public IntegerProperty seatsTakenProperty() {
        return seatsTaken;
    }

    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken.set(seatsTaken);
    }

    public ObservableList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(ObservableList<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
}
