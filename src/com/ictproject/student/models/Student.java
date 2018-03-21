package com.ictproject.student.models;

import com.ictproject.student.ulti.DateUtil;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private final IntegerProperty studentID = new SimpleIntegerProperty(0);
    private final StringProperty firstName = new SimpleStringProperty("");
    private final StringProperty lastName = new SimpleStringProperty("");

    // personal info
    private StringProperty gender = new SimpleStringProperty("");
    private final ObjectProperty<LocalDate> birthday = new SimpleObjectProperty<>(DateUtil.parse("00/00/0000"));
    private final StringProperty phone = new SimpleStringProperty("");
    private final StringProperty email = new SimpleStringProperty("");
    private final StringProperty address = new SimpleStringProperty("");
    private final StringProperty studentType = new SimpleStringProperty("");

    private ArrayList<Course> registeredCourses;

    public Student() {
    }

    public Student(String firstName, String lastName, int studentID, String gender, String birthday, String phone, String email, String address, String studentType) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.studentID.set(studentID);
        this.gender.set(gender);
        this.birthday.set(DateUtil.parse(birthday));
        this.phone.set(phone);
        this.email.set(email);
        this.address.set(address);
        this.studentType.set(studentType);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getStudentType() {
        return studentType.get();
    }

    public StringProperty studentTypeProperty() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType.set(studentType);
    }



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
