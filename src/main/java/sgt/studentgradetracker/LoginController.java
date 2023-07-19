package sgt.studentgradetracker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate credentials
        User user = validateCredentials(username, password);

        if (user != null) {
            if (user.getRole().equals("student")) {
                // Load the student interface
                loadStudentInterface(user);
            } else if (user.getRole().equals("teacher")) {
                // Load the teacher interface
                loadTeacherInterface(user);
            }
        } else {
            // Show error message for invalid credentials
            showError("Invalid username or password!");
        }
    }

    private User validateCredentials(String username, String password) {
        SampleRecordDeclare declare = new SampleRecordDeclare();
        ArrayList<SampleRecord> studentList = declare.getStudentList();

        // Loop through the student list and check each record for the provided username and password
        for (SampleRecord user : studentList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Return the user (student or teacher) if the credentials match
            }
        }

        // If no matching user is found, return null
        return null;
    }



    private void loadStudentInterface(User user) {
        try {
            // Load the student interface FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentInterface.fxml"));
            Parent root = loader.load();

            // Pass the user object to the student interface controller
            StudentInterfaceController studentInterfaceController = loader.getController();
            studentInterfaceController.setUser(user);

            // Create a new stage for the student interface
            Stage studentStage = new Stage();
            studentStage.setTitle("Student Grade Tracker");
            studentStage.setScene(new Scene(root));

            // Close the login scene
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            // Show the student interface
            studentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTeacherInterface(User user) {
        try {
            // Load the teacher interface FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
            Parent root = loader.load();

            // Pass the user object to the teacher interface controller
            TeacherInterfaceController teacherInterfaceController = loader.getController();
            teacherInterfaceController.setUser(user);

            // Create a new stage for the teacher interface
            Stage teacherStage = new Stage();
            teacherStage.setTitle("Student Grade Tracker");
            teacherStage.setScene(new Scene(root));

            // Close the login scene
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            // Show the teacher interface
            teacherStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
