package com.ictproject.student.controller;

import com.ictproject.student.MainApp;
import com.ictproject.student.models.Student;
import com.ictproject.student.models.StudentCredit;
import com.ictproject.student.models.StudentYearly;
import com.ictproject.student.ulti.App;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane sideAnchor;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnView;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnExit;
    @FXML
    private StackPane holderPane;
    private MainApp mainApp;
    private Parent home, add, list;

    private ProfileController profileController;
    private final String studentDataFile = "src/com/ictproject/student/ulti/students.xml";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        openMenus();
        createPages();
        profileController.setStudentData(readStudentData());
//        profileController.getStudentData().add(App.student1);
//        profileController.getStudentData().add(App.student2);
//        profileController.getStudentData().add(App.student3);
//        profileController.getStudentData().add(App.student4);
    }

    private ArrayList<Student> readStudentData() {
        FileInputStream in = null;
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            in = new FileInputStream(studentDataFile);
            XMLDecoder decoder = new XMLDecoder(in);
            arrayList = (ArrayList<Student>) decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            return arrayList;
        }
    }


//    private void openMenus() {
//        JFXPopup popup = new JFXPopup(overflowContainer);
//        lblMenu.setOnMouseClicked(event -> {popup.show(lblMenu, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, -10, 50);});
//    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    private void setNode(Node node) {
        holderPane.getChildren().clear();
        if (node != null) {
            holderPane.getChildren().add(node);
        }

//        FadeTransition ft = new FadeTransition(Duration.millis(1500));
//        ft.setNode(node);
//        ft.setFromValue(0.1);
//        ft.setToValue(1);
//        ft.setCycleCount(1);
//        ft.setAutoReverse(false);
//        ft.play();
    }

    private void createPages() {
        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.OVER_VIEW_VIEW));
//            home = loader.load();
//
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.PROFILE_VIEW));
            list = loader1.load();
            profileController = loader1.getController();
//
//            FXMLLoader loader2 = new FXMLLoader();
//            loader2.setLocation(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.REGISTER_VIEW));
//            add = loader2.load();

            add = FXMLLoader.load(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.REGISTER_VIEW));
            home = FXMLLoader.load(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.OVER_VIEW_VIEW));
//            list = FXMLLoader.load(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.PROFILE_VIEW));

            //set up default node on page load
            setNode(home);
        } catch (IOException e) {
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }

    }

    public void logOff(ActionEvent event) {
    }

    @FXML
    private void openHome(ActionEvent event) {
        setNode(home);
    }

    @FXML
    private void openAddStudent(ActionEvent event) {
        setNode(add);
    }

    @FXML
    private void openListStudent(ActionEvent event) {
        setNode(list);
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    ArrayList<StudentCredit> studentCreditArrayList = new ArrayList<>();
    ArrayList<StudentYearly> studentYearlyArrayList = new ArrayList<>();
    public void onClose(WindowEvent event) {
//        new Alert(Alert.AlertType.INFORMATION, event.getEventType().getName()).showAndWait();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(studentDataFile);
            XMLEncoder encoder = new XMLEncoder(out);
//            encoder.setExceptionListener(e -> System.out.println("Exception! :"+e.toString()));

            for (Student student : profileController.getStudentData()) {
                if (student instanceof StudentYearly) {
                    studentYearlyArrayList.add((StudentYearly) student);
                } else if (student instanceof StudentCredit) {
                    studentCreditArrayList.add((StudentCredit) student);
                }
            }
            encoder.setPersistenceDelegate(LocalDate.class, new PersistenceDelegate() {
                @Override
                protected Expression instantiate(Object oldInstance, Encoder out) {
                    LocalDate localDate = (LocalDate) oldInstance;
                    return new Expression(localDate, LocalDate.class, "parse", new Object[]{localDate.toString()});
                }
            });
            encoder.writeObject(profileController.getStudentData());
            encoder.close();
        } catch (Exception e) {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

}
