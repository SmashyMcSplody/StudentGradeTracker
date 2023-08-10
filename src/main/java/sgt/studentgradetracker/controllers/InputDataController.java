package sgt.studentgradetracker.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import sgt.studentgradetracker.data.DataManager;
import sgt.studentgradetracker.data.StudentRecord;
import java.io.IOException;
import sgt.studentgradetracker.data.User;
public class InputDataController extends DataManager {

    @FXML
    private TextField courseField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField idnumField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField middlenameField;

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
    




         public void initialize(ObservableList<StudentRecord> studentRecords) {super.initialize(studentRecords);}
         public void storeUser(User userLogin){user = userLogin;}
         @FXML
         public void nextButtonClicked(ActionEvent event) throws IOException{

             //WIll open the grade inputting scene;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/InputGrade-Scene.fxml"));
             Parent root = loader.load();
             InputDataController inputGradesController = loader.getController();
             inputGradesController.initialize(studentRecords); // Pass the same studentRecords list
             inputGradesController.storeUser(user);
             stage = (Stage)((Node)event.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
             stage.setTitle("Input Grades");

         }
         @FXML
         public void backButtonClicked(ActionEvent event) throws IOException{

             //WIll open the grade inputting scene;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/InputData-Scene.fxml"));
             Parent root = loader.load();
             InputDataController inputDataController = loader.getController();
             inputDataController.initialize(studentRecords); // Pass the same studentRecords list
             stage = (Stage)((Node)event.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();

             stage.setTitle("Input Student Data");
         }

        @FXML
        public void classGradesButtonClicked(ActionEvent event)throws IOException{

            //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/ClassGrades-Scene.fxml"));
            Parent root = loader.load();
            GradeViewController GradesController = loader.getController();
            GradesController.initialize(studentRecords); // Pass the same studentRecords list
            GradesController.storeUser(user);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage.setTitle("Class Grades");
        }
        @FXML
        public void homeButtonClicked(ActionEvent event)throws IOException{

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
            @FXML
            public void inputButtonClicked() throws IOException {

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
                if(duplicateChecker(fname, lname, mname, idnum).equals("No Duplicate")){
                    //Storing the student info to array

                    StudentRecord student = new StudentRecord(fname, mname, lname, fullname, idnum, course);
                    addStudent(student);
                    Alerts alert = new Alerts();
                    alert.successRecordAlert(fullname);
                 }

                //If there's a duplicate record
                 else{
                 //Will open the errorStage fxml file
                 Alerts alert = new Alerts();
                 alert.duplicateAlert();
                }
            }


            @FXML
            public void addButtonClicked() throws IOException {
                String subject = subjectField.getText();
                String idnumGrades  = idnumgradeField.getText();
                    if (subject.equals("") || idnumGrades.equals("")) {
                    Alerts alert = new Alerts();
                    alert.incompleteInputAlert();
                    }
                    else{
                         try {
                            float writtenGrade = Float.parseFloat(writtenGradeField.getText());
                            float writtenWeightage = Float.parseFloat(writtenWeightField.getText());
                            float quizGrade = Float.parseFloat(quizGradeField.getText());
                            float quizWeightage = Float.parseFloat(quizWeightField.getText());
                            float examGrade = Float.parseFloat(examGradeField.getText());
                            float examWeight = Float.parseFloat(examWeightField.getText());

                            if(writtenWeightage + quizWeightage + examWeight != 100){
                                 Alerts alert = new Alerts();
                                 alert.invalidWeightageAlert();
                            }

                            else if(writtenGrade > 100 || quizGrade > 100 || examGrade > 100){
                                Alerts alert = new Alerts();
                                alert.invalidGradeAlert();
                            }

                            else {
                                if (findStudentbyIdNum(idnumGrades).equals("Exists")) {
                                    Alerts alert = new Alerts();
                                    alert.successGradeAlert(idnumGrades);
                                    addGrades(idnumGrades, subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeight);
                                }
                                else {
                                    Alerts alert = new Alerts();
                                    alert.nullStudentAlert();
                                 }
                            }

                         } catch (NumberFormatException | IOException e) {
                             Alerts alert = new Alerts();
                             alert.invalidInputAlert();
                         }
                    }
            }









}





