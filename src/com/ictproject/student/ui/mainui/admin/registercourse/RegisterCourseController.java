package com.ictproject.student.ui.mainui.admin.registercourse;

import com.ictproject.student.models.mainmodels.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;

import static com.ictproject.student.models.mainmodels.StudentList.*;
import static com.ictproject.student.ui.mainui.admin.RegisterController.registerObservableList;

public class RegisterCourseController implements Initializable {
    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField courseField;

    @FXML
    private JFXTextField studentField;

    private AutoCompletionBinding<Student> autoCompletionStudent;
    private AutoCompletionBinding<Course> autoCompletionCourse;

    @FXML
    void goBack(ActionEvent event) {
        ((Stage) btnBack.getScene().getWindow()).close();
    }

    // TODO: 28/03/2018 make this right 
    @FXML
    void submitEnroll(ActionEvent event) {
        Student student = STUDENTLIST.getStudent(studentField.getText());
        Course course = null;
        Register newRegister = null;
        String courseCode = courseField.getText();
        if (student instanceof CreditStudent) {
            course = ((CreditStudent) student).getMajor().getCourseMajorFromCode(courseCode);
        }
        if (course != null) {
            // FIXME: 28/03/2018 exception
//            student.getRegisteredCourses().add(course);
            course.getRegisteredStudents().add(student);
            newRegister = new Register(Register.numOfReg++,student,course);
            registerObservableList.add(newRegister);
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTextField();
    }

    // TODO: 28/03/2018 too good to use
    private void initTextField() {
        autoCompletionStudent = TextFields.bindAutoCompletion(
                studentField,
                STUDENTLIST.getStudentData().toArray(new Student[0]));

        studentField.textProperty().addListener((observable, oldValue, newValue) -> {
            Student student = STUDENTLIST.getStudent(newValue);
            if (student != null && student instanceof CreditStudent) {
                autoCompletionCourse = TextFields.bindAutoCompletion(
                        courseField,
                        ((CreditStudent) student).getMajor().getMajorCourse().toArray(new Course[0]));
            }
        });



        // TODO: 28/03/2018 add learning word (needed ??)
//        studentField.setOnKeyPressed(event -> {
//            switch (event.getCode()) {
//                case ENTER:
//                    autoCompletionLearnWord(studentField.getText().trim());
//                    break;
//                default:
//                    break;
//
//            }
//        });

    }



}
