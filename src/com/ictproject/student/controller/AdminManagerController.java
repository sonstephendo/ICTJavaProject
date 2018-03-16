package com.ictproject.student.controller;

import com.ictproject.student.MainApp;
import com.ictproject.student.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

// TODO: 11/03/2018 need fix
public class AdminManagerController {

    @FXML
    private TableView<User> tableUser;
    @FXML
    private TableColumn<User, Number> columnSnum;
    @FXML
    private TableColumn<User, String> columnName;
    @FXML
    private TableColumn<User, String> columnMajor;
    @FXML
    private TableColumn<User, String> columnLevel;
    @FXML
    private TableColumn<User, Number> columnAge;
    @FXML
    private Button buttonLoad;

    private MainApp mainApp;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        //Initialize the student table, The cell must know which part of "tableUser" it needs to display
        columnSnum.setCellValueFactory(cellData -> cellData.getValue().snumProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnMajor.setCellValueFactory(cellData -> cellData.getValue().majorProperty());
        columnLevel.setCellValueFactory(cellData -> cellData.getValue().levelProperty());
        columnAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        // TODO: 09/03/2018  http://code.makery.ch/blog/javafx-8-tableview-cell-renderer/ Cell Factory for custom the display(specially DateFormatter)
    }

    @FXML
    private void loadDataHandle(ActionEvent event) {
//        tableUser.setItems(mainApp.getStudentData());
    }

}
