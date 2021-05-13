package server.RMIServer;

import client.network.Client;
import shared.Branches.Branch;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface Server extends Remote {
    void createReservation(String name, Client client) throws RemoteException;

    void editReservation() throws RemoteException;

    void addReservation(Reservation reservation) throws RemoteException;

    void deleteReservation(Reservation reservation) throws RemoteException;

    Employee createEmployee(String name, String surname, int id, Branch branch) throws RemoteException;

    void editEmployee() throws RemoteException;

    void addEmployee(Employee employee) throws RemoteException;

    void deleteEmployee(Employee employee) throws RemoteException;

    Manager createManager(String name, String surname, int id, Branch branch) throws RemoteException;

    void editManager() throws RemoteException;

    void addManager(Manager manager) throws RemoteException;

    void deleteManager(Manager manager) throws RemoteException;

    Car createCar(int id, String make, String model, String color, String numberPlates) throws RemoteException;

    void editCar() throws RemoteException;

    void addCar(Car car) throws RemoteException;

    void deleteCar(Car car) throws RemoteException;

    Branch createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) throws RemoteException;

    void editBranch() throws RemoteException;

    void addBranch(Branch branch) throws RemoteException;

    void deleteBranch(Branch branch) throws RemoteException;
}
