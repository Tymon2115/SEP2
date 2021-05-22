package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.Reservation.Car;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class CarViewModel {

    private Model model;
    private ViewHandler viewHandler;
    private ObservableList<Car> cars;


    public CarViewModel(Model model, ViewHandler viewHandler) {
        cars = FXCollections.observableArrayList();
        this.model = model;
        System.out.println(">model in car view model : " + model);
        model.getCars();
        this.viewHandler = viewHandler;
        model.addListener(this::listenForCars, "cars");
    }

    public void listenForCars(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            System.out.println(">CarViewModel listener");
            ArrayList<Car> receivedCars = (ArrayList<Car>) event.getNewValue();
            cars.addAll(receivedCars);
        });
    }


    public void home() {
        viewHandler.openFrontPageView();
    }

    public ObservableList<Car> getCars() {
        return cars;
    }
}
