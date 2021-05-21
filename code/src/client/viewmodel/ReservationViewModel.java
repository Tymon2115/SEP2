package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReservationViewModel {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty driversLicense;
    private StringProperty address;
    private StringProperty car;
    private StringProperty startBranch;
    private StringProperty endBranch;
    private StringProperty startDate;
    private StringProperty endDate;
    private StringProperty price;
    private StringProperty email;
    private StringProperty phone;
    private Model model;
    private ViewHandler viewHandler;

    public ReservationViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
    }

    public void home(){
        viewHandler.openFrontPageView();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getDriversLicense() {
        return driversLicense.get();
    }

    public StringProperty driversLicenseProperty() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense.set(driversLicense);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCar() {
        return car.get();
    }

    public StringProperty carProperty() {
        return car;
    }

    public void setCar(String car) {
        this.car.set(car);
    }

    public String getStartBranch() {
        return startBranch.get();
    }

    public StringProperty startBranchProperty() {
        return startBranch;
    }

    public void setStartBranch(String startBranch) {
        this.startBranch.set(startBranch);
    }

    public String getEndBranch() {
        return endBranch.get();
    }

    public StringProperty endBranchProperty() {
        return endBranch;
    }

    public void setEndBranch(String endBranch) {
        this.endBranch.set(endBranch);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public String getEndDate() {
        return endDate.get();
    }

    public StringProperty endDateProperty() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate.set(endDate);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
