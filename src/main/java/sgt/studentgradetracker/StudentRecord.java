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
                   //Student Grade input
                System.out.print("Would you like to input the student's grade? Y/N ");
                char identifier = input.next().charAt(0);

                  if (identifier == 'Y' || identifier == 'y'){
                   System.out.print("Please enter the amount of subjects: ");
                   int subjectNum = input.nextInt();
                      int i = 0;

                     while( i < subjectNum){
                       System.out.print("Please then enter the subject:  ");
                        input.nextLine();
                         String subject = input.nextLine();
                          System.out.print("Please enter the subject's weightage of Quizzes Grade in the Final Grade: ");
                           float quizWeightage = input.nextInt();
                            System.out.print("Please then enter the student's Grade in Quizzes: ");
                             float quizGrade = input.nextInt();
                              System.out.print("Over the total grade of: ");
                               float quizTotal = input.nextInt();
                                System.out.print("Please enter the subject's weightage of Written Works Grade in the Final Grade: ");
                                 float writtenWeightage = input.nextInt();
                                  System.out.print("Please enter the student's Grade in Written Works: ");
                                   float writtenGrade = input.nextInt();
                                    System.out.print("Over the total grade of: ");
                                     float writtenTotal = input.nextInt();
                                      System.out.print("Please enter the subject's weightage of Exam Grade in the Final Grade: ");
                                       float examWeightage = input.nextInt();
                                        System.out.print("Please enter the student's Grade in Exams: ");
                                         float examGrade = input.nextInt();
                                          System.out.print("Over the total grade of: ");
                                           float examTotal = input.nextInt();

                                            StudentGrade studentsGrade = new StudentGrade(subject, quizGrade, quizWeightage, quizTotal, writtenGrade, writtenWeightage, writtenTotal, examGrade, examWeightage, examTotal); 
                                             subjectGrades.add(studentsGrade);
                                i++;
                         
                         
                               }
                       }
                       else{ 
                             StudentGrade studentsGrade = new StudentGrade();
                             subjectGrades.add(studentsGrade);
                       }

             }
                   
             

             public String toString(){
                return "Successfully created a record for student " +idnum +" " +fullname +" under the course" +course ;
             }
             public String dataRecord(){
                return "Student: " +fullname +":  " +idnum +" Course  " +course;
             }
             
             public String getFirstname(){
               return firstname;
             }
             public String getLastname(){
               return lastname;
             }
    
}
