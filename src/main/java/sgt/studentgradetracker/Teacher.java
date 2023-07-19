package sgt.studentgradetracker;

import java.util.Scanner;

public class Teacher {
    protected String TeacherUser;
    protected String TeacherPass;
    public static void main(String[] args){
        Input teacherInput = new Input();
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, Would you like to input new student's record? Y/N");
        char program = input.next().charAt(0);
        
        if (program == 'y' || program == 'Y'){
            int j = 0;
              teacherInput.toInput();
                System.out.println(teacherInput.StudentRecord.get(j).toString());
                  for(int i = 0; i < teacherInput.StudentRecord.get(j).subjectGrades.size(); i++){
                      System.out.print(teacherInput.StudentRecord.get(j).subjectGrades.get(i).gradeOutput());
                   }
                 j++;
         
        //RE INPUTTING SYSTEM
             System.out.println("\nWould you like to create another student's record? Y/N");
              program = input.next().charAt(0);
             
           //INPUTTING LOOP
              while (program == 'y' || program == 'Y'){
                int i = 0;
                  i++;
                    teacherInput.toInput();
                    //DUPLICATE CHECKING
                     if (teacherInput.duplicateChecker()  == 1){
                          teacherInput.reInput();
                     } 
                     //CREATED RECORD PRINTER

                      System.out.println(teacherInput.StudentRecord.get(i).toString());
                         for(j = 0 ;  j <teacherInput.StudentRecord.get(i).subjectGrades.size(); j++ ){
                             System.out.println(teacherInput.StudentRecord.get(i).subjectGrades.get(j).gradeOutput());
                         }
                          System.out.println(" Would you like to create another student's record? Y/N");
                            program = input.next().charAt(0);
                }
            

             //ALL CREATED RECORDS PRINTER
                 System.out.println("All created records: ");
                  teacherInput.recordPrinter();
        }

        else{
            System.out.print("Test Failed");
        }


    }
      
} 