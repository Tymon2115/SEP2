package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Reservation.Car;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * ViewModel for displaying car information
 * @author adam
 */
public class CarViewModel {

    private Model model;
    private ViewHandler viewHandler;
    private ObservableList<Car> cars;


    /**
     * Instantiates a new Car view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public CarViewModel(Model model, ViewHandler viewHandler) {
        cars = FXCollections.observableArrayList();
        this.model = model;
        this.viewHandler = viewHandler;
        model.addListener(this::listenForCars, "cars");
    }

    /**
     * Listen for cars.
     *
     * @param event the event
     */
    public void listenForCars(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            cars.clear();

            ArrayList<Car> receivedCars = (ArrayList<Car>) event.getNewValue();
            cars.addAll(receivedCars);
        });
    }


    /**
     * Home.
     */
    public void home() {
        viewHandler.openFrontPageView();
    }

    /**
     * Add car.
     */
    public void addCar() {

        viewHandler.openAddCarView();
        model.getBranches();
    }

    /**
     * Gets cars.
     *
     * @return the cars
     */
    public ObservableList<Car> getCars() {
        return cars;
    }

    /**
     * Open add car view.
     */
    public void openAddCarView () {
        viewHandler.openAddCarView();
    }

    /**
     * Open edit view.
     *
     * @param selectedCar the selected car
     */
    public void openEditView (Car selectedCar) {
        viewHandler.openCarEditView(selectedCar);
    }

    /**
     * Delete action.
     *
     * @param id the id
     */
    public void deleteAction (int id) {
        model.deleteCar(id);
        model.getCars();
    }
}
