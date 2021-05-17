package shared.Reservation;

import shared.Branches.Branch;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String driversLicence;
    private Address address;
    private String creditCardNumber;
    private Car car;
    private Branch startBranch;
    private Branch endBranch;
    private Date startDate;
    private Date endDate;


    public Reservation(int id, String name, String surname, String driversLicence, Address address, String creditCardNumber, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.driversLicence = driversLicence;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.car = car;
        this.startBranch = startBranch;
        this.endBranch = endBranch;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Car getCar() {
        return car;
    }

    public int getId() {
        return id;
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

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

