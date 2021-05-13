package client.model;

import client.network.Client;
import client.network.DataClient;
import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import javax.xml.crypto.Data;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;

public class DataModel implements Model, PropertyChangeSubject {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private DataClient client;

    public DataModel(DataClient client) {
        this.client = client;
        client.addListener(this::receiveBranch, "branch");
        client.addListener( this::receiveCar, "car");
        client.addListener( this::receiveEmployee, "employee");
        client.addListener( this::receiveManager, "manager");
        client.addListener( this::receiveReservation, "reservation");
    }

    @Override

    public void createReservation(int id, String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) {
        client.createReservation(id, name, surname, driversLicence, address, creditCardNumber, car, branch, date);
    }

    @Override
    public void editReservation() {

    }

    @Override
    public void receiveReservation(PropertyChangeEvent event) {
        System.out.println("speaking from model");
        System.out.println(event.getNewValue());
    }


    @Override
    public void deleteReservation(Reservation reservation) {

    }

    @Override
    public void createEmployee(String name, String surname, int id, Branch branch) {

    }

    @Override
    public void editEmployee() {

    }

    @Override
    public void receiveEmployee(PropertyChangeEvent event) {

    }


    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public void createManager(String name, String surname, int id, Branch branch) {

    }

    @Override
    public void editManager() {

    }

    @Override
    public void receiveManager(PropertyChangeEvent event) {

    }


    @Override
    public void deleteManager(Manager manager) {

    }

    @Override
    public void createCar(int id, String make, String model, String color, String numberPlates) {

    }

    @Override
    public void editCar() {

    }

    @Override
    public void receiveCar(PropertyChangeEvent event) {

    }


    @Override
    public void deleteCar(Car car) {

    }

    @Override
    public void createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) {

    }

    @Override
    public void editBranch() {

    }

    @Override
    public void receiveBranch(PropertyChangeEvent event) {

    }


    @Override
    public void deleteBranch(Branch branch) {

    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void addListener(PropertyChangeListener listener, String name) {

    }
}
