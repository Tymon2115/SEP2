package shared.Branches;

import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employees;
import shared.personel.Manager;

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

    public void createReservation() {

    }

    public void editReservation() {

    }

    public void deleteReservation() {

    }

    public Reservation getReservation(int id) {

    }

    public void addCar() {

    }

    public void deleteCar() {

    }

    public void editCar() {

    }

    public void getCar(int id) {

    }
    public void addEmployee(){

    }
    public void editEmployee(){

    }
}
