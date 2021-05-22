package client.viewmodel;

import client.core.ViewHandler;
import client.model.DataModel;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Reservation.Car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class EmployeeViewModel {
    private final ViewHandler viewHandler;
    private Model model;


    public EmployeeViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;

        this.viewHandler = viewHandler;
        model.addListener(this::listenForEmployees, "employees");
        model.getEmployees();
    }

    private void listenForEmployees(PropertyChangeEvent event) {
        Platform.runLater(() -> {

        });

    }

    public void home() {
        viewHandler.openFrontPageView();
    }


}
