package sgt.studentgradetracker;

import java.util.ArrayList;

public class SampleRecordDeclare {
    private ArrayList<SampleRecord> studentList;

    public SampleRecordDeclare() {
        studentList = new ArrayList<>();
        studentList.add(new SampleRecord("Elisha John", "Dingal", "Aton", "2022-0956", "BS-CpE"));
        studentList.add(new SampleRecord("Nassem", "Layatan", "Aton", "2022-0690", "BS-CpE"));
    }

    public ArrayList<SampleRecord> getStudentList() {
        return studentList;
    }
}