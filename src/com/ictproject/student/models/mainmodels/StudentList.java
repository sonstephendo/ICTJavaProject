package com.ictproject.student.models.mainmodels;

import java.util.ArrayList;

public class StudentList {

    public static StudentList STUDENTLIST = new StudentList();
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

    public Student getStudent(String studentID) {
        int id = Integer.parseInt(studentID);
        for (Student student : studentData) {
            if (student.getStudentID() == id) {
                return student;
            }
        }
        return null;
    }
    // TODO: 22/03/2018  // add more method for that class


}
