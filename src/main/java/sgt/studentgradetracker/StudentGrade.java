package sgt.studentgradetracker;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public class StudentGrade extends Input{
    @FXML
    private TextField searchGrades;
    @FXML
    private Button searchButton;
    private Scene scene;
    private Stage stage;


    @FXML
    private TableView<StudentGrade> subjectGradeTable;
    private TableView<StudentRecord> studentRecordTable;
    @FXML
    private Label subjectGradesLabel;
    @FXML
    private TableColumn<StudentRecord, String> fullnameColumn;
    @FXML
    private TableColumn<StudentRecord, String> idColumn;
    @FXML
    private TableColumn<StudentRecord, String> courseColumn;
    @FXML
    private TableColumn<StudentGrade, Float> writtenGradeColumn;
    @FXML
    private TableColumn<StudentGrade, Float>quizGradeColumn;
    @FXML
    private TableColumn<StudentGrade, Float>examGradeColumn;
    @FXML
    private TableColumn<StudentGrade, Float> finalGradeColumn;
    protected String subject;
    protected FloatProperty quizGrade;
    protected FloatProperty examGrade;
    protected FloatProperty writtenGrade;
    protected FloatProperty finalGrade;

    private StudentRecord currentStudentRecord;


         public StudentGrade(){
           this.subject = subject;
            quizGrade = new SimpleFloatProperty(0);
             examGrade =  new SimpleFloatProperty(0);
               writtenGrade =  new SimpleFloatProperty(0);
                finalGrade = new SimpleFloatProperty(0);
            }

         public StudentGrade(String subject, float wGrade, float wWeightage, float qGrade, float qWeightage,  float eGrade, float eWeightage){
           this.subject = subject;

            quizGrade =  new SimpleFloatProperty(qGrade);
             examGrade =  new SimpleFloatProperty(wGrade);
               writtenGrade =  new SimpleFloatProperty(eGrade);
                finalGrade = new SimpleFloatProperty((qGrade * (qWeightage/100)) + (eGrade * (eWeightage/100)) + (wGrade * (wWeightage/100)));
            }
    // Getters and setters for subject, quizGrade, examGrade, writtenGrade, and finalGrade
    // Subject getter and setter


    private boolean isDataUpdated = false;

    public void initialize(ObservableList<StudentRecord> studentRecords) {
        if (isDataUpdated) {
            // If data is updated, refresh the tables with the latest data
            refreshTables();
        } else {
            // If data is not updated, initialize the tables with blank data
            initializeTables(studentRecords);
        }
    }

    // Method to initialize the tables with blank data
    private void initializeTables(ObservableList<StudentRecord> studentRecords) {
        // Create a list to hold all the StudentGrades
        ObservableList<StudentGrade> allStudentGrades = FXCollections.observableArrayList();

        // Loop through each StudentRecord to retrieve their StudentGrades and add them to the allStudentGrades list
        for (StudentRecord studentRecord : studentRecords) {
            allStudentGrades.addAll(studentRecord.getSubjectGrades());
        }

        // Set the table with the allStudentGrades list and the studentRecords list
        subjectGradeTable.setItems(allStudentGrades);
        studentRecordTable.setItems(studentRecords);

        // Set the cell value factories for each column in the StudentGrades table
        TableColumn<Object, Object> subjectColumn;
        writtenGradeColumn.setCellValueFactory(cellData -> cellData.getValue().writtenGradeProperty().asObject());
        quizGradeColumn.setCellValueFactory(cellData -> cellData.getValue().quizGradeProperty().asObject());
        examGradeColumn.setCellValueFactory(cellData -> cellData.getValue().examGradeProperty().asObject());
        finalGradeColumn.setCellValueFactory(cellData -> cellData.getValue().finalGradeProperty().asObject());

        // Set the cell value factories for each column in the StudentRecords table
        fullnameColumn.setCellValueFactory(cellData -> cellData.getValue().getfullnameProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getidProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().getcourseProperty());
    }

    // Method to refresh the tables with the latest data
    private void refreshTables() {
        subjectGradeTable.refresh();
        studentRecordTable.refresh();
    }

    // Method to update the data flag when new data is added
    public void setDataUpdated(boolean updated) {
        isDataUpdated = updated;
    }

    @FXML
    private void onSearchButtonClicked(ActionEvent event) {
        String subject = searchGrades.getText();
        if (!subject.isEmpty()) {
            // Filter the studentRecords list to get records with the specified subject
            ObservableList<StudentRecord> filteredRecords = studentRecords.filtered(record ->
                    record.getSubjectGrades().stream().anyMatch(grade -> grade.getSubject().equalsIgnoreCase(subject))
            );

            // Update the table with the filtered records
            subjectGradeTable.setItems(getGradesForSubject(filteredRecords, subject));
            subjectGradesLabel.setText(subject + " Grades");
        } else {
            // Show an alert if the search subject field is empty
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please enter a subject to search.");
            alert.showAndWait();
        }
    }

    // Helper method to get the grades for a specific subject from the filtered student records
    private ObservableList<StudentGrade> getGradesForSubject(ObservableList<StudentRecord> filteredRecords, String subject) {
        ObservableList<StudentGrade> gradesForSubject = FXCollections.observableArrayList();
        for (StudentRecord record : filteredRecords) {
            for (StudentGrade grade : record.getSubjectGrades()) {
                if (grade.getSubject().equalsIgnoreCase(subject)) {
                    gradesForSubject.add(grade);
                }
            }
        }
        return gradesForSubject;
    }


    @FXML
    public void createButtonClicked(ActionEvent event)throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
        Parent root = loader.load();
        Input controller = loader.getController();
        controller.initializeInput(studentRecords); // Pass the same studentRecords list
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Student Grade Tracker");

    }

    @FXML
    public void homeButtonClicked(ActionEvent event)throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
        Parent root = loader.load();
        TeacherInterfaceController controller = loader.getController();
        controller.initialize(studentRecords); // Pass the same studentRecords list
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Student Grade Tracker");

    }

    public ObservableList<StudentRecord> getStudentRecords() {
        return studentRecords;
    }
    // Helper method to get the StudentGrade for a given subject from the list of grades
    private StudentGrade getGradeForSubject(ObservableList<StudentGrade> grades, String subject) {
        for (StudentGrade grade : grades) {
            if (grade.getSubject().equalsIgnoreCase(subject)) {
                return grade;
            }
        }
        // If the subject is not found, return a default StudentGrade with all grades set to -1
        return null;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // QuizGrade property getter and setter
    public FloatProperty quizGradeProperty() {
        return quizGrade;
    }

    public float getQuizGrade() {
        return quizGrade.get();
    }

    public void setQuizGrade(float grade) {
        quizGrade.set(grade);
    }

    // ExamGrade property getter and setter
    public FloatProperty examGradeProperty() {
        return examGrade;
    }

    public float getExamGrade() {
        return examGrade.get();
    }

    public void setExamGrade(float grade) {
        examGrade.set(grade);
    }

    // WrittenGrade property getter and setter
    public FloatProperty writtenGradeProperty() {
        return writtenGrade;
    }

    public float getWrittenGrade() {
        return writtenGrade.get();
    }

    public void setWrittenGrade(float grade) {
        writtenGrade.set(grade);
    }

    // FinalGrade property getter and setter
    public FloatProperty finalGradeProperty() {
        return finalGrade;
    }

    public float getFinalGrade() {
        return finalGrade.get();
    }

    public void setFinalGrade(float grade) {
        finalGrade.set(grade);
    }

    // StringProperty getter for subject
    public StringProperty subjectProperty() {
        return new SimpleStringProperty(subject);
    }

}


