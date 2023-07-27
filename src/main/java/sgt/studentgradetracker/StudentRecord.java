package sgt.studentgradetracker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class StudentRecord{
    protected String firstname;
    protected String middlename;
    protected String lastname;
    protected String fullname;
    protected String idnum;
    protected String course;
    private ObservableList<StudentGrade> subjectGrades = FXCollections.observableArrayList();

     public StudentRecord(){
         firstname = "null";
          middlename = "null";
           lastname = "null";
            fullname = "null";
              idnum = "null";
               course = "null";
     }

        //constructor functions
         public StudentRecord ( String fname, String mname, String lname, String funame, String id, String cour){
             firstname = fname;
              middlename = mname;
               lastname = lname;
                fullname = funame;
                 idnum = id;
                  course = cour;
                  }
         public void addGrade(String subject, float writtenGrade, float writtenWeightage, float quizGrade, float quizWeightage, float examGrade, float examWeightage){
             StudentGrade studentGrade = new StudentGrade(this.idnum, subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeightage);
             subjectGrades.add(studentGrade);

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
