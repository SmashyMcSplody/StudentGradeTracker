package sgt.studentgradetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
        // Example implementation:
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText(null);
        alert.setContentText("Welcome, student!");
        alert.showAndWait();
    }

    private void loadTeacherInterface() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText(null);
        alert.setContentText("Welcome, Teacher!");
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}