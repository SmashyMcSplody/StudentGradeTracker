package sgt.studentgradetracker;

import java.util.ArrayList;

public class SampleRecordDeclare {
    private ArrayList<SampleRecord> studentList;

    public SampleRecordDeclare() {
        studentList = new ArrayList<>();
        studentList.add(new SampleRecord("Elisha John", "2022-0956"));
        studentList.add(new SampleRecord("Nassem", "2022-0690"));
    }

    public ArrayList<SampleRecord> getStudentList() {
        return studentList;
    }
}