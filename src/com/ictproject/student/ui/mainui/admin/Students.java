package com.ictproject.student.ui.mainui.admin;

import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.Student;
import com.ictproject.student.models.mainmodels.StudentCredit;
import com.ictproject.student.models.mainmodels.StudentList;
import com.ictproject.student.models.mainmodels.StudentYearly;
import com.ictproject.student.ulti.DBConnect;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Students implements Initializable {
    private static final String studentDataFile = "src/students.xml";
    /**
     * Student List data of program
     */
    private static StudentList studentList = new StudentList();
    /**
     * The data as observable list of student data from databases
     */
    private ObservableList<Student> searchResult = FXCollections.observableArrayList();
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
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private JFXButton btnModify;
    @FXML
    private JFXButton btnRefresh;

    public static StudentList getStudentList() {
        return studentList;
    }

    public static void onClose() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(studentDataFile);
            XMLEncoder encoder = new XMLEncoder(out);
//            encoder.setExceptionListener(e -> System.out.println("Exception! :"+e.toString()));
            encoder.setPersistenceDelegate(LocalDate.class, new PersistenceDelegate() {
                @Override
                protected Expression instantiate(Object oldInstance, Encoder out) {
                    LocalDate localDate = (LocalDate) oldInstance;
                    return new Expression(localDate, LocalDate.class, "parse", new Object[]{localDate.toString()});
                }
            });
            encoder.writeObject(studentList.getStudentData());
            encoder.close();
            System.out.println("Saved students list");
        } catch (Exception e) {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    AlertMaker.showWarning(e1);
                }
            }
            AlertMaker.showWarning(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCols();
        showStudentDetail(null);
        // adding listener for some observable
        students.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showStudentDetail(newValue));
        filter.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(IDFilter)) {
                searchField.setPromptText("Search by ID");
            } else if (newValue.equals(NameFilter)) {
                searchField.setPromptText("Search by Name");
            }
        });
        // loading data
        studentList.setStudentData(readStudentData());
    }

    private void initCols() {
        //Initialize the student table, The cell must know which part of "tableUser" it needs to display
        studentID.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty());
        firstName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        studentType.setCellValueFactory(cellData -> cellData.getValue().studentTypeProperty());
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
            AlertMaker.showWarning(e);
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e1) {
                AlertMaker.showWarning(e1);
            }
        } finally {
            return arrayList;
        }
    }

    // TODO: 11/03/2018  saved for database import
    @FXML
    private void searchHandle2(ActionEvent event) {
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.getConnect();
        dbConnect.setStudents(this);

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
        students.setItems(searchResult);
        searchResult.clear();
        String searchText = searchField.getText();
        if (searchText.isEmpty()) {
            searchResult.setAll(studentList.getStudentData());
        } else {
            for (Student student : studentList.getStudentData()) {
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

    @FXML
    void addStudent(ActionEvent event) {
        loadWindow(ViewConstants.ADD_STUDENT_VIEW, "Add Student");
    }

    @FXML
    void modifyStudent(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {
        students.getItems().clear();
        searchResult.setAll(studentList.getStudentData());
    }

    @FXML
    void removeStudent(ActionEvent event) {
        Student removeStudent = students.getSelectionModel().getSelectedItem();
        if (removeStudent != null) {
            // TODO: 24/03/2018 check valid (sinh viên có tham gia khóa học nào không) maybe
            studentList.deleteStudent(removeStudent);
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
