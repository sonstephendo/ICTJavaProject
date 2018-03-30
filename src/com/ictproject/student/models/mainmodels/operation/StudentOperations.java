package com.ictproject.student.models.mainmodels.operation;

import com.ictproject.student.models.mainmodels.Registration;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.models.mainmodels.academic_credit.CreditStudent;
import com.ictproject.student.models.mainmodels.fixed_curriculum.FixedStudent;

import java.util.Iterator;

import static com.ictproject.student.models.mainmodels.fixed_curriculum.FixedStudent.StudyYear;

public class StudentOperations extends Operations<Student> {

    private static StudentOperations instance = new StudentOperations();

    public StudentOperations() {
    }

    public static StudentOperations getInstance() {
        return instance;
    }

    public void initSomeStudent() {
        Student student1 = new FixedStudent(20143798, "Son", "Do Hong", "Male", "28/10/1996", "0966540957", "sonstephendo@gmail.com", "Ha Noi", StudyYear.FIRST_YEAR);
        Student student2 = new CreditStudent(20143799, "Emy", "Yo", "Female", "27/10/1996", "0966854737", "loveinarmy@gmail.com", "Ha Noi", 0);
        Student student3 = new CreditStudent(20455434, "Son", "Do", "Male", "23/05/1997", "09668547534", "loveinarmy@email.com", "Thai Nguyen", 0);
        Student student4 = new FixedStudent(20135678, "Sing", "Sing", "Male", "23/05/2000", "0656786545", "singsing@gmail.com", "Ho Chi Minh", StudyYear.FOURTH_YEAR);
        this.addData(student1);
        this.addData(student2);
        this.addData(student3);
        this.addData(student4);

    }

    @Override
    public void deleteData(Student removeElement) {
        Iterator<Registration> iterator = RegistrationOperations.getInstance().getDataList().iterator();
        while (iterator.hasNext()) {
            Registration registration = iterator.next();
            Student student = registration.getStudentEnroll();
            if (student.equals(removeElement)) {
                iterator.remove();
            }
        }
        // FIXME: 31/03/2018 why foreach not work while iterator work well
//        for (Registration registration : RegistrationOperations.getInstance().getDataList()) {
//            Student student = registration.getStudentEnroll();
//            if (student.equals(removeElement)) {
//                RegistrationOperations.getInstance().deleteData(registration);
//            }
//        }
        super.deleteData(removeElement);
    }

    @Override
    public String converter(Student element) {
        return Integer.toString(element.getStudentID());
    }
}
