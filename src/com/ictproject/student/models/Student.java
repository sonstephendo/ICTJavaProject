package com.ictproject.student.models;

import com.ictproject.student.ulti.DateUtil;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty studentID;
    // personal info
    private final StringProperty gender;
    private final ObjectProperty<LocalDate> birthday;
    private StringProperty phone;
    private StringProperty email;

    public Student(String firstName, String lastName, int studentID, String gender, String birthday, String phone, String email) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.studentID = new SimpleIntegerProperty(studentID);
        this.gender = new SimpleStringProperty(gender);
        this.birthday = new SimpleObjectProperty<>(DateUtil.parse(birthday));
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
    }
    private ArrayList<Course> registeredCourses;

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getStudentID() {
        return studentID.get();
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
