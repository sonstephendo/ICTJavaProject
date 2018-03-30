package com.ictproject.student.models.mainmodels.academic_credit;

import com.ictproject.student.models.mainmodels.Student;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Student belong to  ACADEMIC CREDIT SYSTEM
 */
public class CreditStudent extends Student {
    private final IntegerProperty takenCredits = new SimpleIntegerProperty(); // Total credits taken (totalCreditsTowardsDegree... bla bla
    private final ObjectProperty<Major> major = new SimpleObjectProperty<>();

    public CreditStudent() {
    }

    public CreditStudent(int studentID, String firstName, String lastName, String gender, String birthday, String phone, String email, String address, int takenCredits) {
        super(studentID, firstName, lastName, gender, birthday, phone, email, address, EduSystem.CREDIT);
        this.takenCredits.set(takenCredits);
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
        return takenCredits.get();
    }

    public void setTotalCredits(int takenCredits) {
        this.takenCredits.set(takenCredits);
    }

    public IntegerProperty totalCreditsProperty() {
        return takenCredits;
    }
}
