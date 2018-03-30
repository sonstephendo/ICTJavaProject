package com.ictproject.student.ui.mainui.admin;

import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.Registration;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.models.mainmodels.operation.FixedClassOperations;
import com.ictproject.student.models.mainmodels.operation.MajorOperations;
import com.ictproject.student.models.mainmodels.operation.RegistrationOperations;
import com.ictproject.student.models.mainmodels.operation.StudentOperations;
import com.ictproject.student.models.mainmodels.academic_credit.CreditStudent;
import com.ictproject.student.models.mainmodels.fixed_curriculum.FixedStudent;
import com.ictproject.student.ulti.DBConnect;
import com.ictproject.student.ulti.DataHelper;
import com.ictproject.student.ulti.DateUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class StudentsController implements Initializable {

    /**
     * The data as observable list of student data from databases
     */
    private ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, Number> studentID;
    @FXML
    private TableColumn<Student, String> firstName;
    @FXML
    private TableColumn<Student, String> lastName;
    @FXML
    private TableColumn<Student, String> educationSystem;
    @FXML
    private JFXRadioButton IDFilter;
    @FXML
    private JFXRadioButton NameFilter;
    @FXML
    private JFXTextField searchField;
    @FXML
    private JFXButton searchButton;
    @FXML
    private ToggleGroup filter;
    @FXML
    private Label lbl_fullname;
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
    private Label lblMajorClass;
    @FXML
    private VBox detailsBox;
    private ResultSet rs;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private JFXButton btnModify;
    @FXML
    private JFXButton btnRefresh;

//    public static void onClose() {
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(studentDataFile);
//            XMLEncoder encoder = new XMLEncoder(out);
////            encoder.setExceptionListener(e -> System.out.println("Exception! :"+e.toString()));
//            encoder.setPersistenceDelegate(LocalDate.class, new PersistenceDelegate() {
//                @Override
//                protected Expression instantiate(Object oldInstance, Encoder out) {
//                    LocalDate localDate = (LocalDate) oldInstance;
//                    return new Expression(localDate, LocalDate.class, "parse", new Object[]{localDate.toString()});
//                }
//            });
//            encoder.writeObject(StudentOperations.getInstance().getDataList());
//            encoder.close();
//            System.out.println("Saved studentTableView list");
//        } catch (Exception e) {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e1) {
//                    AlertMaker.showWarning(e1);
//                }
//            }
//            AlertMaker.showWarning(e);
//        }
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCols();
        studentTableView.setItems(studentObservableList);
        showStudentDetail(null);
        // adding listener for some observable
        studentTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showStudentDetail(newValue));
        filter.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(IDFilter)) {
                searchField.setPromptText("Search by ID");
            } else if (newValue.equals(NameFilter)) {
                searchField.setPromptText("Search by Name");
            }
        });
    }

    private void initCols() {
        //Initialize the student table, The cell must know which part of "tableUser" it needs to display
        studentID.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty());
        firstName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        educationSystem.setCellValueFactory(cellData -> cellData.getValue().educationSystemProperty());
    }

    // TODO: 11/03/2018  saved for database import
//    private void searchHandle2(ActionEvent event) {
//        DBConnect dbConnect = new DBConnect();
//        Connection connection = dbConnect.getConnect();
//        dbConnect.setStudentsController(this);
//
//        studentTableView.getItems().clear();
//
//        if (IDFilter.isSelected()) {
//            String query = "SELECT * FROM Student WHERE NAME LIKE '%" + IDFilter.getText() + "%'";
//            try {
//                rs = connection.createStatement().executeQuery(query);
//                dbConnect.setRs(this.rs);
//                System.out.println("Records from Databases");
//                dbConnect.readData();
//
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            dbConnect.getData(Integer.parseInt(searchField.getText()));
//        } else {
//            dbConnect.getData(searchField.getText());
//        }
//
//
//    }

    @FXML
    private void searchHandle(ActionEvent event) {
        studentObservableList.clear();
        String searchText = searchField.getText();
        if (searchText.isEmpty()) {
            studentObservableList.setAll(StudentOperations.getInstance().getDataList());
        } else {
            for (Student student : StudentOperations.getInstance().getDataList()) {
                if (filter.getSelectedToggle().equals(IDFilter)) {
                    if (student.getStudentID() == Integer.parseInt(searchText)) {
                        studentObservableList.add(student);
                        break;
                    }
                } else {
                    String studentName = student.getLastName() + " " + student.getFirstName();
                    if (studentName.toLowerCase().contains(searchText.toLowerCase())) {
                        studentObservableList.add(student);
                    }
                }
            }
        }


    }

    private void showStudentDetail(Student student) {
        if (student != null) {
            lbl_fullname.setText(student.getLastName() + " " + student.getFirstName());
            lblEmail.setText(student.getEmail());
            lblPhone.setText(student.getPhone());
            lblAddress.setText(student.getAddress());
            lblGender.setText(student.getGender());
            lblBirdthday.setText(DateUtil.format(student.getBirthday()));
            if (student instanceof CreditStudent) {
                int num = ((CreditStudent) student).getTotalCredits();
                String totalCredit = Integer.toString(num);
                lblAddition.setText("Credit Taken: " + totalCredit);

                lblMajorClass.setText("Major: "+ ((CreditStudent) student).getMajor().getTitleMajor());
            } else if (student instanceof FixedStudent) {
                String years = ((FixedStudent) student).getYearOfStudy();
                lblAddition.setText("Year: " + years);

                lblMajorClass.setText("Class: "+ ((FixedStudent) student).getFixedClass().getClassName());
            }
        } else {
            lbl_fullname.setText("");
            lblEmail.setText("");
            lblPhone.setText("");
            lblAddress.setText("");
            lblGender.setText("");
            lblBirdthday.setText("");
            lblAddition.setText("");
            lblMajorClass.setText("");

        }
    }

    @FXML
    void addStudent(ActionEvent event) {
        loadWindow(ViewConstants.ADD_STUDENT_VIEW, "Add Student");
    }

    @FXML
    void modifyStudent(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {
        studentTableView.getItems().clear();
        studentObservableList.setAll(StudentOperations.getInstance().getDataList());
    }

    @FXML
    void removeStudent(ActionEvent event) {
        Student removeStudent = studentTableView.getSelectionModel().getSelectedItem();
        if (removeStudent != null) {
            StudentOperations.getInstance().deleteData(removeStudent);
            AlertMaker.showNotification("Successful", "Student Deleted", AlertMaker.image_movie_frame);
        } else {
            AlertMaker.showNotification("Error", "No  Student Selected", AlertMaker.image_cross);
        }
    }

    private void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.initOwner(btnAdd.getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException ex) {
            AlertMaker.showErrorMessage(ex);
        }
    }
}
