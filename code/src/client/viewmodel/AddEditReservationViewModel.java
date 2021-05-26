package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.Reservation.Address;
import shared.Reservation.Car;
import shared.Reservation.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * ViewModel for adding and editing the reservation
 * @author adam
 */
public class AddEditReservationViewModel {
    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;
    private ObservableList<String> branches;
    private ObservableList<String> cars;



    private StringProperty name;
    private StringProperty surname;
    private StringProperty driversLicence;
    private StringProperty addressStreet;
    private StringProperty addressZip;
    private StringProperty addressCity;
    private StringProperty addressCountry;
    private StringProperty price;
    private StringProperty email;
    private StringProperty phoneNumber;
    private StringProperty car;
    private StringProperty startBranch;
    private StringProperty endBranch;
    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;
    private StringProperty message;


    /**
     * Instantiates a new Add edit reservation view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public AddEditReservationViewModel (Model model, ViewHandler viewHandler) {
        this.model = model;
        model.addListener(this::listenForBranches, "branches");
        model.addListener(this::listenForCars, "cars");
        model.getBranches();
        model.getCars();
        this.viewHandler = viewHandler;
        branches = FXCollections.observableArrayList();
        cars = FXCollections.observableArrayList();

        name = new SimpleStringProperty();
        surname = new SimpleStringProperty();
        driversLicence = new SimpleStringProperty();
        addressCity = new SimpleStringProperty();
        addressStreet = new SimpleStringProperty();
        addressZip = new SimpleStringProperty();
        addressCountry = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phoneNumber = new SimpleStringProperty();
        startBranch = new SimpleStringProperty();
        price = new SimpleStringProperty();
        car = new SimpleStringProperty();
        endBranch = new SimpleStringProperty();
        startDate = new SimpleObjectProperty<>();
        endDate = new SimpleObjectProperty<>();
        message = new SimpleStringProperty();
    }

    /**
     * Name property string property.
     *
     * @return the string property
     */
    public StringProperty nameProperty () {
        return name;
    }

    /**
     * Surname property string property.
     *
     * @return the string property
     */
    public StringProperty surnameProperty ()  {
        return surname;
    }

    /**
     * Drivers licence property string property.
     *
     * @return the string property
     */
    public StringProperty driversLicenceProperty() {
        return driversLicence;
    }

    /**
     * Address street property string property.
     *
     * @return the string property
     */
    public StringProperty addressStreetProperty () {
        return addressStreet;
    }

    /**
     * Address zip property string property.
     *
     * @return the string property
     */
    public StringProperty addressZipProperty(){
        return addressZip;
    }

    /**
     * Address city property string property.
     *
     * @return the string property
     */
    public StringProperty addressCityProperty(){
        return addressCity;
    }

    /**
     * Address country property string property.
     *
     * @return the string property
     */
    public StringProperty addressCountryProperty () {
        return addressCountry;
    }

    /**
     * Price property string property.
     *
     * @return the string property
     */
    public StringProperty priceProperty () {
        return price;
    }

    /**
     * Email property string property.
     *
     * @return the string property
     */
    public StringProperty emailProperty () {
        return email;
    }

    /**
     * Phone number property string property.
     *
     * @return the string property
     */
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    /**
     * Car property string property.
     *
     * @return the string property
     */
    public StringProperty carProperty () {
        return car;
    }

    /**
     * Start branch property string property.
     *
     * @return the string property
     */
    public StringProperty startBranchProperty () {
        return startBranch;
    }

    /**
     * End branch property string property.
     *
     * @return the string property
     */
    public StringProperty endBranchProperty () {
        return endBranch;
    }

    /**
     * Start date property object property.
     *
     * @return the object property
     */
    public ObjectProperty<LocalDate> startDateProperty () {
        return startDate;
    }

    /**
     * End date property object property.
     *
     * @return the object property
     */
    public ObjectProperty<LocalDate> endDateProperty () {
        return endDate;
    }

    /**
     * Message property string property.
     *
     * @return the string property
     */
    public StringProperty messageProperty () {
        return message;
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

    private void listenForCars(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {

            cars.clear();

            ArrayList<Car> receivedCars = (ArrayList<Car>) propertyChangeEvent.getNewValue();
            ArrayList<String> receivedCarNumbers = new ArrayList<>();
            for (Car receivedCar : receivedCars) {
                receivedCarNumbers.add(String.valueOf(receivedCar.getId()));
            }
            cars.addAll(receivedCarNumbers);

        });
    }

