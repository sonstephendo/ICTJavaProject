package com.ictproject.student.ui.mainui.admin;

import com.ictproject.student.MainApp;
import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.models.mainmodels.StudentCredit;
import com.ictproject.student.models.mainmodels.StudentList;
import com.ictproject.student.models.mainmodels.StudentYearly;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnStudent;

    @FXML
    private JFXButton btnCourse;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnExit;

    @FXML
    private StackPane holderPane;
    private Parent homePane, studentPane, coursePane, registerPane, settingPane;

    private static MainApp mainApp;

    public static void setMainApp(MainApp mainApp) {
        AdminDashboardController.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        openMenus();
        try {
            homePane = FXMLLoader.load(getClass().getResource(ViewConstants.HOME_VIEW));
            studentPane = FXMLLoader.load(getClass().getResource(ViewConstants.STUDENTS_VIEW));
            coursePane = FXMLLoader.load(getClass().getResource(ViewConstants.COURSES_VIEW));
            registerPane = FXMLLoader.load(getClass().getResource(ViewConstants.REGISTER_VIEW));
            settingPane = FXMLLoader.load(getClass().getResource(ViewConstants.SETTINGS_VIEW));
        } catch (IOException e) {
            AlertMaker.showErrorMessage(e);
            e.printStackTrace();
        }
        //set up default node on page load
        setNode(homePane);
        // loading data from file

    }
//    private void openMenus() {
//        JFXPopup popup = new JFXPopup(overflowContainer);
//        lblMenu.setOnMouseClicked(event -> {popup.show(lblMenu, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, -10, 50);});
//    }
    /**
     * Set selected node to a content holder
     */
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        if (node != null) {
            holderPane.getChildren().add(node);
        }

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    void openCourse(ActionEvent event) {
        setNode(coursePane);
    }

    @FXML
    void openHome(ActionEvent event) {
        setNode(homePane);
    }

    @FXML
    void openRegister(ActionEvent event) {
        setNode(registerPane);
    }

    @FXML
    void openSetting(ActionEvent event) {
        setNode(settingPane);
    }

    @FXML
    void openStudent(ActionEvent event) {
        setNode(studentPane);
    }

    public void logOff(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) btnLogOut.getScene().getWindow();
        currentStage.close();
        Students.onClose();
        mainApp.showLoginStage();
    }

    @FXML
    private void exit(ActionEvent event) {
        Students.onClose();
        Platform.exit();
    }
}
