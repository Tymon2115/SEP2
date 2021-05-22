package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class EmployeeViewModel {
    private final ViewHandler viewHandler;
    private Model model;
    private ObservableList<Employee> employees;


    public EmployeeViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        model.addListener(this::listenForEmployees, "employees");
        employees = FXCollections.observableArrayList();
    }

    private void listenForEmployees(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            employees.clear();
            ArrayList<Employee> receivedEmployees = (ArrayList<Employee>) event.getNewValue();
            employees.addAll(receivedEmployees);
        });

    }

    public void home() {
        viewHandler.openFrontPageView();
    }


    public ObservableList<Employee> getEmployees() {
       return employees;
    }
}
