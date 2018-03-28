package com.ictproject.student.ui.mainui.admin;

import com.ictproject.student.models.mainmodels.Course;
import com.ictproject.student.models.mainmodels.CreditCourse;
import com.ictproject.student.models.mainmodels.Major;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.ulti.App;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.ictproject.student.ulti.App.csMajor;

public class CoursesController implements Initializable{

    private ObservableList<Course> testListCourse = FXCollections.observableArrayList();

    @FXML
    private JFXRadioButton IDFilter;

    @FXML
    private ToggleGroup filter;

    @FXML
    private JFXRadioButton NameFilter;

    @FXML
    private JFXTextField searchField;

    @FXML
    private JFXButton searchButton;

    @FXML
    private TableView<Course> courseTableView;

    @FXML
    private TableColumn<Course, Number> courseID;

    @FXML
    private TableColumn<Course, String> courseName;

    @FXML
    private TableColumn<Course, String> courseCode;

    @FXML
    private Label lbl_fullname;

    @FXML
    private VBox detailsBox;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblBirdthday;

    @FXML
    private Label lblAddition;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnModify;

    @FXML
    private JFXButton btnRefresh;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCols();

        testingRegister();

        courseTableView.setItems(testListCourse);
    }

    private void testingRegister() {

    }

    private void initCols() {
        courseID.setCellValueFactory(param -> param.getValue().courseIDProperty());
        courseName.setCellValueFactory(param -> param.getValue().courseNameProperty());
        courseCode.setCellValueFactory(param -> param.getValue().courseCodeProperty());
    }

    @FXML
    void addCourse(ActionEvent event) {

    }

    @FXML
    void modifyCourse(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {

    }

    @FXML
    void removeCourse(ActionEvent event) {

    }

    @FXML
    void searchHandle(ActionEvent event) {
        courseTableView.getItems().clear();
        testListCourse.addAll(csMajor.getMajorCourse());
    }
}
