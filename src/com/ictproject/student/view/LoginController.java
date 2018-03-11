package com.ictproject.student.view;

import com.ictproject.student.MainApp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    JFXTextField userAccountField;
    @FXML
    JFXPasswordField passwordField;
    @FXML
    JFXButton signInButton;
    // TODO: 10/03/2018 add gif progress
    @FXML
    ImageView imgProgress;

    private String fakeID = "Admin";
    private String fakePass = "qweasd";
    private String fakeStudentID = "20143798";

    // Reference to the main application
    private MainApp mainApp;
    private Stage loginStage;

    /**
     * Use by MainApp to pass Stage
     *
     * @param loginStage
     */
    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    /*
        Setter for main ref, pass in MainApp.java
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Init the controller class.
     * This method is automatically called after fxml file has been loaded
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handleValidation();
        userAccountField.setText(fakeID);
        passwordField.setText(fakePass);
    }
//    @FXML
//    private void initialize() {
//
//    }

    @FXML
    private void handleButtonLogin(ActionEvent actionEvent) {
        if (userAccountField.getText().equals(fakeID)) {
            if (passwordField.getText().equals(fakePass)) {
//                mainApp.showAdminManagerRoot();
                mainApp.showDashboard();
                loginStage.close();
//                mainApp.getPrimaryStage().toBack();
            } else {

            }
        }

    }

    /**
     * Sample for input validator listener with jfoenix node
     */
    private void handleValidation() {
        RequiredFieldValidator fieldValidator = new RequiredFieldValidator();
        fieldValidator.setMessage("Input required");
        fieldValidator.setIcon(new FontAwesomeIconView(FontAwesomeIcon.TIMES));

        userAccountField.getValidators().add(fieldValidator);
        userAccountField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                userAccountField.validate();
            }
        });

        RequiredFieldValidator fieldValidator2 = new RequiredFieldValidator();
        fieldValidator2.setMessage("Input required");
        fieldValidator2.setIcon(new FontAwesomeIconView(FontAwesomeIcon.TIMES));

        passwordField.getValidators().add(fieldValidator2);
        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                passwordField.validate();
            }
        });
    }



}
