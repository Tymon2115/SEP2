package shared.Reservation;

import javafx.beans.property.*;
import shared.Branch.Branch;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String driversLicence;
    private Address address;
    private Car car;
    private Branch startBranch;
    private Branch endBranch;
    private Date startDate;
    private Date endDate;
    private double price;
    private String email;
    private String phoneNumber;


    public Reservation(int id, String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, java.sql.Date startDate, Date endDate, double price, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.driversLicence = driversLicence;
        this.address = address;
        this.car = car;
        this.startBranch = startBranch;
        this.endBranch = endBranch;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDriversLicence() {
        return driversLicence;
    }

    public Address getAddress() {
        return address;
    }

    public Car getCar() {
        return car;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDriversLicence(String driversLicence) {
        this.driversLicence = driversLicence;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Branch getStartBranch() {
        return startBranch;
    }

    public void setStartBranch(Branch startBranch) {
        this.startBranch = startBranch;
    }

    public Branch getEndBranch() {
        return endBranch;
    }

    public void setEndBranch(Branch endBranch) {
        this.endBranch = endBranch;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public StringProperty surnameProperty() {
        return new SimpleStringProperty(surname);
    }

    public StringProperty driversLicenseProperty() {
        return new SimpleStringProperty(driversLicence);
    }

    public StringProperty addressProperty() {
        return new SimpleStringProperty(address.toString());
    }

    public StringProperty carProperty() {
        return new SimpleStringProperty(car.getNumberPlates());
    }

    public StringProperty startBranchProperty() {
        return new SimpleStringProperty(startBranch.getName());
    }

    public StringProperty endBranchProperty() {
        return new SimpleStringProperty(endBranch.getName());
    }

    public StringProperty startDateProperty() {
        return new SimpleStringProperty(startDate.toString());
    }
    public StringProperty endDateProperty() {
        return new SimpleStringProperty(endDate.toString());
    }

    public DoubleProperty priceProperty() {
        return new SimpleDoubleProperty(price);
    }

    public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }

    public StringProperty phoneNumberProperty() {
        return new SimpleStringProperty(phoneNumber);
    }
}

