package sgt.studentgradetracker;
import javafx.beans.property.SimpleFloatProperty;
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


public class StudentRecord extends Input{
    protected String firstname;
    protected String middlename;
    protected String lastname;
    protected String fullname;
    protected String idnum;
    protected String course;

    private Scene scene;
    private Stage stage;

       private ObservableList<StudentGrade> subjectGrades = FXCollections.observableArrayList();



     

        //constructor functions
         public StudentRecord ( String fname, String mname, String lname, String funame, String id, String cour){
             firstname = fname;
              middlename = mname;
               lastname = lname;
                fullname = funame;
                 idnum = id;
                  course = cour;
                  subjectGrades = FXCollections.observableArrayList();


                  }
         public void addGrade(String subject, float writtenGrade, float writtenWeightage, float quizGrade, float quizWeightage, float examGrade, float examWeightage){

             StudentGrade studentGrade = new StudentGrade(subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeightage);

             subjectGrades.add(studentGrade);

          }
        public void createButtonClicked(ActionEvent event) throws IOException{

         //WIll open the grade inputting scene;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InputData-Scene.fxml"));
            Parent root = loader.load();
            Input inputDataController = loader.getController();
            inputDataController.initializeInput(studentRecords); // Pass the same studentRecords list
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
        public  StringProperty getcourseProperty(){
            StringProperty cours = new SimpleStringProperty(course);
             return cours;
        }

        public StringProperty getfullnameProperty(){
             StringProperty funame = new SimpleStringProperty(fullname);
             return funame;
        }


        public ObservableList<StudentGrade> getSubjectGrades() {

        return subjectGrades;
         }

}
