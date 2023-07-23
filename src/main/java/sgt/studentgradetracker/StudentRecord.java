package sgt.studentgradetracker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentRecord extends User{
    protected String firstname;
    protected String middlename;
    protected String lastname;
    protected String fullname;
    protected String idnum;
    protected String course;

    private Scene scene;
    private Stage stage;



        @FXML
        private TableColumn<?, ?> courseColumn;

        @FXML
        private Button createButton;

        @FXML
        private TableColumn<?, ?> examGradeColumn;

        @FXML
        private TableColumn<?, ?> finalGradeColumn;

        @FXML
        private TableColumn<?, ?> fullnameColumn;

        @FXML
        private Button homeButton;

        @FXML
        private TableColumn<?, ?> idColumn;

        @FXML
        private Label idLabel1;

        @FXML
        private Button logoutButton;

        @FXML
        private TableColumn<?, ?> quizGradeColumn;

        @FXML
        private TableView<?> subjectGradeTable;

        @FXML
        private Label subjectGradesLabel;

        @FXML

        private TableColumn<?, ?> writtenGradeColumn;

       private ObservableList<StudentGrade> subjectGrades = FXCollections.observableArrayList();


        public StudentRecord(){
            super("Dummy", "password", "Dummy");
             firstname = "Dummy";
              middlename = "Dummy";
               lastname = "Dummy";
                fullname = "Dummy Dummy Dummy";
                 idnum = "0000-0000";
                  course = "BS Dummy Dummy";
         }

     

        //constructor functions
         public StudentRecord ( String fname, String mname, String lname, String funame, String id, String cour, String username, String password, String role){
            super(username, password, role);
             firstname = fname;
              middlename = mname;
               lastname = lname;
                fullname = funame;
                 idnum = id;
                  course = cour;


                  }
         public void addGrade(String subject, float writtenGrade, float writtenWeightage, float quizGrade, float quizWeightage, float examGrade, float examWeightage){

             StudentGrade studentGrade = new StudentGrade(subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeightage);

             subjectGrades.add(studentGrade);

         }
        public void createButtonClicked(ActionEvent event) throws IOException{

         //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InputData-Scene.fxml"));
            Parent root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

                 stage.setTitle("Class Grades");
        }

        public void homeButtonClicked(ActionEvent event) throws IOException{

         //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherInterface.fxml"));
            Parent root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

                stage.setTitle("Student Grade Tracker");
        }

        public void logoutButtonClicked(ActionEvent event) throws IOException{

            //WIll open the grade inputting scene;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-Scene.fxml"));
                Parent root = loader.load();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                stage.setTitle("");
        }




        public String getFirstname() {return firstname;}
        public String getLastname(){return  lastname;}
        public String getIdnum(){ return idnum; }
        public  String getFullname(){ return fullname;}

        public StringProperty getfnameProperty(){
           StringProperty fname = new SimpleStringProperty(firstname);
            return fname;

        }
        public StringProperty getmnameProperty(){
            StringProperty mname = new SimpleStringProperty(middlename);
             return mname;
        }
        public StringProperty getlnameProperty(){
            StringProperty lname = new SimpleStringProperty(lastname);
             return lname;
        }
        public StringProperty getidProperty(){
            StringProperty id = new SimpleStringProperty(idnum);
             return id;
        }
        public StringProperty getcourseProperty(){
            StringProperty cours = new SimpleStringProperty(course);
             return cours;
        }
}
