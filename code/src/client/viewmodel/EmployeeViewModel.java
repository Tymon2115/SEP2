package client.viewmodel;

import client.core.ViewHandler;
import client.model.DataModel;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class EmployeeViewModel {
    private final ViewHandler viewHandler;
    private Model model;
    private PropertyChangeSupport support;
    private StringProperty name;
    private StringProperty surname;
    private IntegerProperty id;
    private StringProperty branch;
    private StringProperty username;
    private StringProperty role;
    private StringProperty email;


    public EmployeeViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        support = new PropertyChangeSupport(this);
        name = new SimpleStringProperty();
        surname = new SimpleStringProperty();
        id = new SimpleIntegerProperty();
        branch = new SimpleStringProperty();
        username = new SimpleStringProperty();
        role = new SimpleStringProperty();
        email = new SimpleStringProperty();
        this.viewHandler = viewHandler;
        model.addListener(this::listenForEmployees, "employees");
        model.getEmployees();
    }

    private void listenForEmployees(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            System.out.println("employee view model");
        });

    }

    public void home() {
        viewHandler.openFrontPageView();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty branchProperty() {
        return branch;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty roleProperty() {
        return role;
    }

    public StringProperty emailProperty() {
        return email;
    }


}
