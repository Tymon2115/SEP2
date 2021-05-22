package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import shared.Reservation.Address;

import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.time.LocalDate;

public class AddEditReservationViewModel {
    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;


    //TODO im not sure if this is the right way to bind a combo box and a date


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
        this.viewHandler = viewHandler;
        this.support = new PropertyChangeSupport(this);
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

    public void cancelAction () {
        //TODO go back to list view
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
        }
        else {
            //shouldn't do anything
        }

    }

    public void editAction () {
        if (inputVerification()){
            //TODO call model to edit and go back to list
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
