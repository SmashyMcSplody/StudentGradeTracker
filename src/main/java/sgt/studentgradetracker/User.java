package sgt.studentgradetracker;

public class User extends StudentRecord{
    protected String username;
    protected String password;
    protected String role;

    public User(){
        username = "null";
        password = "null";

    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
    public String getUserFullname(){
        String userFullname = getFullname();
        return userFullname;
    }

}
