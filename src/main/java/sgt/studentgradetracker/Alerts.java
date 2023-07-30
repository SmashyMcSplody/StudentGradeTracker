package sgt.studentgradetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Alerts {
    @FXML
    private Label nameLabel;
    @FXML
    private Label idnumLabel;

    private Stage stage;
    private Scene scene;

    public Alerts(){

    }
    public void loginErrorAlert()throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginErrorAlert.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);

    }


    public void invalidInputAlert()throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvalidInputGradeAlert.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);


    }
    public void invalidGradeAlert()throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvalidGradeAlert.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);


    }
    public void incompleteInputAlert()throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IncompleteInputAlert.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);

    }

    public void nullStudentAlert()throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvalidIDAlert.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);

    }
    public void duplicateAlert() throws IOException {
        // Will open the grade inputting scene;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DuplicateAlert.fxml"));
        Parent root = loader.load();

        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);

    }
    public void invalidWeightageAlert() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvalidWeightage.fxml"));
        Parent root = loader.load();

        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Error!");
        stage.setResizable(false);
    }
    public void successRecordAlert(String fullname)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordSuccessAlert.fxml"));
        Parent root = loader.load();


        Alerts controller = loader.getController();

        controller.setFullname(fullname.toUpperCase());

        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Success!");
        stage.setResizable(false);

    }
    public void successGradeAlert(String idnum)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GradeSuccessAlert.fxml"));
        Parent root = loader.load();

        Alerts controller = loader.getController();

        controller.setIdnum(idnum);

        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Success!");
        stage.setResizable(false);

    }

    @FXML
    private void handleCloseButtonClicked(ActionEvent event) {
        // Get the reference to the Stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Close the Stage (window)
        stage.close();
    }


    public void setFullname(String fullname) {
        nameLabel.setText(fullname);
    }
    public void setIdnum(String idnum) {
        idnumLabel.setText(idnum);
    }
}
