package sgt.studentgradetracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TeacherInterfaceController extends Input {

    public Button logoutButton;
    public TableColumn subjectColumn;
    public TableColumn gradeColumn;

    @FXML
    private TableView<StudentRecord> tableView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private TableColumn<StudentRecord, String> fnameColumn;
    @FXML
    private TableColumn<StudentRecord, String> mnameColumn;
    @FXML
    private TableColumn<StudentRecord, String> lnameColumn;
    @FXML
    private TableColumn<StudentRecord, String> idColumn;
    @FXML
    private TableColumn<StudentRecord, String> courseColumn;


    private Scene scene;
    private Stage stage;
    private Parent root;


    // Store the User object    private User user;



    @FXML
    public void initialize(ObservableList<StudentRecord> studentRecords) {
        super.initialize(studentRecords);
        // Set the data to be displayed in the TableView
        tableView.setItems(studentRecords);

        // Define how the columns will get their data from the SampleRecord objects
        fnameColumn.setCellValueFactory(cellData -> cellData.getValue().getfnameProperty());
        mnameColumn.setCellValueFactory(cellData -> cellData.getValue().getmnameProperty());
        lnameColumn.setCellValueFactory(cellData -> cellData.getValue().getlnameProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getidProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().getcourseProperty());
    }


    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-Scene.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.initialize(studentRecords);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("");
    }

    @FXML
    private void createButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InputData-Scene.fxml"));
        Parent root = loader.load();
        Input input = loader.getController();
        input.initialize(studentRecords); // Pass the same studentRecords list
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Create new record");
    }

    @FXML
    private void classGradesButtonAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClassGrades-Scene.fxml"));
        Parent root = loader.load();
        StudentGrades subjectGrades = loader.getController();
        subjectGrades.initialize(studentRecords); // Pass the same studentRecords list
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Class Grades");
    }

}
