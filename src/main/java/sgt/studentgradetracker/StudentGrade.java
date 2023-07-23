package sgt.studentgradetracker;

public class StudentGrade{
    protected String subject;
    protected float QuizGrade;
    protected float ExamGrade;
    protected float WrittenGrade;
    protected float FinalGrade;


         public StudentGrade(){
           subject = "No subject";
            QuizGrade = 0;
             ExamGrade = 0;
               WrittenGrade = 0;
                FinalGrade = 0;
            }
            
         public StudentGrade(String subject, float wGrade, float wWeightage, float qGrade, float qWeightage,  float eGrade, float eWeightage){
           this.subject = subject;

            QuizGrade = qGrade;
             ExamGrade = eGrade;
               WrittenGrade = wGrade;
                FinalGrade = (qGrade * (qWeightage/100)) + (eGrade * (eWeightage/100)) + (wGrade * (wWeightage/100));
            }
            

}
