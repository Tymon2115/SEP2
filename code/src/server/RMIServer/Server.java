package server.RMIServer;

import client.model.Model;
import client.network.Client;
import shared.Branch.Branch;
import shared.Reservation.*;
import shared.personel.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface Server extends Remote {
    void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, Client client, double price, String email, String phoneNumber) throws RemoteException;

    void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException;

    void getReservation(int searchId, Client client) throws RemoteException;

    void deleteReservation(int reservationId) throws RemoteException;

    void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException;

    void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException;

    void getEmployee(int searchId, Client client) throws RemoteException;

    void deleteEmployee(int employeeId) throws RemoteException;

    void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void getCar(int searchId, Client client) throws RemoteException;

    void deleteCar(int carId) throws RemoteException;

    void createBranch(String name, String location) throws RemoteException;

    void getBranch(int id, Client client) throws RemoteException;

    void editBranch(int id, String name, String location) throws RemoteException;

    void deleteBranch(int branchId) throws RemoteException;

    void login(String username, String password, Client client) throws RemoteException;

    void getReservations(Client client) throws RemoteException;

    void getBranches(Client client) throws RemoteException;

    void getCars(Client client) throws RemoteException;

    void getEmployees(Client client) throws RemoteException;
}
