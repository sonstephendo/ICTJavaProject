package com.ictproject.student.models.mainmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * Major class is class taken by each Student. Student need to do specific required for degree
 */
public class Major {
    private final StringProperty titleMajor;
    private IntegerProperty totalCredits;
    private ObservableList<Course> majorCourse;
    private ObservableList<Course> nonMajorCourse;

    public Major(StringProperty titleMajor) {
        this.titleMajor = titleMajor;
    }

    public String getTitleMajor() {
        return titleMajor.get();
    }

    public StringProperty titleMajorProperty() {
        return titleMajor;
    }

    public void setTitleMajor(String titleMajor) {
        this.titleMajor.set(titleMajor);
    }

    public int getTotalCredits() {
        return totalCredits.get();
    }

    public IntegerProperty totalCreditsProperty() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits.set(totalCredits);
    }

    public ObservableList<Course> getMajorCourse() {
        return majorCourse;
    }

    public void setMajorCourse(ObservableList<Course> majorCourse) {
        this.majorCourse = majorCourse;
    }

    public ObservableList<Course> getNonMajorCourse() {
        return nonMajorCourse;
    }

    public void setNonMajorCourse(ObservableList<Course> nonMajorCourse) {
        this.nonMajorCourse = nonMajorCourse;
    }
}
