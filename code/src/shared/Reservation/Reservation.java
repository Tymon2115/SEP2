package shared.Reservation;

import shared.Branches.Branch;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String driversLicence;
    private String address;
    private String creditCardNumber;
    private Car car;
    private Branch branch;
    private Date date;


    public Reservation(int id, String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.driversLicence = driversLicence;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.car = car;
        this.branch = branch;
        this.date = date;
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

    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Car getCar() {
        return car;
    }

    public Branch getBranch() {
        return branch;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

