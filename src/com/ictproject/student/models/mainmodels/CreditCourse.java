package com.ictproject.student.models.mainmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class CreditCourse extends Course {
    private ArrayList<Course> prerequisiteCourses = new ArrayList<>();
    private IntegerProperty creditNum = new SimpleIntegerProperty();

    public CreditCourse() {
    }

    public CreditCourse(int courseID, String courseName, String courseCode, int creditNum) {
        super(courseID, courseName, courseCode);
        this.creditNum.set(creditNum);
    }

    public boolean addPrerequiste(Course course) {
        return prerequisiteCourses.add(course);
    }

    private boolean hasPrerequisiteCourse() {
        return prerequisiteCourses.isEmpty();
    }

    public ArrayList<Course> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(ArrayList<Course> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public int getCreditNum() {
        return creditNum.get();
    }

    public IntegerProperty creditNumProperty() {
        return creditNum;
    }

    public void setCreditNum(int creditNum) {
        this.creditNum.set(creditNum);
    }
}
