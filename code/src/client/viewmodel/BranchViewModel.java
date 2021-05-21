package client.viewmodel;

import client.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BranchViewModel {
    private StringProperty name;
    private StringProperty location;
    private IntegerProperty id;
    private Model model;

    public BranchViewModel(Model model) {
        this.model = model;
        name = new SimpleStringProperty();
        location = new SimpleStringProperty();
        id = new SimpleIntegerProperty();
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public Model getModel() {
        return model;
    }
}
