//To filter the population in a JavaFX TableView through a search bar, you can use a FilteredList combined with a Predicate. Here's a step-by-step guide on how to achieve this:
//
//  1.        Create a TextField for the search bar in your FXML file. Let's assume you have a search bar with the ID "searchField".
//  2.        In your controller class (e.g., StudentInterfaceController or TeacherInterfaceController), create a FilteredList and bind it to the original data list (e.g., sampleSubjects or sampleRecords).
//  3.        Set up a listener on the search bar to update the FilteredList based on the text input.
//        Here's an example implementation for filtering a list of SampleSubjects in StudentInterfaceController:

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentInterfaceController {
    @FXML
    private TableView<SampleSubjects> tableView;

    @FXML
    private TableColumn<SampleSubjects, String> subjectColumn;

    @FXML
    private TableColumn<SampleSubjects, String> gradeColumn;

    @FXML
    private TextField searchField;

    // The original list of subjects
    private ObservableList<SampleSubjects> sampleSubjects;

    // The filtered list based on the search bar input
    private FilteredList<SampleSubjects> filteredSubjects;

    // Other code for initializing the table view and columns...

    @FXML
    public void initialize() {
        // Assume you have initialized sampleSubjects with data

        // Create the filtered list and bind it to the original list
        filteredSubjects = new FilteredList<>(sampleSubjects, p -> true);

        // Set the data to be displayed in the TableView
        tableView.setItems(filteredSubjects);

        // Define how the columns will get their data from the SampleSubjects objects
        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());

        // Add a listener to the search bar to update the filtered list based on the search input
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredSubjects.setPredicate(subject -> {
                // If the search bar is empty, show all subjects
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Convert the search input to lowercase for case-insensitive filtering
                String lowerCaseFilter = newValue.toLowerCase();

                // Check if the subject name or grade contains the search input
                return subject.getName().toLowerCase().contains(lowerCaseFilter)
                        || subject.getGrade().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }

    // Other methods...
}

//In this example, when you start typing in the search bar, the table view will automatically filter the subjects whose names or grades contain the input text. It performs a case-insensitive search, so the search is not case-sensitive.
//
//        You can apply a similar approach to other controllers and data models, such as TeacherInterfaceController with SampleRecord objects. The key idea is to use a FilteredList and a Predicate to dynamically update the displayed items based on the search input.