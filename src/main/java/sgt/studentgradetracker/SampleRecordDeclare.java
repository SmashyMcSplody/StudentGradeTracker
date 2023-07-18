package sgt.studentgradetracker;

import javafx.collections.ObservableList;
import java.util.ArrayList;

public class SampleRecordDeclare {
    private ArrayList<SampleRecord> studentList;

    public SampleRecordDeclare() {
        studentList = new ArrayList<>();
        studentList.add(new SampleRecord("Elisha John", "Dingal", "Aton", "2022-0956", "BS-CpE","student123","password","student"));
        studentList.add(new SampleRecord("Nassem", "Layatan", "Aton", "2022-0690", "BS-CpE","teacher456","password","teacher"));

        // Creating a Subject
        SampleSubjects subject1 = new SampleSubjects("Math", "A");
        SampleSubjects subject2 = new SampleSubjects("English", "B");

        // Adding subjects to the SampleRecord's subjects list
        studentList.get(0).addSubject(subject1);
        studentList.get(0).addSubject(subject2);

        // Getting the subjects list from the SampleRecord
        ObservableList<SampleSubjects> subjects = studentList.get(0).getSubjects();

    }

    public ArrayList<SampleRecord> getStudentList() {
        return studentList;
    }
}
