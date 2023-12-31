package sgt.studentgradetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sgt.studentgradetracker.controllers.InputDataController;
import sgt.studentgradetracker.data.StudentRecord;

import java.io.IOException;


public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Login-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Student Grade Tracker");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}