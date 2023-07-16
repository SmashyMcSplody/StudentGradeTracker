package sgt.studentgradetracker;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class TeacherInterfaceControler {
    @FXML
    private void AnalyticButtonClicked(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("example");
        alert.setHeaderText(null);
        alert.setContentText("Button Clicked");
        alert.showAndWait();
    }
}
