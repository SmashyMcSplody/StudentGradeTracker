package sgt.studentgradetracker.controllers;

import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.ObservableList;
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


public class GradeViewController extends DataManager {

    @FXML
    private TextField searchGrades;
    @FXML
    private TableView<StudentGrade> subjectGradeTable;
    @FXML
    private TableColumn<StudentGrade, String> subjectColumn;
    @FXML
    private TableColumn<StudentGrade, String> idColumn;
    @FXML
    private TableColumn<StudentGrade, Float> writtenGradeColumn;
    @FXML
    private TableColumn<StudentGrade, Float> examGradeColumn;
    @FXML
    private TableColumn<StudentGrade, Float> quizGradeColumn;

    @FXML
    private TableColumn<StudentGrade, Float> finalGradeColumn;

    public void storeUser(User user){this.user = user;}


    public void initialize(ObservableList<StudentRecord> studentRecords) {
        super.initialize(studentRecords);
        for (StudentRecord record : studentRecords) {
            ObservableList<StudentGrade> subjectGrades = record.getSubjectGrades();
            if (subjectGrades != null) {
                allStudentGrades.addAll(subjectGrades);
            }
        }

        subjectGradeTable.setItems(filteredSubjects);
        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idnumProperty());
        writtenGradeColumn.setCellValueFactory(cellData -> {
            float writtenGrade = cellData.getValue().getWrittenGrade();
            return new SimpleFloatProperty(writtenGrade).asObject();
        });
        quizGradeColumn.setCellValueFactory(cellData -> {
            float quizGrade = cellData.getValue().getQuizGrade();
            return new SimpleFloatProperty(quizGrade).asObject();
        });
        examGradeColumn.setCellValueFactory(cellData -> {
            float examGrade = cellData.getValue().getExamGrade();
            return new SimpleFloatProperty(examGrade).asObject();
        });
        finalGradeColumn.setCellValueFactory(cellData -> {
            float finalGrade = cellData.getValue().getFinalGrade();
            return new SimpleFloatProperty(finalGrade).asObject();
        });

        searchGrades.textProperty().addListener((observable, oldValue, newValue) -> {
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
    public void createButtonClicked(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/InputData-Scene.fxml"));
        Parent root = loader.load();
        InputDataController controller = loader.getController();
        controller.initialize(studentRecords); // Pass the same studentRecords list
        controller.storeUser(user);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Input");

    }

    @FXML
    public void homeButtonClicked(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/TeacherInterface.fxml"));
        Parent root = loader.load();
        TeacherInterfaceController controller = loader.getController();
        controller.initialize(studentRecords); // Pass the same studentRecords list
        controller.setUser(user);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Student Grade Tracker");

    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/Login-Scene.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.initialize(studentRecords);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("");
    }

}
