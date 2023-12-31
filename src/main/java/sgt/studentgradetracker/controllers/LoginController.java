package sgt.studentgradetracker.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgt.studentgradetracker.data.DataManager;
import sgt.studentgradetracker.data.StudentRecord;
import sgt.studentgradetracker.data.User;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController  extends DataManager {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;



    public void initialize(ObservableList<StudentRecord> studentRecords){
        super.initialize(studentRecords);

    }
    public void loginButtonClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate credentials
        user = validateCredentials(username, password);

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
            Alerts alert = new Alerts();
            alert.loginErrorAlert();

        }
    }

    private User validateCredentials(String username, String password) {

        InputDataController initialize = new InputDataController();
        initialize.teacherRecords.add(new StudentRecord("Nassem", "Layatan", "Nassem", "Nassem L. Maruhom", "2022-0690", "1st year BS-CpE", "nassem.maruhom", "password","Teacher"));
        initialize.teacherRecords.add(new StudentRecord("Elisha John", "Dingal", "Aton", "Elisha John D. ATon", "2022-6969", "1st year BS-CpE", "elisha.aton", "password","Teacher"));

        //checks all the StudentRecord inside the List studentRecords and the users List inside the StudentRecord object.
        allUsers = allStudentUsers();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/StudentInterface.fxml"));
            Parent root = loader.load();

            // Pass the user object to the student interface controller
            StudentInterfaceController studentInterfaceController = loader.getController();
            studentInterfaceController.setUser(user);
            studentInterfaceController.initialize(studentRecords);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/TeacherInterface.fxml"));
            Parent root = loader.load();

            // Pass the user object to the teacher interface controller
            TeacherInterfaceController teacherInterfaceController = loader.getController();
            teacherInterfaceController.setUser(user);
            TeacherInterfaceController controller = loader.getController();
            controller.initialize(studentRecords);
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

}
