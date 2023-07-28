package sgt.studentgradetracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

public class StudentInterfaceController extends Input {
    public Button logoutButton;

    @FXML
    private TableView<StudentGrade> tableView;

    @FXML
    private TableColumn<StudentGrade, String> subjectColumn;

    @FXML
    private TableColumn<StudentGrade, String> gradeColumn;

    private ObservableList<StudentGrade> sampleSubjects;

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label courseLabel;

    // Store the User object (You can remove this if not needed anymore)
    private User user;

    // Method to set the User object (You can remove this if not needed anymore)
    public void setUser(User user) {
        if (user != null) {
            this.user = user;
            // Assuming you have a 'getFullname' method in StudentRecord
            String fullname = user.getFullname();
            nameLabel.setText(fullname);

            // Assuming you have a 'getIdnum' method in StudentRecord
            String idnum = user.getIdnum();
            idLabel.setText(idnum);

            // Assuming you have a 'getCourse' method in StudentRecord
            String course = user.getCourse();
            courseLabel.setText(course);
        } else {
            nameLabel.setText("Null");
            idLabel.setText("Null");
            courseLabel.setText("Null");
        }
    }

//    @FXML
//    public void initialize(ObservableList<StudentRecord> studentRecords, ArrayList<StudentRecord> teacherRecords) {
//        super.initialize(studentRecords, teacherRecords);
//        // Set the data to be displayed in the TableView
//        tableView.setItems(StudentGrade);
//
//        // Define how the columns will get their data from the SampleRecord objects
//        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
//        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().finalGradeProperty());
//    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {

        // Load the login scene and set it as the new scene in the primary stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-Scene.fxml"));
        Parent loginRoot = fxmlLoader.load();
        Scene loginScene = new Scene(loginRoot);

        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setScene(loginScene);
        stage.show();
    }
}
