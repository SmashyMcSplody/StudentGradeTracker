//package sgt.studentgradetracker;
//
//import javafx.collections.ObservableList;
//import java.util.ArrayList;
//
//public class SampleRecordDeclare {
//    private ArrayList<SampleRecord> studentList;
//
//    public SampleRecordDeclare() {
//        studentList = new ArrayList<>();
//        studentList.add(new SampleRecord("Elisha John", "Dingal", "Aton", "2022-0956", "1st year BS-CpE","elishajohn.aton","password","student"));
//        studentList.add(new SampleRecord("Nassem", "Layatan", "Maruhom", "2022-0690", "FACULTY BS-CpE","nassem.maruhom","password","teacher"));
//        studentList.add(new SampleRecord("Joshvan", "Monteon", "Balcos", "2022-0069", "FACULTY BS-CS","joshvan.balcos","password","teacher"));
//
//        // Creating a Subject
//        SampleSubjects subject1 = new SampleSubjects("Math", "83");
//        SampleSubjects subject2 = new SampleSubjects("English", "98");
//
//        // Adding subjects to the SampleRecord's subjects list
//        studentList.get(0).addSubject(subject1);
//        studentList.get(0).addSubject(subject2);
//
//        // Getting the subjects list from the SampleRecord
//        ObservableList<SampleSubjects> subjects = studentList.get(0).getSubjects();
//
//    }
//
//    public ArrayList<SampleRecord> getStudentList() {
//        return studentList;
//    }
//}
