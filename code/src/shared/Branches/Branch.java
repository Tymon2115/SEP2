package shared.Branches;

import client.exceptions.DoesNotExist;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class Branch {
    private int id;
    private String name;
    private String location;
    private Employees employees;
    private Reservations reservations;
    private Cars cars;
    private Manager manager;

    public Branch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) {
        this.name = name;
        this.location = location;
        this.employees = employees;
        this.reservations = reservations;
        this.cars = cars;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Employees getEmployees() {
        return employees;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public Cars getCars() {
        return cars;
    }

    public Manager getManager() {
        return manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void addReservation(Reservation reservation) throws Exception {
        reservations.addReservation(reservation);
    }

    public void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) throws Exception {
        reservations.addReservation(new Reservation(name, surname, driversLicence, address, creditCardNumber, car, branch, date));
    }

    public void editReservation(Reservation reservation, ArrayList<String> properties) {
        reservations.editReservation(reservation, properties);
    }

    public void deleteReservation(Reservation reservation) {
        try {
            reservations.deleteReservation(reservation);
        } catch (DoesNotExist doesNotExist) {
            doesNotExist.printStackTrace();
        }
    }

    public Reservation getReservation(int id) {
        try {
            return reservations.getReservation(id);
        } catch (DoesNotExist doesNotExist) {
            doesNotExist.printStackTrace();
        }
        return null;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public void editCar(Car car, ArrayList<String> properties) {
        cars.editCar(car, properties);
    }

    public Car getCar(int id) {
        return cars.getCar(id);
    }

    public void addEmployee(Employee employee) {
        try {
            employees.addEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editEmployee(Employee employee, ArrayList<String> properties) {
        employees.editEmployee(employee, properties);
    }

    public void deleteEmployee(Employee employee) {
        try {
            employees.deleteEmployee(employee);
        } catch (DoesNotExist doesNotExist) {
            doesNotExist.printStackTrace();
        }
    }
}