    /**
     * Gets cars.
     *
     * @return the cars
     */
    public ObservableList<String> getCars() {
        return cars;
    }

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<String> getBranches() {
        return branches;
    }



    private boolean inputVerification() {

        if (name.get() == null || name.get().equals("")) {

            message.setValue("Please input name");

            return false;
        }
        else if (surname.get() == null || surname.get().equals("")) {
            message.setValue("Please input surname");
            return false;
        }
        else if (driversLicence.get() == null || driversLicence.get().equals("")) {
            message.setValue("Please input drivers licence");
            return false;
        }
        else if (addressStreet.get() == null || addressStreet.get().equals("")) {
            message.setValue("Please input street");
            return false;
        }
        else if (addressZip.get() == null || addressZip.get().equals("")) {
            message.setValue("Please input zip");
            return false;
        }
        else if (addressCity.get() == null || addressCity.get().equals("")) {
            message.setValue("Please input city");
            return false;
        }
        else if (addressCountry.get() == null || addressCountry.get().equals("")) {
            message.setValue("Please input country");
            return false;
        }
        else if (price.get() == null || price.get().equals("")) {
            message.setValue("Please input price");
            return false;
        }
        else if (email.get() == null || email.get().equals("")) {
            message.setValue("Please input email");
            return false;
        }
        else if (phoneNumber.get() == null || phoneNumber.get().equals("")) {
            message.setValue("Please input phone number");
            return false;
        }
        else if (car.get() == null || car.get().equals("")) {
            message.setValue("Please input car");
            return false;
        }
        else if (startBranch.get() == null || startBranch.get().equals("")) {
            message.setValue("Please input start branch");
            return false;
        }
        else if (endBranch.get() == null || endBranch.get().equals("")) {
            message.setValue("Please input end branch");
            return false;
        }
        else if (startDate.get() == null) {
            message.setValue("Please input start date");
            return false;
        }
        else if (endDate.get() == null) {
            message.setValue("Please input end date");
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        viewHandler.openReservationView();
    }

    /**
     * Add action.
     */
    public void addAction () {
        if (inputVerification()){
            model.createReservation(name.get(),
                    surname.get(),
                    driversLicence.get(),
                    new Address(addressStreet.get(), addressZip.get(), addressCity.get(), addressCountry.get()),
                    Integer.parseInt(car.get()),
                    Integer.parseInt(startBranch.get()),
                    Integer.parseInt(endBranch.get()),
                    getSQLDateFromStartDate(),
                    getSQLDateFromEndDate(),
                    Double.valueOf(price.get()),
                    email.get(),
                    phoneNumber.get());

                    model.getReservations();
                    viewHandler.openReservationView();
                    name.set("");
                    surname.set("");
                    driversLicence.set("");
                    addressStreet.set("");
                    addressZip.set("");
                    addressCity.set("");
                    addressCountry.set("");
                    email.set("");
                    phoneNumber.set("");
                    price.set("");

        }
        else {

        }

    }

    /**
     * Edit action.
     *
     * @param id the id
     */
    public void editAction (int id) {
        if (inputVerification()){
                model.editReservation(
                        id,
                        name.get(),
                        surname.get(),
                        driversLicence.get(),
                        new Address(addressStreet.get(), addressCity.get(), addressZip.get(), addressCountry.get()),
                        Integer.parseInt(car.get()),
                        Integer.parseInt(startBranch.get()),
                        Integer.parseInt(endBranch.get()),
                        getSQLDateFromStartDate(),
                        getSQLDateFromEndDate(),
                        Double.parseDouble(price.get()),
                        email.get(),
                        phoneNumber.get()
                );
                model.getReservations();
                viewHandler.openReservationView();
                name.set("");
                surname.set("");
                driversLicence.set("");
                addressCity.set("");
                addressStreet.set("");
                addressZip.set("");
                addressCountry.set("");
                car.set("");
                startBranch.set("");
                endBranch.set("");
                startDate.set(null);
                endDate.set(null);
                price.set("");
                email.set("");
                phoneNumber.set("");
        }
        else {
            //shouldn't do anything
        }
    }

    private Date getSQLDateFromStartDate () {
        java.sql.Date date = Date.valueOf(startDate.getValue());
        return date;
    }

    private Date getSQLDateFromEndDate () {
        java.sql.Date date = Date.valueOf(endDate.getValue());
        return date;
    }

}
