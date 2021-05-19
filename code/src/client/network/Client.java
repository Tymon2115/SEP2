package client.network;

import shared.Branches.Branch;
import shared.Reservation.*;
import shared.personel.Employee;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface Client extends Remote {
    void startClient() throws RemoteException, NotBoundException;

    void createReservation(String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, double price) throws RemoteException;

    void getReservation(int id) throws RemoteException;

    void reservationCallback(Reservation reservation) throws RemoteException;

    void editReservation(int id, String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, double price) throws RemoteException;

    void deleteReservation(Reservation reservation) throws RemoteException;

    void createEmployee(String name, String surname, int roleId, Branch branch, String username, String password, String email) throws RemoteException;

    void getEmployee(int id) throws RemoteException;

    void editEmployee(int id, String name, String surname, int roleId, Branch branch, String username, String password, String email) throws RemoteException;

    void employeeCallback(Employee employee) throws RemoteException;

    void deleteEmployee(Employee employee) throws RemoteException;

    void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void getCar(int id) throws RemoteException;

    void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void carCallback(Car car) throws RemoteException;

    void deleteCar(Car car) throws RemoteException;

    void createBranch(String name, String location) throws RemoteException;

    void getBranch(int id) throws RemoteException;

    void editBranch(int id, String name, String location) throws RemoteException;

    void branchCallback(Branch branch) throws RemoteException;

    void deleteBranch(Branch branch) throws RemoteException;

    void login(String username, String password) throws RemoteException;

    void loginCallback(int role) throws RemoteException;
}
