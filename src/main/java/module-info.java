module sgt.studentgradetracker {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens sgt.studentgradetracker to javafx.fxml;
    exports sgt.studentgradetracker;
    exports sgt.studentgradetracker.controllers;
    opens sgt.studentgradetracker.controllers to javafx.fxml;
    exports sgt.studentgradetracker.data;
    opens sgt.studentgradetracker.data to javafx.fxml;
}