module sgt.studentgradetracker {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens sgt.studentgradetracker to javafx.fxml;
    exports sgt.studentgradetracker;
}