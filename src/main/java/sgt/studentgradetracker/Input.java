package sgt.studentgradetracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Input{
//declarations

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
    private TextField middlenameField;

    private Stage gradeStage;
    private Scene gradeScene;


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
    private int studentNumber;
    protected ObservableList<StudentRecord> studentRecords =  FXCollections.observableArrayList();
    protected ArrayList<StudentRecord> teacherRecords = new ArrayList<StudentRecord>();


    public void initialize(ObservableList<StudentRecord> studentRecords) {
        this.studentRecords = studentRecords;
    }
         @FXML
         public void nextButtonClicked(ActionEvent event) throws IOException{

             //WIll open the grade inputting scene;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("InputGrade-Scene.fxml"));
             Parent root = loader.load();
             Input inputGradesController = loader.getController();
             inputGradesController.initialize(studentRecords); // Pass the same studentRecords list
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
             Input inputDataController = loader.getController();
             inputDataController.initialize(studentRecords); // Pass the same studentRecords list
             gradeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
             gradeScene = new Scene(root);
             gradeStage.setScene(gradeScene);
             gradeStage.show();

             gradeStage.setTitle("Input Student Data");
         }

        @FXML
        public void classGradesButtonClicked(ActionEvent event)throws IOException{

            //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ClassGrades-Scene.fxml"));
            Parent root = loader.load();
            StudentGrades GradesController = loader.getController();
            GradesController.initialize(studentRecords); // Pass the same studentRecords list
            gradeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            gradeScene = new Scene(root);
            gradeStage.setScene(gradeScene);
            gradeStage.show();

            gradeStage.setTitle("Class Grades");
        }
        @FXML
        public void homeButtonClicked(ActionEvent event)throws IOException{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
            Parent root = loader.load();
            TeacherInterfaceController controller = loader.getController();
            controller.initialize(studentRecords); // Pass the same studentRecords list
            gradeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            gradeScene = new Scene(root);
            gradeStage.setScene(gradeScene);
            gradeStage.show();
            gradeStage.setTitle("Student Grade Tracker");

         }

        @FXML
        private void handleLogoutButtonAction(ActionEvent event) throws IOException {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-Scene.fxml"));
            Parent root = loader.load();
            LoginController loginController = loader.getController();
            loginController.initialize(studentRecords);
            gradeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            gradeScene = new Scene(root);
            gradeStage.setScene(gradeScene);
            gradeStage.show();

             gradeStage.setTitle("");
        }

    @FXML
    public void addButtonClicked(ActionEvent event) throws IOException {
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
                if(writtenGrade > 100 || quizGrade > 100 || examGrade > 100){
                    Alerts alert = new Alerts();
                    alert.invalidGradeAlert();

                }
                else {

                    if (findStudentbyIdNum(idnumGrades).equals("Exists")) {
                        Alerts alert = new Alerts();
                        alert.successGradeAlert(idnumGrades);
                        studentRecords.get(studentNumber).addGrade(idnumGrades, subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeight);

                    } else {
                        Alerts alert = new Alerts();
                        alert.nullStudentAlert();

                    }
                }
            }   catch (NumberFormatException | IOException e) {
                Alerts alert = new Alerts();
                alert.invalidInputAlert();

            }
        }
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
                 ObservableList<StudentGrade> subjectGrades = FXCollections.observableArrayList();
                 StudentRecord student = new StudentRecord(fname, mname, lname, fullname, idnum, course);
                 Alerts alert = new Alerts();
                 alert.successRecordAlert(fullname);
                 studentRecords.add(student);



                 FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
                 Parent root = loader.load();
                 TeacherInterfaceController controller = loader.getController();
                 controller.initialize(studentRecords);

             }
             //If there's a duplicate record
             else{
                 //Will open the errorStage fxml file
                 Alerts alert = new Alerts();
                 alert.duplicateAlert();

             }

         }
        public String duplicateChecker() {
             String duplicateCheck = "No Duplicate";
            if (studentRecords.size() > 0){
                for (int k = 0; k < studentRecords.size(); k++) {
                    if ((studentRecords.get(k).getFirstname().equals(fname) && studentRecords.get(k).getLastname().equals(lname)) || studentRecords.get(k).getIdnum().equals(idnum)) {
                        duplicateCheck = "Duplicate Found";
                    } else {
                        duplicateCheck = "No Duplicate";
                    }
                }
            }
            else{
                duplicateCheck = "No Duplicate";
            }

             return duplicateCheck;
        }


        public String findStudentbyIdNum(String idnumGrades){
            String studentChecker = "Does not Exist";
            for(int i = 0; i < studentRecords.size(); i++){
                if (idnumGrades.equals(studentRecords.get(i).getIdnum())) {
                    studentChecker = "Exists";

                    break;
                }
            }
            return studentChecker;
        }



    }





