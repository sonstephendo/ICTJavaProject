package com.ictproject.student.ui.mainui.admin;

import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.Registration;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.models.mainmodels.operation.RegistrationOperations;
import com.ictproject.student.models.mainmodels.operation.StudentOperations;
import com.ictproject.student.ulti.DataHelper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.table.TableFilter;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class RegisterController implements Initializable {

    private ObservableList<Registration> registrationObservableList = FXCollections.observableArrayList();

    @FXML
    private JFXTextField studentIdField;

    @FXML
    private JFXTextField courseIdField;

    @FXML
    private JFXButton filterButton;

    @FXML
    private TableView<Registration> registerTableView;

    @FXML
    private TableColumn<Registration, Number> registerID;

    @FXML
    private TableColumn<Registration, Number> studentID;

    @FXML
    private TableColumn<Registration, String> courseCode;

    @FXML
    private TableColumn<Registration, Number> midtermScore;

    @FXML
    private TableColumn<Registration, Number> finalScore;

    @FXML
    private TableColumn<Registration, Number> totalScore;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnMark;

    @FXML
    private JFXButton btnRefresh;

    @FXML
    void addRegister(ActionEvent event) {
        loadWindow(ViewConstants.ADD_REGISTER_VIEW, "Add Registration");
    }

    @FXML
    void markGrade(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {
        registrationObservableList.setAll(RegistrationOperations.getInstance().getDataList());
    }

    @FXML
    void removeRegister(ActionEvent event) {

    }

    @FXML
    void handleFilter(ActionEvent event) {

    }

    SortedList<Registration> registrations = new SortedList<>(registrationObservableList);
//    Registration newRegistration, newRegistration1, newRegistration2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCols();

        registrationObservableList.setAll(RegistrationOperations.getInstance().getDataList());
        testingEnroll();
        registerTableView.setItems(registrations);
        registrations.comparatorProperty().bind(registerTableView.comparatorProperty());
        registerTableView.setEditable(true);

        new TableFilter(registerTableView);

    }

    private void testingEnroll() {

//        app.adding();
//        Student newStudent = StudentOperations.getInstance().getDataList().get(1);
//        System.out.println(newStudent.getStudentID());
//        if (newStudent instanceof CreditStudent) {
//            ((CreditStudent) newStudent).setMajor(csMajor);
//            System.out.println(((CreditStudent) newStudent).getMajor().getTitleMajor());
//        }
//
//        Course newCourse = csMajor.getMajorCatalog().getCoursesData().get(1);
//        newRegistration = new Registration(111, newStudent, newCourse);
//
//        newStudent = StudentOperations.getInstance().getDataList().get(2);
//        newCourse = csMajor.getMajorCatalog().getCoursesData().get(2);
//        newRegistration1 = new Registration(113, newStudent, newCourse);
//
//        newStudent = StudentOperations.getInstance().getDataList().get(3);
//        newCourse = csMajor.getMajorCatalog().getCoursesData().get(1);
//        newRegistration2 = new Registration(112, newStudent, newCourse);
//
//        registrationObservableList.add(newRegistration);
//        registrationObservableList.add(newRegistration1);
//        registrationObservableList.add(newRegistration2);

    }

    private void initCols() {
        registerID.setCellValueFactory(param -> param.getValue().registerIDProperty());
        studentID.setCellValueFactory(param -> param.getValue().getStudentEnroll().studentIDProperty());
        courseCode.setCellValueFactory(param -> param.getValue().getCourseEnroll().courseCodeProperty());
        midtermScore.setCellValueFactory(param -> param.getValue().midtermGradeProperty());
        finalScore.setCellValueFactory(param -> param.getValue().finalGradeProperty());
        totalScore.setCellValueFactory(param -> param.getValue().scoreProperty());
    }

    private void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.initOwner(btnRegister.getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException ex) {
            AlertMaker.showErrorMessage(ex);
        }
    }
}
