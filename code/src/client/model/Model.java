package client.model;

import shared.Branch.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.util.ArrayList;

public interface Model extends PropertyChangeSubject {


    void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber);

    void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber);

    void receiveReservation(PropertyChangeEvent event);

    void receiveReservations(PropertyChangeEvent event);

    void receiveCars(PropertyChangeEvent event);

    void receiveBranches(PropertyChangeEvent event);

    void receiveEmployees(PropertyChangeEvent event);

    void deleteReservation(int reservationId);


    void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email);


    void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email);

    void receiveEmployee(PropertyChangeEvent event);

    void deleteEmployee(int employeeId);

    void createCar(String make, String carModel, String color, String numberPlates, String fuelType,
                   String fuelConsumption, String seats, String engine, String transmission, String equipment,
                   String description, int branchId, double dailyPrice);

    void editCar(int id, String make, String carModel, String color, String numberPlates, String fuelType,
                 String fuelConsumption, String seats, String engine, String transmission, String equipment,
                 String description, int branchId, double dailyPrice);

    void receiveCar(PropertyChangeEvent event);

    void deleteCar(int carId);

    void createBranch(String name, String location);

    void editBranch(int id, String name, String location);

    void receiveBranch(PropertyChangeEvent event);

    void deleteBranch(int branchId);

    void login(String username, String password);

    void receiveLogin(PropertyChangeEvent event);

    void getBranch(int id);

    void getCar(int id);

    void getEmployee(int id);

    void getReservation(int id);

    void getReservations();

    void getBranches();

    void getCars();

    void getEmployees();

    void register(Employee employee);

}
