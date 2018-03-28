package com.ictproject.student.models.mainmodels;

import com.ictproject.student.ulti.DateUtil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Course class for Yearly Student
 */
public class Course {
    // TODO: 17/03/2018  extend course to credit course(IntegerProperty credit
    // TODO: 27/03/2018 remove property of this field is no need to show inside tableView
    // TODO: 27/03/2018 seat property modify

    private final IntegerProperty courseID = new SimpleIntegerProperty();
    private final StringProperty courseName = new SimpleStringProperty();
    private final StringProperty courseCode = new SimpleStringProperty();

    private int availableSeats;
    private int seatsTaken;
    private ArrayList<Student> registeredStudents = new ArrayList<>();

    public Course() {
    }

    public Course(int courseID, String courseName, String courseCode) {
        this.courseID.set(courseID);
        this.courseName.set(courseName);
        this.courseCode.set(courseCode);
    }


    public boolean addRegister(Student student) {
        return registeredStudents.add(student);
    }


    public int getCourseID() {
        return courseID.get();
    }

    public void setCourseID(int courseID) {
        this.courseID.set(courseID);
    }

    public IntegerProperty courseIDProperty() {
        return courseID;
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

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return this.getCourseCode();
    }
}
