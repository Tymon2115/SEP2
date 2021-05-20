package client.viewmodel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Reservation.Car;

public class CarViewModel {

    public StringProperty usernameProperty;
    private Model model;

    public CarViewModel(Model model) {
        this.model = model;
        usernameProperty = new SimpleStringProperty();
    }

    public StringProperty usernamePropertyProperty() {
        return usernameProperty;
    }

    public void addCarView(String make, Model model, String color, String numberPlates,
                           String fuelType, String fuelConsumption, String seats, String engine,
                           String transmission, String equipment, String description, int branchId, double dailyPrice) {
        model.createCar(make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);
    }

    public void deleteCarView(Car car) {
        model.deleteCar(car);
    }

    public void openEditCarView(int id, String make, Model model, String color,
                                String numberPlates, String fuelType, String fuelConsumption,
                                String seats, String engine, String transmission, String equipment,
                                String description, int branchId, double dailyPrice) {
        model.editCar(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);
    }
}
