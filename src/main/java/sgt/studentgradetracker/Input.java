package sgt.studentgradetracker;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import javax.security.auth.Subject;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static javafx.collections.FXCollections.*;

public class Input {
//declarations
    ArrayList<StudentRecord> StudentRecords = new ArrayList<StudentRecord>();
    protected String fname;
    protected String lname;
    protected String mname;
    protected String fullname;
    protected String idnum;
    protected String course;

    @FXML
    private TextField courseField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField idnumField;

    @FXML
    private TextField lastnameField;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField middlenameField;

    @FXML
    private Button nextrecordButton;
    @FXML
    private Button inputButton;

    private Stage gradeStage;
    private Scene gradeScene;
    @FXML
    private Button addgradeButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField examGradeField;

    @FXML
    private TextField examWeightField;

    @FXML
    private TextField quizGradeField;

    @FXML
    private TextField quizWeightField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField writtenGradeField;

    @FXML
    private TextField writtenWeightField;
    @FXML
    private TextField idnumgradeField;
    @FXML
    private Button classGradesButton;
    //
    private int studentNumber;

    public Input(){

    }

         @FXML
         public void nextButtonClicked(ActionEvent event) throws IOException{

             //WIll open the grade inputting scene;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("InputGrade-Scene.fxml"));
             Parent root = loader.load();
             gradeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
             gradeScene = new Scene(root);
             gradeStage.setScene(gradeScene);
             gradeStage.show();
             gradeStage.setTitle("Input Grades");

         }
         @FXML
         public void backButtonClicked(ActionEvent event) throws IOException{

             //WIll open the grade inputting scene;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("InputData-Scene.fxml"));
             Parent root = loader.load();
             gradeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
             gradeScene = new Scene(root);
             gradeStage.setScene(gradeScene);
             gradeStage.show();

             gradeStage.setTitle("Input Student Data");
         }

        @FXML
        public void addButtonClicked(ActionEvent event) {
            if (subjectField.getText().equals("")) {
                invalidInputAlert("Please input the complete data!");
            } else {
                    String subject = subjectField.getText();

                    try {
                        float writtenGrade = Float.parseFloat(writtenGradeField.getText());
                        float writtenWeightage = Float.parseFloat(writtenWeightField.getText());
                        float quizGrade = Float.parseFloat(quizGradeField.getText());
                        float quizWeightage = Float.parseFloat(quizWeightField.getText());
                        float examGrade = Float.parseFloat(examGradeField.getText());
                        float examWeight = Float.parseFloat(examWeightField.getText());

                        String checker = studentChecker();

                        if (checker.equals("Exists")) {
                            StudentRecords.get(studentNumber).addGrade(subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeight);
                        } else {
                            nullStudentAlert("Student with the given id-number does not exist! Please try again!");

                        }

                    }   catch (NumberFormatException e) {
                        invalidInputAlert("Wrongly inputted a character in the grades and weightage! Please input numeric characters!");

                    }
                }
        }
        @FXML
        public void classGradesButtonClicked(ActionEvent event)throws IOException{

            //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ClassGrades-Scene.fxml"));
            Parent root = loader.load();
            gradeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            gradeScene = new Scene(root);
            gradeStage.setScene(gradeScene);
            gradeStage.show();

            gradeStage.setTitle("Class Grades");
        }
        @FXML
        public void homeButtonClicked(ActionEvent event)throws IOException{

            //WIll open the grade inputting scene;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
                Parent root = loader.load();
                gradeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                gradeScene = new Scene(root);
                gradeStage.setScene(gradeScene);
                gradeStage.show();

                    gradeStage.setTitle("Class Grades");
         }
        @FXML
        private void handleLogoutButtonAction(ActionEvent event) throws IOException {

            //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-Scene.fxml"));
            Parent root = loader.load();
            gradeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            gradeScene = new Scene(root);
            gradeStage.setScene(gradeScene);
            gradeStage.show();

            gradeStage.setTitle("");
        }


        @FXML
        public void toInput() throws IOException {
             //Student Info input
             fname = firstnameField.getText();
              mname = middlenameField.getText();
               lname = lastnameField.getText();
                fullname = fname +" " +mname +" " +lname;

                //Student Data input
                  idnum = idnumField.getText();
                    course = courseField.getText();


              //Code will then check
             //If no duplicate then it will store the student data
             if(duplicateChecker().equals("No Duplicate")){
                 //Storing the student info to array
                 successAlert(fullname);
                 StudentRecord student = new StudentRecord(fname, mname, lname, fullname, idnum, course);
                 StudentRecords.add(student);

             }

             //If there's a duplicate record
             else{
                 //Will open the errorStage fxml file
                 duplicateAlert();


             }

         }

        public String duplicateChecker() {
             String duplicateCheck = "No Duplicate";
             for (int k = 0; k < StudentRecords .size(); k++) {
                 if (StudentRecords.get(k).getFirstname().equals(fname) && StudentRecords.get(k).getLastname().equals(lname)) {
                    duplicateCheck = "Duplicate Found";
                 }
                 else{
                     duplicateCheck = "No Duplicate";
                 }
             }
             return duplicateCheck;
        }

        public void invalidInputAlert(String message){
             Alert invalidInput = new Alert(Alert.AlertType.ERROR);
             invalidInput.setTitle("Invalid input");
             invalidInput.setHeaderText("Invalid character input");
             invalidInput.setContentText(message);
             invalidInput.showAndWait();
        }
        public void nullStudentAlert(String message){
            Alert invalidInput = new Alert(Alert.AlertType.ERROR);
            invalidInput.setTitle("No Student found!");
            invalidInput.setHeaderText("Error! No Student found!");
            invalidInput.setContentText(message);
            invalidInput.showAndWait();

         }
        public String studentChecker(){
            String studentChecker = "Exists";
            for (int i = 0; i < StudentRecords.size(); i++) {
                if (idnumgradeField.getText().equals(StudentRecords.get(i).getIdnum())) {
                    studentChecker = "Exists";
                    studentNumber = i;
                }
                else{
                    studentChecker = "Does not exists";
                }
            }
            return studentChecker;
        }

        public void testInput(){
            StudentRecord testStudent = new StudentRecord(" Test", "Test", "Test", "Test","Test","Test");
            StudentRecords.add(testStudent);
        }
        public void arrayConversion(ArrayList<StudentRecord> studentRecordList){
            ObservableList<StudentRecord> observableList = FXCollections.observableList(studentRecordList);


        }

    public void duplicateAlert() throws IOException {
        // Will open the grade inputting scene;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DuplicateAlert.fxml"));
        Parent root = loader.load();
        gradeStage = new Stage();
        gradeScene = new Scene(root);
        gradeStage.setScene(gradeScene);
        gradeStage.show();
        gradeStage.setTitle("Error!");
        gradeStage.setResizable(false);
    }
    public void successAlert(String fullname){
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Sucess!");
        success.setContentText("Sucessfully Created a student record for" + fullname);
        success.showAndWait();
    }




    }





