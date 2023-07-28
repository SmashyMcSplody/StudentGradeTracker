package sgt.studentgradetracker;

import javafx.collections.ObservableList;
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

public class LoginController  extends Input {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private ArrayList<User> allUsers = new ArrayList<User>();

    public void initialize(ObservableList<StudentRecord> studentRecords, ArrayList<StudentRecord> teacherRecords){
        super.initialize(studentRecords, teacherRecords);

    }
    public void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate credentials
        User user = validateCredentials(username, password);

        if (user != null) {
            if (user.getRole().equals("Student")) {
                // Load the student interface
                loadStudentInterface(user);
            } else if (user.getRole().equals("Teacher")) {
                // Load the teacher interface
                loadTeacherInterface(user);
            }
        } else {
            // Show error message for invalid credentials
            showError("Invalid username or password!");
        }
    }

    private User validateCredentials(String username, String password) {

        Input initialize = new Input();
        initialize.teacherRecords.add(new StudentRecord("Elisha John", "Dingal", "Aton","Elisha John Dingal Aton", "2022-0956", "1st year BS-CpE","elisha.john", "password","Teacher"));
        initialize.teacherRecords.add(new StudentRecord("Nassem", "Layatan", "Nassem", "Nassem L. Maruhom", "2022-0690", "1st year BS-CpE", "nassem.maruhom", "password","Teacher"));


        //checks all the StudentRecord inside the List studentRecords and the users List inside the StudentRecord object.
        for (StudentRecord record : studentRecords) {
            ArrayList<User> users = record.getUsers();
            if (users != null) {
                allUsers.addAll(users);
            }
        }

        for (StudentRecord record : initialize.teacherRecords) {
            ArrayList<User> users = record.getUsers();
            if (users != null) {
                allUsers.addAll(users);
            }
        }
        // Loop through the student list and check each record for the provided username and password
        for (User user : allUsers) {
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
            TeacherInterfaceController controller = loader.getController();
            controller.initialize(studentRecords, teacherRecords);
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
