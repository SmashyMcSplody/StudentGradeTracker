package sgt.studentgradetracker.controllers;

import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sgt.studentgradetracker.data.DataManager;
import sgt.studentgradetracker.data.StudentGrade;
import sgt.studentgradetracker.data.StudentRecord;
import sgt.studentgradetracker.data.User;

import java.io.IOException;

public class StudentInterfaceController extends DataManager {
    @FXML
    private Label courseLabel;

    @FXML
    private TableView<StudentGrade> studentGradeTable;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;
    @FXML
    private TextField searchGrade;

    @FXML
    private TableColumn<StudentGrade, Float> examColumn;

    @FXML
    private TableColumn<StudentGrade, Float> finalColumn;

    @FXML
    private TableColumn<StudentGrade, Float> quizColumn;

    @FXML
    private TableColumn<StudentGrade, String> subjectColumn;

    @FXML
    private TableColumn<StudentGrade, Float> writtenColumn;

    private ObservableList<StudentGrade> allStudentGrades = FXCollections.observableArrayList();
    private FilteredList<StudentGrade> filteredSubjects;


    // Method to set the User object (You can remove this if not needed anymore)
    public void setUser(User userLogin) {
        if (userLogin != null) {
            user = userLogin;
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
    @FXML
    public void initialize(ObservableList<StudentRecord> studentRecords){
        super.initialize((studentRecords));
            for (StudentRecord record : studentRecords) {
                ObservableList<StudentGrade> subjectGrades = record.getSubjectGrades();
                if (subjectGrades != null) {
                for(StudentGrade subject : subjectGrades){
                    if(subject.getIdnum().equals(user.getIdnum())){
                        allStudentGrades.add(subject);
                         }
                     }
                }
            }

            filteredSubjects = new FilteredList<>(allStudentGrades, p -> true);
        studentGradeTable.setItems(filteredSubjects);

        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
        writtenColumn.setCellValueFactory(cellData -> {
            float writtenGrade = cellData.getValue().getWrittenGrade();
            return new SimpleFloatProperty(writtenGrade).asObject();
        });
        quizColumn.setCellValueFactory(cellData -> {
            float quizGrade = cellData.getValue().getQuizGrade();
            return new SimpleFloatProperty(quizGrade).asObject();
        });
        examColumn.setCellValueFactory(cellData -> {
            float examGrade = cellData.getValue().getExamGrade();
            return new SimpleFloatProperty(examGrade).asObject();
        });
        finalColumn.setCellValueFactory(cellData -> {
            float finalGrade = cellData.getValue().getFinalGrade();
            return new SimpleFloatProperty(finalGrade).asObject();
        });

        searchGrade.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredSubjects.setPredicate(subject -> {
                // If the search bar is empty, show all subjects
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Convert the search input to lowercase for case-insensitive filtering
                String lowerCaseFilter = newValue.toLowerCase();

                // Check if the subject name or grade contains the search input
                return subject.getSubject().toLowerCase().contains(lowerCaseFilter)
                        || subject.getSubject().toLowerCase().contains(lowerCaseFilter);
            });
        });



    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/Login-Scene.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.initialize(studentRecords);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("");
    }
    @FXML
    private void changePassButtonClicked(ActionEvent event) throws IOException {
        //WIll open the grade inputting scene;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/StudentSettings.fxml"));
        Parent root = loader.load();
        SettingController settingsController = loader.getController();
        settingsController.initialize(studentRecords); // Pass the same studentRecords list
        settingsController.setUser(user);
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Input Grades");


    }
}
