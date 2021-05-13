package client.model;

import shared.Branches.Branch;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;

public class DataModel implements Model {

    PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) {

    }

    @Override
    public void editReservation() {

    }

    @Override
    public void addReservation(Reservation reservation) {

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
    public void addEmployee(Employee employee) {

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
    public void addManager(Manager manager) {

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
    public void addCar(Car car) {

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
    public void addBranch(Branch branch) {

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
