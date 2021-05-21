package client.viewmodel;

import client.model.DataModel;
import client.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Reservation.Car;

import java.beans.PropertyChangeSupport;

public class CarViewModel {

    private Model model;
    private PropertyChangeSupport support;
    private IntegerProperty id;
    private StringProperty make;
    private StringProperty carModel;
    private StringProperty numberPlates;
    private StringProperty fuelType;
    private StringProperty fuelConsumption;
    private StringProperty seats;
    private StringProperty engine;
    private StringProperty transmission;
    private StringProperty equipment;
    private StringProperty description;
    private StringProperty branch;
    private StringProperty dailyPrice;




    public CarViewModel(Model model) {
        this.model = model;
        support = new PropertyChangeSupport(this);
        id = new SimpleIntegerProperty();
        make = new SimpleStringProperty();
        carModel = new SimpleStringProperty();
        numberPlates = new SimpleStringProperty();
        fuelType = new SimpleStringProperty();
        fuelConsumption = new SimpleStringProperty();
        seats = new SimpleStringProperty();
        engine = new SimpleStringProperty();
        transmission = new SimpleStringProperty();
        equipment = new SimpleStringProperty();
        description = new SimpleStringProperty();
        branch = new SimpleStringProperty();
        dailyPrice = new SimpleStringProperty();
    }

    public IntegerProperty idProperty () {
        return id;
    }

    public StringProperty makeProperty() {
        return make;
    }

    public StringProperty carModelProperty() {
        return carModel;
    }

    public StringProperty numberPlatesProperty () {
        return numberPlates;
    }

    public StringProperty fuelTypeProperty () {
        return fuelType;
    }

    public StringProperty fuelConsumptionProperty () {
        return fuelConsumption;
    }

    public StringProperty seatsProperty () {
        return seats;
    }

    public StringProperty engineProperty () {
        return engine;
    }

    public StringProperty transmissionProperty () {
        return transmission;
    }

    public StringProperty equipmentProperty () {
        return equipment;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty branchProperty () {
        return branch;
    }

    public StringProperty dailyPrice () {
        return dailyPrice;
    }





}
