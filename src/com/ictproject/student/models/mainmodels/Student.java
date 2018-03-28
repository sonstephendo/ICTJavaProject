package com.ictproject.student.models.mainmodels;

import com.ictproject.student.ulti.DateUtil;
import javafx.beans.property.*;
import javafx.scene.control.SingleSelectionModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private final IntegerProperty studentID = new SimpleIntegerProperty(0);
    private final StringProperty firstName = new SimpleStringProperty("");
    private final StringProperty lastName = new SimpleStringProperty("");

    // personal info
    private final StringProperty gender = new SimpleStringProperty("");
    private final ObjectProperty<LocalDate> birthday = new SimpleObjectProperty<>(DateUtil.parse("00/00/0000"));
    private final StringProperty phone = new SimpleStringProperty("");
    private final StringProperty email = new SimpleStringProperty("");
    private final StringProperty address = new SimpleStringProperty("");
    private final StringProperty educationSystem = new SimpleStringProperty("");

    private ArrayList<Course> registeredCourses;

    public Student() {
    }

    public Student(int studentID, String firstName, String lastName, String gender, String birthday, String phone, String email, String address, EduSystem educationSystem) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.studentID.set(studentID);
        this.gender.set(gender);
        this.birthday.set(DateUtil.parse(birthday));
        this.phone.set(phone);
        this.email.set(email);
        this.address.set(address);
        this.educationSystem.set(educationSystem.toString());
    }

    private boolean addCourse(Course course) {
        return registeredCourses.add(course);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getStudentType() {
        return educationSystem.get();
    }

    public void setStudentType(EduSystem system) {
        this.educationSystem.set(system.toString());
    }

    public String getEducationSystem() {
        return educationSystem.get();
    }

    public void setEducationSystem(String educationSystem) {
        this.educationSystem.set(educationSystem);
    }

    public StringProperty educationSystemProperty() {
        return educationSystem;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public int getStudentID() {
        return studentID.get();
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public String toString() {
        return studentID.getValue().toString();
    }

    public enum EduSystem {
        CREDIT("Academic Credit"),
        FIXED("Fixed-Curriculum");
        private final String text;

        EduSystem(String text) {
            this.text = text;
        }


        @Override
        public String toString() {
            return text;
        }
    }
}
