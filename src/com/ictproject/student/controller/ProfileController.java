package com.ictproject.student.controller;

import com.ictproject.student.models.Student;
import com.ictproject.student.models.StudentCredit;
import com.ictproject.student.models.StudentYearly;
import com.ictproject.student.ulti.App;
import com.ictproject.student.ulti.DBConnect;
import com.ictproject.student.ulti.DateUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private TableView<Student> students;
    @FXML
    private TableColumn<Student, Number> studentID;
    @FXML
    private TableColumn<Student, String> firstName;
    @FXML
    private TableColumn<Student, String> lastName;
    @FXML
    private TableColumn<Student, String> studentType;
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
    private VBox detailsBox;
    private ResultSet rs;
    /**
     * The data as observable list of student data from databases
     */
    private ArrayList<Student> studentData = new ArrayList<>();
    private ObservableList<Student> searchResult = FXCollections.observableArrayList();

    public ProfileController() {
    }

    public ArrayList<Student> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Student> initStudentData) {
        studentData.clear();
        studentData.addAll(initStudentData);
    }

    /**
     * @return Main observable list of Student Data
     */


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize the student table, The cell must know which part of "tableUser" it needs to display
        studentID.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty());
        firstName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        studentType.setCellValueFactory(cellData -> cellData.getValue().studentTypeProperty());
        showStudentDetail(null);

        students.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showStudentDetail(newValue));

//        App initData = new App();
//        initData.setController(this);
//        initData.addListStudent();

        filter.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(IDFilter)) {
                searchField.setPromptText("Search by ID");
            } else if (newValue.equals(NameFilter)) {
                searchField.setPromptText("Search by Name");
            }
        });
//        students.setItems(studentData);
        // TODO: 09/03/2018  http://code.makery.ch/blog/javafx-8-tableview-cell-renderer/ Cell Factory for custom the display(specially DateFormatter)
    }

    // TODO: 11/03/2018  fix some exception
    @FXML
    private void searchHandle2(ActionEvent event) {
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.getConnect();
        dbConnect.setProfileController(this);

        students.getItems().clear();

        if (IDFilter.isSelected()) {
            String query = "SELECT * FROM Student WHERE NAME LIKE '%" + IDFilter.getText() + "%'";
            try {
                rs = connection.createStatement().executeQuery(query);
                dbConnect.setRs(this.rs);
                System.out.println("Records from Databases");
                dbConnect.readData();

                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbConnect.getData(Integer.parseInt(searchField.getText()));
        } else {
            dbConnect.getData(searchField.getText());
        }

        students.setItems(searchResult);
    }

    @FXML
    private void searchHandle(ActionEvent event) {
        System.out.println(studentData.size());
        students.setItems(searchResult);
        searchResult.clear();
        String searchText = searchField.getText();
        if (searchText.isEmpty()) {
            searchResult.setAll(studentData);
        } else {
            for (Student student : studentData) {
                if (filter.getSelectedToggle().equals(IDFilter)) {
                    if (student.getStudentID() == Integer.parseInt(searchText)) {
                        searchResult.add(student);
                        break;
                    }
                } else {
                    String studentName = student.getLastName() + " " + student.getFirstName();
                    if (studentName.toLowerCase().contains(searchText.toLowerCase())) {
                        searchResult.add(student);
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
            if (student instanceof StudentCredit) {
                int num = ((StudentCredit) student).getTotalCredits();
                String totalCredit = Integer.toString(num);
                lblAddition.setText("Total Credit: " + totalCredit);
            } else if (student instanceof StudentYearly) {
                String years = ((StudentYearly) student).getYear();
                lblAddition.setText("Year: " + years);
            }
        } else {
            lbl_fullname.setText("");
            lblEmail.setText("");
            lblPhone.setText("");
            lblAddress.setText("");
            lblGender.setText("");
            lblBirdthday.setText("");
            lblAddition.setText("");

        }
    }
}
