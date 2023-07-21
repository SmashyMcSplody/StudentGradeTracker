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

public class StudentInterfaceController {
    public Button logoutButton;

    @FXML
    private TableView<SampleSubjects> tableView;

    @FXML
    private TableColumn<SampleSubjects, String> subjectColumn;

    @FXML
    private TableColumn<SampleSubjects, String> gradeColumn;

    private ObservableList<SampleSubjects> sampleSubjects;

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label courseLabel;

    // Store the User object
    private User user;

    // Method to set the User object
    public void setUser(User user) {
        this.user = user;
        // Update the UI with the firstname
            SampleRecord sampleRecord = (SampleRecord) user;
            String fullName = sampleRecord.getFname() + " " + sampleRecord.getLname();
            nameLabel.setText(fullName);
            idLabel.setText(sampleRecord.getId());
            courseLabel.setText(sampleRecord.getCourse());


    }

    @FXML
    public void initialize() {
        // Create the list to store the student objects
        sampleSubjects = FXCollections.observableArrayList();

        // Sample data (you can add more students here)
        SampleRecordDeclare declare = new SampleRecordDeclare();
        ArrayList<SampleRecord> studentList = declare.getStudentList();

        // Add the subjects from each student to the sampleSubjects list
        for (SampleRecord student : studentList) {
            sampleSubjects.addAll(student.getSubjects());
        }

        // Set the data to be displayed in the TableView
        tableView.setItems(sampleSubjects);

        // Define how the columns will get their data from the SampleRecord objects
        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
    }

    @FXML
    private void AnalyticButtonClicked(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("example");
        alert.setHeaderText(null);
        alert.setContentText("Button Clicked");
        alert.showAndWait();
    }
    
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
