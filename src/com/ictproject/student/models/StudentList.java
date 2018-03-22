package com.ictproject.student.models;

import java.util.ArrayList;

public class StudentList {

    /**
     * Student data List, contain all the Student of the school
     */
    private static final ArrayList<Student> studentData = new ArrayList<>();

    public StudentList() {
    }

    public ArrayList<Student> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Student> initStudentData) {
        studentData.clear();
        studentData.addAll(initStudentData);
    }

    public void addStudent(Student newStudent) {
        studentData.add(newStudent);
    }

    public void deleteStudent(Student removeStudent) {
        studentData.remove(removeStudent);
    }

    public void deleteStudent(Integer studentID) {
        for (Student student : studentData) {
            int id = student.getStudentID();
            if (id == studentID) {
                studentData.remove(student);
                break;
            }
        }
    }
    // TODO: 22/03/2018  // add more method for that class


}
