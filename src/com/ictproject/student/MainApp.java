package com.ictproject.student;

import com.ictproject.student.ui.mainui.admin.ViewConstants;
import com.ictproject.student.ui.mainui.admin.AdminDashboardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        showLoginStage();
    }

    public void showLoginStage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ViewConstants.LOGIN_VIEW));
        Scene scene = new Scene(root);

        primaryStage.setTitle(ViewConstants.APP_NAME);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("resources/img/icons8_Graduation_Cap_32px.png"));
        primaryStage.show();
        createReference();
    }

    private void createReference() {
        AdminDashboardController.setMainApp(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
