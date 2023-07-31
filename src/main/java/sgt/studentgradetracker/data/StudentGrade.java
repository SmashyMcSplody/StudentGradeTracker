package sgt.studentgradetracker.data;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class StudentGrade extends StudentRecord{

    protected StringProperty subject;
    protected FloatProperty quizGrade;
    protected FloatProperty examGrade;
    protected FloatProperty writtenGrade;
    protected FloatProperty finalGrade;
    protected StringProperty idnum;


         public StudentGrade(String id,String subject, float wGrade, float wWeightage, float qGrade, float qWeightage,  float eGrade, float eWeightage){
           idnum = new SimpleStringProperty(id.toUpperCase());
            this.subject = new SimpleStringProperty(subject.toUpperCase());
             writtenGrade =  new SimpleFloatProperty(Math.round(wGrade* (wWeightage/100)));
               quizGrade =  new SimpleFloatProperty(Math.round(qGrade * (qWeightage/100)));
                 examGrade =  new SimpleFloatProperty(Math.round(eGrade* (eWeightage/100)));
                   finalGrade = new SimpleFloatProperty(Math.round((wGrade* (wWeightage/100)) +(qGrade * (qWeightage/100)) + (eGrade* (eWeightage/100))));
            }
    // Getters and setters for subject, quizGrade, examGrade, writtenGrade, and finalGrade
    // Subject getter and setter


    // QuizGrade property getter and setter
    public FloatProperty quizGradeProperty(){
        return quizGrade;
    }

    public float getQuizGrade() {
        return quizGrade.get();
    }

    public void setQuizGrade(float grade) {
        quizGrade.set(grade);
    }

    // ExamGrade property getter and setter
    public FloatProperty examGradeProperty() {
        return examGrade;
    }

    public float getExamGrade() {
        return examGrade.get();
    }

    public void setExamGrade(float grade) {
        examGrade.set(grade);
    }

    // WrittenGrade property getter and setter
    public FloatProperty writtenGradeProperty() {
        return writtenGrade;
    }

    public float getWrittenGrade() {
        return writtenGrade.get();
    }

    public void setWrittenGrade(float grade) {
        writtenGrade.set(grade);
    }

    // FinalGrade property getter and setter
    public FloatProperty finalGradeProperty() {
        return finalGrade;
    }

    public float getFinalGrade() {
        return finalGrade.get();
    }

    public void setFinalGrade(float grade) {
        finalGrade.set(grade);
    }

    public StringProperty subjectProperty(){ return subject;}
    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String idnum) {
        this.subject.set(String.valueOf(subject));
    }
    public StringProperty idnumProperty(){ return idnum;}
    public String getIdnum() {
        return idnum.get();
    }

    public void setIdnum(String idnum) {
        this.idnum.set(idnum);
    }



}


