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

import java.io.IOException;

public class TeacherInterfaceController {

    public Button logoutButton;
    public TableColumn subjectColumn;
    public TableColumn gradeColumn;

    @FXML
    private TableView<SampleRecord> tableView;

    @FXML
    private TableColumn<SampleRecord, String> fnameColumn;
    @FXML
    private TableColumn<SampleRecord, String> mnameColumn;
    @FXML
    private TableColumn<SampleRecord, String> lnameColumn;
    @FXML
    private TableColumn<SampleRecord, String> idColumn;
    @FXML
    private TableColumn<SampleRecord, String> courseColumn;

    private ObservableList<SampleRecord> sampleRecords;

    // Store the User object
    private User user;

    // Method to set the User object
    public void setUser(User user) {
        this.user = user;
        // Update the UI with the user information

    }

    @FXML
    public void initialize() {
        // Create the list to store the student objects
        sampleRecords = FXCollections.observableArrayList();

        // Sample data (you can add more students here)
        SampleRecordDeclare declare = new SampleRecordDeclare();
        sampleRecords.addAll(declare.getStudentList());

        // Set the data to be displayed in the TableView
        tableView.setItems(sampleRecords);

        // Define how the columns will get their data from the SampleRecord objects
        fnameColumn.setCellValueFactory(cellData -> cellData.getValue().fnameProperty());
        mnameColumn.setCellValueFactory(cellData -> cellData.getValue().mnameProperty());
        lnameColumn.setCellValueFactory(cellData -> cellData.getValue().lnameProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().courseProperty());
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
        // Perform any logout logic if necessary

        // Load the login scene and set it as the new scene in the primary stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-Scene.fxml"));
        Parent loginRoot = fxmlLoader.load();
        Scene loginScene = new Scene(loginRoot);

        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setScene(loginScene);
        stage.show();
    }

}
