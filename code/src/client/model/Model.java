package client.model;

import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.sql.Date;

public interface Model extends PropertyChangeSubject {

    void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date);

    void editReservation();

    void addReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

    void createEmployee(String name, String surname, int id, Branch branch);

    void editEmployee();

    void addEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void createManager(String name, String surname, int id, Branch branch);

    void editManager();

    void addManager(Manager manager);

    void deleteManager(Manager manager);

    void createCar(int id, String make, String model, String color, String numberPlates);

    void editCar();

    void addCar(Car car);

    void deleteCar(Car car);

    void createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager);

    void editBranch();

    void addBranch(Branch branch);

    void deleteBranch(Branch branch);


}
