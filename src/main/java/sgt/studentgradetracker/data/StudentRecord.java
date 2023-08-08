package sgt.studentgradetracker.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class StudentRecord {
    protected StringProperty firstname;
    protected StringProperty middlename;
    protected StringProperty lastname;
    protected StringProperty fullname;
    protected StringProperty idnum;
    protected StringProperty course;
    private ObservableList<StudentGrade> subjectGrades = FXCollections.observableArrayList();
    private ArrayList<User> users = new ArrayList<User>();

    public StudentRecord(){
        //null
    }


    public StudentRecord(String fname, String mname, String lname, String funame, String id, String cour) {
        firstname = new SimpleStringProperty(fname.toUpperCase());
        middlename = new SimpleStringProperty(mname.toUpperCase());
        lastname = new SimpleStringProperty(lname.toUpperCase());
        fullname = new SimpleStringProperty(funame.toUpperCase());
        idnum = new SimpleStringProperty(id);
        course = new SimpleStringProperty(cour.toUpperCase());
        String username = firstname.get() + "." + lastname.get();
        User user = new User(username.toLowerCase(), "password", "Student", this); // Pass 'this' as the associated StudentRecord
        users.add(user);
    }

    public StudentRecord(String fname, String mname, String lname, String funame, String id, String cour, String username, String password, String role) {
        firstname = new SimpleStringProperty(fname.toUpperCase());
        middlename = new SimpleStringProperty(mname.toUpperCase());
        lastname = new SimpleStringProperty(lname.toUpperCase());
        fullname = new SimpleStringProperty(funame.toUpperCase());
        idnum = new SimpleStringProperty(id);
        course = new SimpleStringProperty(cour.toUpperCase());
        User user = new User(username, password, role, this); // Pass 'this' as the associated StudentRecord
        users.add(user);
    }

    public void addGrade(String idnum, String subject, float writtenGrade, float writtenWeightage, float quizGrade, float quizWeightage, float examGrade, float examWeightage) {
        StudentGrade studentGrade = new StudentGrade(idnum, subject, writtenGrade, writtenWeightage, quizGrade, quizWeightage, examGrade, examWeightage);
        subjectGrades.add(studentGrade);

    }

    public String getFirstname() {
        return firstname.get();
    }

    public String getLastname() {
        return lastname.get();
    }

    public String getMiddlename() {
        return middlename.get();
    }

    public String getIdnum() {
        return idnum.get();
    }

    public String getFullname() {
        return fullname.get();
    }

    public String getCourse() {
        return course.get();
    }


    public StringProperty getfnameProperty() {
        return firstname;

    }

    public StringProperty getmnameProperty() {
        return middlename;
    }

    public StringProperty getlnameProperty() {
        return lastname;
    }

    public StringProperty getidProperty() {
        return idnum;
    }

    public StringProperty getcourseProperty() {
        return course;
    }

    public StringProperty getfullnameProperty() {
        return fullname;
    }

    public ObservableList<StudentGrade> getSubjectGrades() {

        return subjectGrades;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


}
