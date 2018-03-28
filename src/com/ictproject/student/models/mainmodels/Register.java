package com.ictproject.student.models.mainmodels;

import javafx.beans.property.*;

public class Register {
    private final IntegerProperty registerID = new SimpleIntegerProperty();
    private final ObjectProperty<Student> studentEnroll = new SimpleObjectProperty<>();
    private final ObjectProperty<Course> courseEnroll = new SimpleObjectProperty<>();
    private DoubleProperty midtermGrade;
    private DoubleProperty finalGrade;
    private DoubleProperty score;
    public static int numOfReg = 0;

    public Register(int registerID, Student studentEnroll, Course courseEnroll) {
        this.registerID.set(registerID);
        this.studentEnroll.set(studentEnroll);
        this.courseEnroll.set(courseEnroll);
    }


    public int getRegisterID() {
        return registerID.get();
    }

    public IntegerProperty registerIDProperty() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID.set(registerID);
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
