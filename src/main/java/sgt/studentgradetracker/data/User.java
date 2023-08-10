package sgt.studentgradetracker.data;

import sgt.studentgradetracker.controllers.InputDataController;

public class User{
    private String username;
    private String password;
    private String role;
    private StudentRecord studentRecord; // Reference to the associated StudentRecord

    public User() {
        username = "null";
        password = "null";
        role = "null";
    }

    public User(String username, String password, String role, StudentRecord studentRecord) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.studentRecord = studentRecord;
    }

    public String getPassword() {
        return password;
    }

    public void  setPassword(String newpassword){ password = newpassword;}

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getUserFullname() {
        return studentRecord != null ? studentRecord.getFullname() : "Null";
    }

    public String getFullname() {
        return studentRecord != null ? studentRecord.getFullname() : "Null";
    }

    public String getIdnum() {
        return studentRecord != null ? studentRecord.getIdnum() : "Null";
    }

    public String getCourse() {
        return studentRecord != null ? studentRecord.getCourse() : "Null";
    }
}
