package client.model;

import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.beans.PropertyChangeEvent;
import java.sql.Date;

public interface Model extends PropertyChangeSubject {

    void createReservation(Reservation reservation);

    void editReservation();

    void receiveReservation(PropertyChangeEvent event);

    void deleteReservation(Reservation reservation);

    void createEmployee(String name, String surname, int id, Branch branch);

    void editEmployee();

    void receiveEmployee(PropertyChangeEvent event);

    void deleteEmployee(Employee employee);

    void createManager(String name, String surname, int id, Branch branch);

    void editManager();

    void receiveManager(PropertyChangeEvent event);

    void deleteManager(Employee employee);

    void createCar(Car car);

    void editCar(Car car);

    void receiveCar(PropertyChangeEvent event);

    void deleteCar(Car car);

    void createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager);

    void editBranch();

    void receiveBranch(PropertyChangeEvent event);

    void deleteBranch(Branch branch);

    void login(String username, String password);

}
