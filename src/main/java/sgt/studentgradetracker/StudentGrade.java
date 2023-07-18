package sgt.studentgradetracker;

public class StudentGrade {

    protected String subject;
    protected float QuizGrade;
    protected float ExamGrade;
    protected float WrittenGrade;
    protected float FinalGrade;


         public StudentGrade(){
            QuizGrade = 0;
             ExamGrade = 0;
               WrittenGrade = 0;
                FinalGrade = 0;
            }
            
         public StudentGrade(String subject, float qGrade, float qWeightage, float qTotal, float wGrade, float wWeightage, float wTotal, float eGrade, float eWeightage, float eTotal){
           this.subject = subject;

            QuizGrade = (qGrade/qTotal) * 100;
             ExamGrade = eGrade/eTotal * 100;
               WrittenGrade = wGrade/wTotal *100;
                FinalGrade = (qGrade * (qWeightage/100)) + (eGrade * (eWeightage/100)) + (wGrade * (wWeightage/100));
            }
            
            public String gradeOutput(){
              return "\n Student's grades in Subject: "+subject +" \n Quiz Grade: " +QuizGrade +" Exam Grade: " +ExamGrade +" Written Grade: " +WrittenGrade +" Over-all Final Grade:  " +FinalGrade ;
            }
            public String gradeRecord(){
              return "Quiz Grade: " +QuizGrade +" Exam Grade: " +ExamGrade +" Written Grade: " +WrittenGrade +" Over-all Final Grade:  " +FinalGrade ;
            }
}
