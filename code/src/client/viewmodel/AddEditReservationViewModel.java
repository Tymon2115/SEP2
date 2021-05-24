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
    public StringProperty nameProperty () {
        return name;
    }

    public StringProperty surnameProperty ()  {
        return surname;
    }

    public StringProperty driversLicenceProperty() {
        return driversLicence;
    }

    public StringProperty addressStreetProperty () {
        return addressStreet;
    }

    public StringProperty addressZipProperty(){
        return addressZip;
    }

    public StringProperty addressCityProperty(){
        return addressCity;
    }

    public StringProperty addressCountryProperty () {
        return addressCountry;
    }

    public StringProperty priceProperty () {
        return price;
    }

    public StringProperty emailProperty () {
        return email;
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public StringProperty carProperty () {
        return car;
    }

    public StringProperty startBranchProperty () {
        return startBranch;
    }

    public StringProperty endBranchProperty () {
        return endBranch;
    }

    public ObjectProperty<LocalDate> startDateProperty () {
        return startDate;
    }

    public ObjectProperty<LocalDate> endDateProperty () {
        return endDate;
    }

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

    public ObservableList<String> getCars() {
        return cars;
    }

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
        else if (name.get().length() > 800) {
            message.set("Please input a name with a maximum of 800 characters");
            return false;
        }
        else if (surname.get().length() > 40) {
            message.set("Please input a surname with a maximum of 40 characters");
            return false;
        }
        else if (driversLicence.get().length() > 50) {
            message.set("Please input a drivers licence ID with a maximum of 50 characters");
            return false;
        }
        else if (addressStreet.get().length() > 100) {
            message.set("Please input a street with a maximum of 100 characters");
            return false;
        }
        else if (addressCity.get().length() > 100) {
            message.set("Please input a city with a maximum of 100 characters");
            return false;
        }
        else if (addressZip.get().length() > 12) {
            message.set("Please input a ZIP with a maximum of 12 characters");
            return false;
        }
        else if (startDate.get().isAfter(endDate.get())) {
            message.set("Start date cannot be later than the end date");
            return false;
        }


        else {
            return true;
        }
    }

    public void cancelAction () {
        viewHandler.openReservationView();
    }

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
