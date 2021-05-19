package client.model;

import client.network.Client;
import client.network.DataClient;
import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;


import javax.xml.crypto.Data;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.Date;

public class DataModel implements Model, PropertyChangeSubject {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private DataClient client;

    public DataModel(DataClient client) {
        this.client = client;
        client.addListener(this::receiveBranch, "branch");
        client.addListener(this::receiveCar, "car");
        client.addListener(this::receiveEmployee, "employee");
        client.addListener(this::receiveReservation, "reservation");
        client.addListener(this::receiveLogin, "login");
    }

    @Override

    public void createReservation(int id, String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, double price) {
        client.createReservation(id, name, surname, driversLicence, address, car, startBranch, endBranch, startDate, endDate, price);
    }

    @Override
    public void editReservation() {

    }

    @Override
    public void receiveReservation(PropertyChangeEvent event) {
        support.firePropertyChange("reservation", null, event.getNewValue());
        System.out.println(event.getNewValue());
    }


    @Override
    public void deleteReservation(Reservation reservation) {
        client.deleteReservation(reservation);
    }

    @Override
    public void createEmployee(String name, String surname, int roleId, Branch branch, String username, String password, String email) {
        client.createEmployee(name, surname, roleId, branch, username, password, email);
    }

    @Override
    public void editEmployee() {
        client.editEmployee();
    }

    @Override
    public void receiveEmployee(PropertyChangeEvent event) {
        support.firePropertyChange("employee", null, event.getNewValue());
    }


    @Override
    public void deleteEmployee(Employee employee) {
        client.deleteEmployee(employee);
    }


    @Override

    public void editManager() {

    }

    @Override
    public void receiveManager(PropertyChangeEvent event) {
        support.firePropertyChange("manager", null, event.getNewValue());
    }



    @Override
    public void createCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description,int branchId, double dailyPrice) {
        client.createCar(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);

    }

    @Override
    public void editCar() {

    }

    @Override
    public void receiveCar(PropertyChangeEvent event) {
        support.firePropertyChange("car", null, event.getNewValue());
    }


    @Override
    public void deleteCar(Car car) {
        client.deleteCar(car);
    }


    @Override
    public void createBranch(int id, String name, String location) {
        client.createBranch(id, name, location);
    }

    @Override
    public void editBranch() {

    }

    @Override
    public void receiveBranch(PropertyChangeEvent event) {
        support.firePropertyChange("branch", null, event.getNewValue());
    }


    @Override
    public void deleteBranch(Branch branch) {
        client.deleteBranch(branch);
    }

    @Override
    public void login(String username, String password) {
        try {
            client.login(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receiveLogin(PropertyChangeEvent event) {
        support.firePropertyChange("login", null, event.getNewValue());
    }

    @Override
    public void addListener(PropertyChangeListener listener, String name) {
        support.addPropertyChangeListener(name, listener);
    }
}
