package com.ictproject.student.models.mainmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;

/**
 * Major class is class taken by each Student. Student need to do specific required for degree
 */
public class Major {
    private final StringProperty titleMajor = new SimpleStringProperty();
    private final IntegerProperty totalCredits = new SimpleIntegerProperty();
    private ArrayList<CreditCourse> majorCourse;
    private ArrayList<CreditCourse> nonMajorCourse; // TODO: 27/03/2018 do latter

    public Major() {
    }

    public Major(String titleMajor, int totalCredits) {
        this.titleMajor.set(titleMajor);
        this.totalCredits.set(totalCredits);
        majorCourse = new ArrayList<>();
        nonMajorCourse = new ArrayList<>();
    }

    public boolean addMajorCourse(CreditCourse course) {
        return majorCourse.add(course);
    }

    public boolean addnonMajorCourse(CreditCourse course) {
        return nonMajorCourse.add(course);
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

    public ArrayList<CreditCourse> getMajorCourse() {
        return majorCourse;
    }

    public void setMajorCourse(ArrayList<CreditCourse> majorCourse) {
        this.majorCourse = majorCourse;
    }

    public ArrayList<CreditCourse> getNonMajorCourse() {
        return nonMajorCourse;
    }

    public void setNonMajorCourse(ArrayList<CreditCourse> nonMajorCourse) {
        this.nonMajorCourse = nonMajorCourse;
    }

    public Course getCourseMajorFromCode(String Code) {
        for (CreditCourse creditCourse : majorCourse) {
            if (creditCourse.getCourseCode().equals(Code)) {
                return creditCourse;
            }
        }
        return null;
    }
}
