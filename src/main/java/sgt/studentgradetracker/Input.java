package sgt.studentgradetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Input extends Teacher{
//declarations
         ArrayList<StudentRecord> StudentRecord = new ArrayList<StudentRecord>();
         Scanner input = new Scanner(System.in);
               
         public void toInput(){
            //Student Name input
            System.out.print("Please input the student's firstname: ");
            String fname = input.nextLine(); 
             input.nextLine();
              System.out.print("Please input the student's middlename: ");
               String mname = input.nextLine();
                System.out.print("Please input the student's lastname: ");
                 String lname = input.nextLine();
                  System.out.println("The students full name is: " +fname +" " +mname +" " +lname);
                   String fullname = fname +" " +mname +" " +lname;

            //Student Data input
                    System.out.print("Please input the student's idnumber: ");
                     String idnum = input.nextLine();
                      System.out.print("Please input the student's course: ");
                       String course = input.nextLine();
                        System.out.println("Student " + fullname +" with ID Number of: " +idnum +" Under the course of " +course);
                        
                              StudentRecord student = new StudentRecord(fname, mname, lname, fullname, idnum, course);
                               StudentRecord.add(student);
         }
}    

