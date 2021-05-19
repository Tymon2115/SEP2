package client.model;

import client.network.Client;
import client.network.DataClient;
import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

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
        client.addListener(this::receiveManager, "manager");
        client.addListener(this::receiveReservation, "reservation");
    }

    @Override

    public void createReservation(Reservation reservation) {
        client.createReservation(reservation);
    }

    @Override
    public void editReservation() {
        client.editReservation();
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
    public void createEmployee(String name, String surname, int id, Branch branch) {
        client.createEmployee(name, surname, id, branch);
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
    public void createManager(String name, String surname, int id, Branch branch) {
        client.createManager(name, surname, id, branch);
    }

    @Override
    public void editManager() {

    }

    @Override
    public void receiveManager(PropertyChangeEvent event) {
        support.firePropertyChange("manager", null, event.getNewValue());
    }


    @Override
    public void deleteManager(Manager manager) {
        client.deleteManager(manager);
    }

    @Override
    public void createCar(Car car) {

    }

    @Override
    public void editCar(Car car) {

    }

//    @Override
//    public void createCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description) {
//        try {
//            client.createCar(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void receiveCar(PropertyChangeEvent event) {
        support.firePropertyChange("car", null, event.getNewValue());
    }


    @Override
    public void deleteCar(Car car) {
        client.deleteCar(car);
    }

    @Override
    public void createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) {
        client.createBranch(name, location, employees, reservations, cars, manager);
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
       client.login(username,password);
    }

    @Override
    public void addListener(PropertyChangeListener listener, String name) {
        support.addPropertyChangeListener(name, listener);
    }
}
