package sgt.studentgradetracker;


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
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
//declarations
         ArrayList<StudentRecord> StudentRecord = new ArrayList<StudentRecord>();
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
    StudentRecord student = new StudentRecord(" Test", "Test", "Test", "Test","Test","Test");

         

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


        public void addButtonClicked(ActionEvent event) {
             String subject = subjectField.getText();

            try {
                float writtenGrade = Float.parseFloat(writtenGradeField.getText());
                float writtenWeightage = Float.parseFloat(writtenWeightField.getText());
                float quizGrade = Float.parseFloat(quizGradeField.getText());
                float quizWeightage =Float.parseFloat(quizWeightField.getText());
                float examGrade = Float.parseFloat(examGradeField.getText());
                float examWeight = Float.parseFloat(examWeightField.getText());

                student.addGrade(subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeight);
            }
            catch (NumberFormatException e) {
                invalidInputAlert("Wrongly inputted a character in the grades and weightage! Please input numeric characters!");

            }

         }



    public void toInput(){
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
                 StudentRecord student = new StudentRecord(fname, mname, lname, fullname, idnum, course);
                 StudentRecord.add(student);
             }

             //If there's a duplicate record
             else{
                 //Will open the errorStage fxml file
                 try{
                     // Load the teacher interface FXML file
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("ErrorStage.fxml"));
                     Parent root = loader.load();

                     // Create a new stage for the teacher interface
                     Stage errorStage = new Stage();
                     errorStage.setTitle("Duplicate record found!");
                     // Will make the stage unresizable so it stays as a small window
                     errorStage.setResizable(false);
                     //Scene resolution
                     errorStage.setScene(new Scene (root, 300, 200));

                     errorStage.show();
                 }catch (IOException e){
                     e.printStackTrace();
                 }
             }

         }

         public String duplicateChecker() {
             String duplicateCheck = "No Duplicate";
             for (int k = 0; k < StudentRecord.size(); k++) {
                 if (StudentRecord.get(k).getFirstname().equals(fname) && StudentRecord.get(k).getLastname().equals(lname)) {
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



      }



