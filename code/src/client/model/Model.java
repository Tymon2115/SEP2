package client.model;

import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.sql.Date;

public interface Model extends PropertyChangeSubject {

    void createReservation(int id, String name, String surname, String driversLicence, Address address, String creditCardNumber, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate);

    void editReservation();

    void receiveReservation(PropertyChangeEvent event);

    void deleteReservation(Reservation reservation);

    void createEmployee(String name, String surname, int roleId, Branch branch, String username, String password);

    void editEmployee();

    void receiveEmployee(PropertyChangeEvent event);

    void deleteEmployee(Employee employee);

    void editManager();

    void receiveManager(PropertyChangeEvent event);

    void createCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId);

    void editCar();

    void receiveCar(PropertyChangeEvent event);

    void deleteCar(Car car);


    void createBranch(int id, String name, String location);

    void editBranch();

    void receiveBranch(PropertyChangeEvent event);

    void deleteBranch(Branch branch);

    void login(String username, String password);

}
