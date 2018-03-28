package com.ictproject.student.ui.mainui.admin.addstudent;

import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.FixedStudent.StudyYear;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.models.mainmodels.CreditStudent;
import com.ictproject.student.models.mainmodels.FixedStudent;
import com.ictproject.student.ulti.DateUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.ictproject.student.models.mainmodels.StudentList.STUDENTLIST;

public class AddStudentController implements Initializable {
    private File file;

    @FXML
    private ImageView avatar;

    @FXML
    private JFXButton btnGetImg;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField studentID;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup genderRadio;

    @FXML
    private RadioButton female;

    @FXML
    private JFXDatePicker birthday;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField address;

    @FXML
    private ToggleGroup stypeRadio;

    @FXML
    private RadioButton credit;

    @FXML
    private RadioButton yearly;

    @FXML
    private JFXComboBox<StudyYear> fixedComboBox;

    @FXML
    private JFXTextField creditNumField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComboBox();

    }

    private void initComboBox() {
        fixedComboBox.getItems().add(StudyYear.FRESHMAN);
        fixedComboBox.getItems().add(StudyYear.SOPHOMORE);
        fixedComboBox.getItems().add(StudyYear.JUNIOR);
        fixedComboBox.getItems().add(StudyYear.SENIOR);
        stypeRadio.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(yearly)) {
                creditNumField.setVisible(false);
                fixedComboBox.setVisible(true);
            }
            if (newValue.equals(credit)) {
                creditNumField.setVisible(true);
                fixedComboBox.setVisible(false);
            }
        });

    }

    // TODO: 24/03/2018 need add validation (NumberFormatException for id) + new button for clearform

    @FXML
    void submitDetails() {
        String studentIDString = studentID.getText();
        String firstNameString = firstName.getText();
        String lastNameString = lastName.getText();
        String genderString = "Male";
        if (female.isSelected()) genderString = "Female";
        LocalDate birthdayDate = birthday.getValue();
        String phoneString = phone.getText();
        String emailString = email.getText();
        String addressString = address.getText();
        if (credit.isSelected()) {
            Student newStudent = new CreditStudent(Integer.parseInt(studentIDString), firstNameString, lastNameString, genderString, DateUtil.format(birthdayDate), phoneString, emailString, addressString, 0);
            STUDENTLIST.addStudent(newStudent);
        } else {
            Student newStudent = new FixedStudent(Integer.parseInt(studentIDString), firstNameString, lastNameString, genderString, DateUtil.format(birthdayDate), phoneString, emailString, addressString, fixedComboBox.getValue());
            STUDENTLIST.addStudent(newStudent);
        }
        AlertMaker.showNotification("Success", "Student info inserted successfully ", AlertMaker.image_movie_frame);
    }

    @FXML
    void getAvatar(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG =
                new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg =
                new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG =
                new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        try {
            file = fileChooser.showOpenDialog(studentID.getScene().getWindow());
            Image image = new Image(file.toURI().toString());
            avatar.setImage(image);
        } catch (Exception ex) {
            AlertMaker.showErrorMessage(ex);
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
            ((Stage) btnBack.getScene().getWindow()).close();
    }
}