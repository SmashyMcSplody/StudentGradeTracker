package sgt.studentgradetracker;

import java.util.Scanner;

public class Teacher {
    protected String TeacherUser;
    protected String TeacherPass;
    public static void main(String[] args){
        Input test = new Input();
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, Would you like to input new student's record? Y/N");
        char program = input.next().charAt(0);
        
        if (program == 'y' || program == 'Y'){
            int j = 0;
            test.toInput();
            System.out.println(test.StudentRecord.get(j).toString());

            for(int i = 0; i < test.StudentRecord.get(j).subjectGrades.size(); i++){
                     System.out.print(test.StudentRecord.get(j).subjectGrades.get(i).gradeOutput());
            }
         j++;

          System.out.println("\nWould you like to create another student's record? Y/N");
         program = input.next().charAt(0);
             while (program == 'y' || program == 'Y'){
                 int i = 0;
                    test.toInput();
                     System.out.print(test.StudentRecord.get(i).toString());
                      for(j = 0 ;  j <test.StudentRecord.get(i).subjectGrades.size(); j++ ){
                        System.out.print(test.StudentRecord.get(i).subjectGrades.get(j).gradeOutput());}
                       i++;
                         System.out.println(" Would you like to create another student's record? Y/N");
                         program = input.next().charAt(0);
            
             } 
             System.out.println("All created records: ");
             for( int i = 0 ; i < test.StudentRecord.size(); i++){
                System.out.println(test.StudentRecord.get(i).dataRecord());
                 for(j = 0; j < test.StudentRecord.get(i).subjectGrades.size(); j++){
                  System.out.println(test.StudentRecord.get(i).subjectGrades.get(j).gradeOutput());
                 }
                 

             }
        }
        else{
            System.out.print("Test Failed");
        }
        
      }
}