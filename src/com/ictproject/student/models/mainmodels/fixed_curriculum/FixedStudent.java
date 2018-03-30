package com.ictproject.student.models.mainmodels.fixed_curriculum;

import com.ictproject.student.models.mainmodels.Student;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Student belong to Fixed Curriculum System
 */
public class FixedStudent extends Student {
    private final StringProperty yearOfStudy = new SimpleStringProperty(StudyYear.FIRST_YEAR.toString());
    private ObjectProperty<FixedClass> fixedClass = new SimpleObjectProperty<>();

    public FixedStudent() {
    }

    public FixedStudent(int studentID, String firstName, String lastName, String gender, String birthday, String phone, String email, String address) {
        super(studentID, firstName, lastName, gender, birthday, phone, email, address, EduSystem.FIXED);
    }

    public FixedStudent(int studentID, String firstName, String lastName, String gender, String birthday, String phone, String email, String address, StudyYear yearOfStudy) {
        super(studentID, firstName, lastName, gender, birthday, phone, email, address, EduSystem.FIXED);
        this.yearOfStudy.set(yearOfStudy.toString());
    }

    public String getYearOfStudy() {
        return yearOfStudy.get();
    }

    public StringProperty yearOfStudyProperty() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy.set(yearOfStudy);
    }

    public FixedClass getFixedClass() {
        return fixedClass.get();
    }

    public ObjectProperty<FixedClass> fixedClassProperty() {
        return fixedClass;
    }

    public void setFixedClass(FixedClass fixedClass) {
        this.fixedClass.set(fixedClass);
    }

    public enum StudyYear {
        FIRST_YEAR("First Year"),
        SECOND_YEAR("Second Year"),
        THIRD_YEAR("Third Year"),
        FOURTH_YEAR("Fourth Year");

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
