package sgt.studentgradetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void loginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate credentials
        User user = validateCredentials(username, password);

        if (user != null) {
            if (user.getRole().equals("student")) {
                // Load the student interface
                loadStudentInterface();
            } else if (user.getRole().equals("teacher")) {
                // Load the teacher interface
                loadTeacherInterface();
            }
        } else {
            // Show error message for invalid credentials
            showError("Invalid username or password!");
        }
    }

    private User validateCredentials(String username, String password) {
        // Retrieve user from database or check credentials from memory
        // Return the user object if valid, otherwise return null
        User student = new User("student123", "password", "student");
        User teacher = new User("teacher456", "password", "teacher");

        if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
            return student;
        } else if (teacher.getUsername().equals(username) && teacher.getPassword().equals(password)) {
            return teacher;
        } else {
            return null;
        }
    }

    private void loadStudentInterface() {
        try {
            // Load the student interface FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentInterface.fxml"));
            Parent root = loader.load();

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



    private void loadTeacherInterface() {
        try {
            // Load the student interface FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
            Parent root = loader.load();

            // Create a new stage for the student interface
            Stage teacherStage = new Stage();
            teacherStage.setTitle("Student Grade Tracker");
            teacherStage.setScene(new Scene(root));

            // Close the login scene
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            // Show the student interface
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