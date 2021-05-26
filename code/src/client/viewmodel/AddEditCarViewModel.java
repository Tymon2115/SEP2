package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * ViewModel for adding and editing the car
 * @author Tymon
 */
public class AddEditCarViewModel {


    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;
    private ObservableList<String> branches;


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
    private StringProperty branch;
    private StringProperty message;


    /**
     * Instantiates a new Add edit car view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public AddEditCarViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;

        this.support = new PropertyChangeSupport(this);
        model.addListener(this::listenForBranches, "branches");
        model.getBranches();
        branches = FXCollections.observableArrayList();


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

        branch = new SimpleStringProperty();
        message = new SimpleStringProperty();
    }

    private void listenForBranches(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {

            branches.clear();
            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) propertyChangeEvent.getNewValue();
            ArrayList<String> receivedBranchNumbers = new ArrayList<>();
            for (Branch receivedBranch : receivedBranches) {
                receivedBranchNumbers.add(String.valueOf(receivedBranch.getId()));
            }
            branches.addAll(receivedBranchNumbers);

        });
    }

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<String> getBranches() {
        return branches;

    }

    /**
     * Make property string property.
     *
     * @return the string property
     */
    public StringProperty makeProperty() {
        return make;
    }


    /**
     * Car model property string property.
     *
     * @return the string property
     */
    public StringProperty carModelProperty() {
        return carModel;
    }


    /**
     * Color property string property.
     *
     * @return the string property
     */
    public StringProperty colorProperty() {
        return color;
    }


    /**
     * Number plates property string property.
     *
     * @return the string property
     */
    public StringProperty numberPlatesProperty () {
        return numberPlates;
    }


    /**
     * Fuel type property string property.
     *
     * @return the string property
     */
    public StringProperty fuelTypeProperty() {
        return fuelType;
    }


    /**
     * Fuel consumption property string property.
     *
     * @return the string property
     */
    public StringProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }


    /**
     * Seats property string property.
     *
     * @return the string property
     */
    public StringProperty seatsProperty() {
        return seats;
    }


    /**
     * Engine property string property.
     *
     * @return the string property
     */
    public StringProperty engineProperty() {
        return engine;
    }


    /**
     * Transmission property string property.
     *
     * @return the string property
     */
    public StringProperty transmissionProperty() {
        return transmission;
    }


    /**
     * Equipment property string property.
     *
     * @return the string property
     */
    public StringProperty equipmentProperty() {
        return equipment;
    }


    /**
     * Description property string property.
     *
     * @return the string property
     */
    public StringProperty descriptionProperty () {
        return description;
    }

    /**
     * Daily price property string property.
     *
     * @return the string property
     */
    public StringProperty dailyPriceProperty () {
        return dailyPrice;
    }

    /**
     * Branch property string property.
     *
     * @return the string property
     */
    public StringProperty branchProperty () {
        return branch;
    }

    /**
     * Message property string property.
     *
     * @return the string property
     */
    public StringProperty messageProperty () {
        return message;
    }


    private boolean inputVerification () {
        if (make.get() == null || make.get().equals("")) {
            message.setValue("Please input make");
            return false;
        }
        else if (carModel.get() == null || carModel.get().equals("")) {
            message.setValue("Please input model");
            return false;
        }
        else if (color.get() == null || color.get().equals("")) {
            message.setValue("Please input color");
            return false;
        }
        else if (numberPlates.get() == null || numberPlates.get().equals("")) {
            message.setValue("Please input number plates ");
            return false;
        }
        else if (fuelType.get() == null || fuelType.get().equals("")) {
            message.setValue("Please input fuel type");
            return false;
        }
        else if (fuelConsumption.get() == null || fuelConsumption.get().equals("")) {
            message.setValue("Please input fuel consumption");
            return false;
        }
        else if (seats.get() == null || seats.get().equals("")) {
            message.setValue("Please input seats");
            return false;
        }
        else if (engine.get() == null || engine.get().equals("")) {
            message.setValue("Please input engine");
            return false;
        }
        else if (transmission.get() == null || transmission.get().equals("")) {
            message.setValue("Please input transmission");
            return false;
        }
        else if (equipment.get() == null || equipment.get().equals("")) {
            message.setValue("Please input equipment");
            return false;
        }
        else if (description.get() == null || description.get().equals("")) {
            message.setValue("Please input description");
            return false;
        }
        else if (dailyPrice.get() == null || dailyPrice.get().equals("")) {
            message.setValue("Please input daily price");
            return false;
        }
        else if (branch.get() == null || branch.get().equals("")) {
            branch.setValue("Please input branch");
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Add action.
     */
    public void addAction () {
        if (inputVerification()) {
            model.createCar(make.get(),
                    carModel.get(),
                    color.get(),
                    numberPlates.get(),
                    fuelType.get(),
                    fuelConsumption.get(),
                    seats.get(),
                    engine.get(),
                    transmission.get(),
                    equipment.get(),
                    description.get(),
                    Integer.parseInt(branch.get()),
                    Double.parseDouble(dailyPrice.get()));

                    model.getCars();
                    viewHandler.openCarView();

                    carModel.set("");
                    color.set("");
                    numberPlates.set("");
                    fuelType.set("");
                    fuelConsumption.set("");
                    seats.set("");
                    engine.set("");
                    transmission.set("");
                    equipment.set("");
                    description.set("");
                    dailyPrice.set("");
        }
        else {
            //shouldn't do anything
        }


    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        viewHandler.openCarView();
    }

    /**
     * Edit action.
     *
     * @param id the id
     */
    public void editAction (int id) {
      if (inputVerification()){
          model.editCar(
                  id,
                  make.get(),
                  carModel.get(),
                  color.get(),
                  numberPlates.get(),
                  fuelType.get(),
                  fuelConsumption.get(),
                  seats.get(),
                  engine.get(),
                  transmission.get(),
                  equipment.get(),
                  description.get(),
                  Integer.parseInt(branch.get()),
                  Double.parseDouble(dailyPrice.get())
          );
          model.getCars();
          viewHandler.openCarView();
          make.set("");
          carModel.set("");
          color.set("");
          numberPlates.set("");
          fuelType.set("");
          fuelConsumption.set("");
          seats.set("");
          engine.set("");
          transmission.set("");
          equipment.set("");
          description.set("");
          branch.set("");
          dailyPrice.set("");
      }
        else {
            //shouldn't do anything
        }
    }



}
