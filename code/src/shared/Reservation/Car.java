package shared.Reservation;

import javafx.beans.property.*;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private String make;
    private String model;
    private String color;
    private String numberPlates;
    private String fuelType;
    private String fuelConsumption;
    private String seats;
    private String engine;
    private String transmission;
    private String equipment;
    private String description;
    private int branchId;
    private double dailyPrice;

    public Car(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberPlates = numberPlates;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.equipment = equipment;
        this.description = description;
        this.branchId = branchId;
        this.dailyPrice = dailyPrice;
    }


    public int getId() {
        return id;
    }

    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public StringProperty makeProperty() {
        return new SimpleStringProperty(make);
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public StringProperty modelProperty() {
        return new SimpleStringProperty(model);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public StringProperty colorProperty() {
        return new SimpleStringProperty(color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumberPlates() {
        return numberPlates;
    }

    public StringProperty numberPlatesProperty() {
        return new SimpleStringProperty(numberPlates);
    }

    public void setNumberPlates(String numberPlates) {
        this.numberPlates = numberPlates;
    }

    public String getFuelType() {
        return fuelType;
    }

    public StringProperty fuelTypeProperty() {
        return new SimpleStringProperty(fuelType);
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public StringProperty fuelConsumptionProperty() {
        return new SimpleStringProperty(fuelConsumption);
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getSeats() {
        return seats;
    }

    public StringProperty seatsProperty() {
        return new SimpleStringProperty(seats);
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getEngine() {
        return engine;
    }

    public StringProperty engineProperty() {
        return new SimpleStringProperty(engine);
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public StringProperty transmissionProperty() {
        return new SimpleStringProperty(transmission);
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEquipment() {
        return equipment;
    }

    public StringProperty equipmentProperty() {
        return new SimpleStringProperty(equipment);
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public StringProperty descriptionProperty() {
        return new SimpleStringProperty(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBranchId() {
        return branchId;
    }

    public IntegerProperty branchIdProperty() {
        return new SimpleIntegerProperty(branchId);
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public DoubleProperty dailyPriceProperty() {
        return new SimpleDoubleProperty(dailyPrice);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", numberPlates='" + numberPlates + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                ", seats='" + seats + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", equipment='" + equipment + '\'' +
                ", description='" + description + '\'' +
                ", branchId=" + branchId +
                '}';
    }
}
