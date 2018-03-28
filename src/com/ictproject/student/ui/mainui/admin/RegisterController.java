package com.ictproject.student.ui.mainui.admin;

import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.*;
import com.ictproject.student.ulti.App;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.table.TableFilter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.ictproject.student.models.mainmodels.StudentList.STUDENTLIST;
import static com.ictproject.student.ulti.App.*;

public class RegisterController implements Initializable {
    public static ObservableList<Register> registerObservableList = FXCollections.observableArrayList();

    @FXML
    private JFXTextField studentIdField;

    @FXML
    private JFXTextField courseIdField;

    @FXML
    private JFXButton filterButton;

    @FXML
    private TableView<Register> registerTableView;

    @FXML
    private TableColumn<Register, Number> registerID;

    @FXML
    private TableColumn<Register, Number> studentID;

    @FXML
    private TableColumn<Register, Number> courseID;

    @FXML
    private TableColumn<Register, Number> midtermScore;

    @FXML
    private TableColumn<Register, Number> finalScore;

    @FXML
    private TableColumn<Register, Number> totalScore;

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
        loadWindow(ViewConstants.ADD_REGISTER_VIEW, "Add Register");
    }

    @FXML
    void markGrade(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {

    }

    @FXML
    void removeRegister(ActionEvent event) {

    }

    @FXML
    void handleFilter(ActionEvent event) {

    }


    // TODO: 27/03/2018 add majorList Class
    SortedList<Register> registers = new SortedList<>(registerObservableList);
    Register newRegister, newRegister1, newRegister2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCols();
        testingEnroll();
        registerTableView.setItems(registers);
        registers.comparatorProperty().bind(registerTableView.comparatorProperty());
        registerTableView.setEditable(true);

        new TableFilter(registerTableView);

    }

    private void testingEnroll() {
        app.adding();
        Student newStudent = STUDENTLIST.getStudentData().get(1);
        System.out.println(newStudent.getStudentID());
        if (newStudent instanceof CreditStudent) {
            ((CreditStudent) newStudent).setMajor(csMajor);
            System.out.println(((CreditStudent) newStudent).getMajor().getTitleMajor());
        }

        Course newCourse = csMajor.getMajorCourse().get(1);
        newRegister = new Register(111, newStudent, newCourse);

        newStudent = STUDENTLIST.getStudentData().get(2);
        newCourse = csMajor.getMajorCourse().get(2);
        newRegister1 = new Register(113, newStudent, newCourse);

        newStudent = STUDENTLIST.getStudentData().get(3);
        newCourse = csMajor.getMajorCourse().get(1);
        newRegister2 = new Register(112, newStudent, newCourse);

        registerObservableList.add(newRegister);
        registerObservableList.add(newRegister1);
        registerObservableList.add(newRegister2);

    }

    private void initCols() {
        registerID.setCellValueFactory(param -> param.getValue().registerIDProperty());
        studentID.setCellValueFactory(param -> param.getValue().getStudentEnroll().studentIDProperty());
        courseID.setCellValueFactory(param -> param.getValue().getCourseEnroll().courseIDProperty());
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
