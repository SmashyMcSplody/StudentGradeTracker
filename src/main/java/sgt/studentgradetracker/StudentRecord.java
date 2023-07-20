package sgt.studentgradetracker;

import java.util.ArrayList;
import java.util.Scanner;
public class StudentRecord{
    protected String firstname;
    protected String middlename;
    protected String lastname;
    protected String fullname;
    protected String idnum;
    protected String course;
    Scanner input = new Scanner(System.in);
    ArrayList<StudentGrade> subjectGrades = new ArrayList<StudentGrade>();

     

        //constructor functions
         public StudentRecord ( String fname, String mname, String lname, String funame, String id, String cour){
             firstname = fname;
              middlename = mname;
               lastname = lname;
                fullname = funame;
                 idnum = id;
                  course = cour;


                      StudentGrade studentsGrade = new StudentGrade();
                      subjectGrades.add(studentsGrade);
                  }
         public void addGrade(String subject, float writtenGrade, float writtenWeightage, float quizGrade, float quizWeightage, float examGrade, float examWeightage){

             StudentGrade studentGrade = new StudentGrade(subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeightage);

             subjectGrades.add(studentGrade);

         }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname(){
             return  lastname;
    }
}
