package com.ictproject.student.view.modules;

import com.ictproject.student.ulti.DBConnect;
import com.ictproject.student.model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable{
    @FXML
    private AnchorPane holderPane;

    @FXML
    private TableView<User> students;

    @FXML
    private TableColumn<User, Number> Snum;

    @FXML
    private TableColumn<User, String> Name;

    @FXML
    private TableColumn<User, String> Major;

    @FXML
    private TableColumn<User, String> Level;

    @FXML
    private TableColumn<User, Number> Age;

    @FXML
    private JFXRadioButton SnumFilter;

    @FXML
    private JFXRadioButton NameFilter;

    @FXML
    private JFXTextField searchField;

    @FXML
    private JFXButton searchButton;

    private ResultSet rs;

    /**
     * The data as observable list of student data from databases
     */
    private ObservableList<User> studentData = FXCollections.observableArrayList();

    /**
     *
     * @return Main observable list of Student Data
     */
    public ObservableList<User> getStudentData() {
        return studentData;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize the student table, The cell must know which part of "tableUser" it needs to display
        Snum.setCellValueFactory(cellData -> cellData.getValue().snumProperty());
        Name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        Major.setCellValueFactory(cellData -> cellData.getValue().majorProperty());
        Level.setCellValueFactory(cellData -> cellData.getValue().levelProperty());
        Age.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        // TODO: 09/03/2018  http://code.makery.ch/blog/javafx-8-tableview-cell-renderer/ Cell Factory for custom the display(specially DateFormatter)
    }

    // TODO: 11/03/2018  fix some exception 
    @FXML
    private void searchHandle(ActionEvent event) {
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.getConnect();
        dbConnect.setProfileController(this);

        students.getItems().clear();

        if (SnumFilter.isSelected()) {
            String query = "SELECT * FROM Student WHERE NAME LIKE '%" + SnumFilter.getText() + "%'";
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

        students.setItems(studentData);

    }
}
