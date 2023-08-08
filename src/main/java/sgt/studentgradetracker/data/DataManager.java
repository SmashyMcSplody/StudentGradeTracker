package sgt.studentgradetracker.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DataManager {

    protected String fname;
    protected String lname;
    protected String mname;
    protected String fullname;
    protected String idnum;
    protected String course;

    private int studentNumber;
    protected ObservableList<StudentRecord> studentRecords =  FXCollections.observableArrayList();
    public   ArrayList<StudentRecord> teacherRecords = new ArrayList<StudentRecord>();


    public void addGrades(String idnumGrades, String subject, float writtenGrade, float writtenWeightage, float quizGrade, float quizWeightage, float examGrade, float examWeight){
        studentRecords.get(studentNumber).addGrade(idnumGrades, subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeight);
    }
    public void addStudent(StudentRecord student){
        studentRecords.add(student);
    }

    public String duplicateChecker(String fname, String lname, String mname, String idnum) {
        String duplicateCheck = "No Duplicate";
        for(StudentRecord records : studentRecords){
            if(idnum.equals(records.getIdnum())){
                duplicateCheck = "Duplicate Found";
            }
            if(fname.toUpperCase().equals(records.getFirstname()) && lname.toUpperCase().equals(records.getLastname()) && mname.toUpperCase().equals(records.getMiddlename())){
                duplicateCheck = "Duplicate Found";
                break;
            }
        }
        return duplicateCheck;
    }

    public String findStudentbyIdNum(String idnumGrades){
        String studentChecker = "Does not Exist";
        studentNumber = 0;
        for(StudentRecord records : studentRecords){
            if (idnumGrades.equals(records.getIdnum())){
                studentChecker = "Exists";
                break;
            }
            studentNumber++;
        }
        return studentChecker;
    }
}
