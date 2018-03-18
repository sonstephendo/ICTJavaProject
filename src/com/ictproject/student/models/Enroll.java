package com.ictproject.student.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class Enroll {
    private final IntegerProperty enrollID;
    private ObjectProperty<Student> studentEnroll;
    private ObjectProperty<Course> courseEnroll;
    private DoubleProperty midtermGrade;
    private DoubleProperty finalGrade;
    private DoubleProperty score;

    public Enroll(IntegerProperty enrollID) {
        this.enrollID = enrollID;
    }

    public int getEnrollID() {
        return enrollID.get();
    }

    public IntegerProperty enrollIDProperty() {
        return enrollID;
    }

    public void setEnrollID(int enrollID) {
        this.enrollID.set(enrollID);
    }

    public Student getStudentEnroll() {
        return studentEnroll.get();
    }

    public ObjectProperty<Student> studentEnrollProperty() {
        return studentEnroll;
    }

    public void setStudentEnroll(Student studentEnroll) {
        this.studentEnroll.set(studentEnroll);
    }

    public Course getCourseEnroll() {
        return courseEnroll.get();
    }

    public ObjectProperty<Course> courseEnrollProperty() {
        return courseEnroll;
    }

    public void setCourseEnroll(Course courseEnroll) {
        this.courseEnroll.set(courseEnroll);
    }

    public double getMidtermGrade() {
        return midtermGrade.get();
    }

    public DoubleProperty midtermGradeProperty() {
        return midtermGrade;
    }

    public void setMidtermGrade(double midtermGrade) {
        this.midtermGrade.set(midtermGrade);
    }

    public double getFinalGrade() {
        return finalGrade.get();
    }

    public DoubleProperty finalGradeProperty() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade.set(finalGrade);
    }

    public double getScore() {
        return score.get();
    }

    public DoubleProperty scoreProperty() {
        return score;
    }

    public void setScore(double score) {
        this.score.set(score);
    }
}
