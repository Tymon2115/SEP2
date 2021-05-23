package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AddEditCarViewModel {
    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;

    private StringProperty message;
    private StringProperty make;
    private StringProperty carModel;
    private StringProperty color;
    private StringProperty numberPlates;
    private StringProperty fuelType;
    private StringProperty fuelConsumption;
    private StringProperty seats;
    private StringProperty engine;
    private StringProperty transmission;
    private StringProperty equipment;
    private StringProperty description;
    private StringProperty dailyPrice;
    private StringProperty branchId;
    private ObservableList<String> branches;
    private ArrayList<StringProperty> inputValidation;

    public AddEditCarViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        model.addListener(this::listenForBranches, "branches");
        make = new SimpleStringProperty();
        carModel = new SimpleStringProperty();
        color = new SimpleStringProperty();
        numberPlates = new SimpleStringProperty();
        fuelType = new SimpleStringProperty();
        fuelConsumption = new SimpleStringProperty();
        seats = new SimpleStringProperty();
        engine = new SimpleStringProperty();
        transmission = new SimpleStringProperty();
        equipment = new SimpleStringProperty();
        description = new SimpleStringProperty();
        dailyPrice = new SimpleStringProperty();
        branchId = new SimpleStringProperty();
        message = new SimpleStringProperty();
        branches = FXCollections.observableArrayList();
        inputValidation = new ArrayList<>();
        addToInputValidation();
    }

    public String getMake() {
        return make.get();
    }

    public StringProperty makeProperty() {
        return make;
    }

    public String getCarModel() {
        return carModel.get();
    }

    public StringProperty carModelProperty() {
        return carModel;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public String getNumberPlates() {
        return numberPlates.get();
    }

    public StringProperty numberPlatesProperty() {
        return numberPlates;
    }

    public String getFuelType() {
        return fuelType.get();
    }

    public StringProperty fuelTypeProperty() {
        return fuelType;
    }

    public String getFuelConsumption() {
        return fuelConsumption.get();
    }

    public StringProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public String getSeats() {
        return seats.get();
    }

    public StringProperty seatsProperty() {
        return seats;
    }

    public String getEngine() {
        return engine.get();
    }

    public StringProperty engineProperty() {
        return engine;
    }

    public String getTransmission() {
        return transmission.get();
    }

    public StringProperty transmissionProperty() {
        return transmission;
    }

    public String getEquipment() {
        return equipment.get();
    }

    public StringProperty equipmentProperty() {
        return equipment;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getDailyPrice() {
        return dailyPrice.get();
    }

    public StringProperty dailyPriceProperty() {
        return dailyPrice;
    }

    public StringProperty branchIdProperty() {
        return branchId;
    }

    public ObservableList<String> getBranches() {
        return branches;
    }

    public StringProperty messageProperty() {
        return message;
    }

    private boolean inputVerification() {
        for (StringProperty stringProperty : inputValidation) {
            if (stringProperty.get() == null || stringProperty.get().equals("")) {
                message.set(stringProperty.getName() + "invalid input");
                return false;
            }
        }
        return true;
    }

    private void listenForBranches(PropertyChangeEvent event) {
        branches.clear();
        System.out.println("i got notified from add car");
        Platform.runLater(() -> {
            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) event.getNewValue();
            System.out.println(receivedBranches + "in add car");
            for (Branch receivedBranch : receivedBranches) {
                branches.add(Integer.toString(receivedBranch.getId()));
            }
        });
    }


    public void addAction() {
        if (inputVerification()) {
            model.createCar(make.get(), carModel.get(), color.get(), numberPlates.get(),
                    fuelType.get(), fuelConsumption.get(), seats.get(), engine.get(), transmission.get(),
                    equipment.get(), description.get(), Integer.parseInt(branchId.get()), Double.parseDouble(dailyPrice.get()));
        }
    }

    public void cancelAction() {
        model.getCars();
        viewHandler.openCarView();
    }

    private void addToInputValidation() {
        inputValidation.add(make);
        inputValidation.add(carModel);
        inputValidation.add(color);
        inputValidation.add(numberPlates);
        inputValidation.add(fuelType);
        inputValidation.add(fuelConsumption);
        inputValidation.add(seats);
        inputValidation.add(engine);
        inputValidation.add(transmission);
        inputValidation.add(equipment);
        inputValidation.add(description);
        inputValidation.add(dailyPrice);
    }
}
