package sgt.studentgradetracker.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgt.studentgradetracker.data.DataManager;
import sgt.studentgradetracker.data.StudentRecord;
import sgt.studentgradetracker.data.User;

import java.io.IOException;

public class SettingController extends DataManager {

    @FXML
    private Label studentIDLabel;

    @FXML
    private Label studentcourseLabel;

    @FXML
    private Label studentnameLabel;

    @FXML
    private TextField studentnewPassConfirmField;

    @FXML
    private TextField studentnewPassField;

    @FXML
    private TextField studentoldPassField;
    private  User user;

    // Method to set the User object (You can remove this if not needed anymore)
    public void setUser(User userLogin) {
        if (userLogin != null) {
            user = userLogin;
            // Assuming you have a 'getFullname' method in StudentRecord
            String fullname = user.getFullname();
            studentnameLabel.setText(fullname);

            // Assuming you have a 'getIdnum' method in StudentRecord
            String idnum = user.getIdnum();
            studentIDLabel.setText(idnum);

            // Assuming you have a 'getCourse' method in StudentRecord
            String course = user.getCourse();
            studentcourseLabel.setText(course);

        } else {
            studentnameLabel.setText("Null");
            studentIDLabel.setText("Null");
            studentcourseLabel.setText("Null");
        }
    }

    public void initialize(ObservableList<StudentRecord> studentRecords){
        super.initialize(studentRecords);
    }





    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sgt/studentgradetracker/Login-Scene.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.initialize(studentRecords);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("");
    }




}
