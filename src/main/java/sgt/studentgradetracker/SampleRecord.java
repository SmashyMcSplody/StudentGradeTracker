package sgt.studentgradetracker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleRecord extends User {
    private StringProperty fname;
    private StringProperty mname;
    private StringProperty lname;
    private StringProperty id;
    private StringProperty course;

    private String username;
    private String password;
    private String role;
    private ObservableList<SampleSubjects> subjects;

    public SampleRecord(String fname, String mname, String lname, String id, String course, String username, String password, String role) {
       super(username, password, role);
        this.fname = new SimpleStringProperty(fname);
        this.mname = new SimpleStringProperty(mname);
        this.lname = new SimpleStringProperty(lname);
        this.id = new SimpleStringProperty(id);
        this.course = new SimpleStringProperty(course);
        this.username = username;
        this.password = password;
        this.role = role;
        this.subjects = FXCollections.observableArrayList();
    }

    //Getter and Setter Methods for user
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    // Getter and Setter methods for fname property
    public String getFname() {
        return fname.get();
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public StringProperty fnameProperty() {
        return fname;
    }

    // Getter and Setter methods for mname property
    public String getMname() {
        return mname.get();
    }

    public void setMname(String mname) {
        this.mname.set(mname);
    }

    public StringProperty mnameProperty() {
        return mname;
    }

    // Getter and Setter methods for lname property
    public String getLname() {
        return lname.get();
    }

    public void setLname(String lname) {
        this.lname.set(lname);
    }

    public StringProperty lnameProperty() {
        return lname;
    }

    // Getter and Setter methods for id property
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    // Getter and Setter methods for course property
    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public StringProperty courseProperty() {
        return course;
    }
    // Getter and methods for subjects property
    public ObservableList<SampleSubjects> getSubjects() {
        return subjects;
    }

    public void addSubject(SampleSubjects subject) {
        subjects.add(subject);
    }

    public void removeSubject(SampleSubjects subject) {
        subjects.remove(subject);
    }
}
