package com.ictproject.student.models.mainmodels.operation;

import com.ictproject.student.models.mainmodels.Registration;

public class RegistrationOperations extends Operations<Registration> {

    private static RegistrationOperations instance = new RegistrationOperations();

    public RegistrationOperations() {
    }

    public static RegistrationOperations getInstance() {
        return instance;
    }

    @Override
    public String converter(Registration element) {
        String studentID = Integer.toString(element.getStudentEnroll().getStudentID());
        String courseCode = element.getCourseEnroll().getCourseCode();
        return studentID+courseCode;
    }
}
