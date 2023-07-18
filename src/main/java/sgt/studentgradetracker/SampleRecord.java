package sgt.studentgradetracker;

import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SampleRecord {
    private final StringProperty fname;
    private final StringProperty id;

    public SampleRecord(String fname, String id){
        this.fname = new SimpleStringProperty(fname);
        this.id = new SimpleStringProperty(id);
    }

    public StringProperty fnameProperty() {
        return fname;
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getFname() {
        return fname.get();
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
