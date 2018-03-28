package com.ictproject.student.models.mainmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Student belong to Fixed Curriculum System
 */
public class FixedStudent extends Student {
    private final StringProperty yearOfStudy = new SimpleStringProperty(StudyYear.FRESHMAN.toString());

    public FixedStudent() {
    }

    public FixedStudent(int studentID, String firstName, String lastName, String gender, String birthday, String phone, String email, String address, StudyYear yearOfStudy) {
        super(studentID, firstName, lastName, gender, birthday, phone, email, address, EduSystem.FIXED);
        this.yearOfStudy.set(yearOfStudy.toString());
    }

    public String getYear() {
        return yearOfStudy.get();
    }

    public void setYear(StudyYear year) {
        this.yearOfStudy.set(year.toString());
    }

    public StringProperty yearProperty() {
        return yearOfStudy;
    }

    public enum StudyYear {
        FRESHMAN("Freshman"),
        SOPHOMORE("Sophomore"),
        JUNIOR("Junior"),
        SENIOR("Senior");

        private final String text;

        StudyYear(String text) {
            this.text = text;
        }


        @Override
        public String toString() {
            return text;
        }
    }

}
