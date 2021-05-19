package server.RMIServer;

import client.network.Client;
import shared.Branches.Branch;
import shared.Reservation.*;
import shared.personel.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface Server extends Remote {
    void createReservation(String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, Client client, double price) throws RemoteException;

    void editReservation() throws RemoteException;

    void getReservation(int searchId, Client client) throws RemoteException

    void deleteReservation(Reservation reservation) throws RemoteException;

    void createEmployee(String name, String surname, int roleId, Branch branch, String username, String password, String email) throws RemoteException;

    void editEmployee() throws RemoteException;

    void getEmployee(int searchId, Client client) throws RemoteException;

    void deleteEmployee(Employee employee) throws RemoteException;

    void createCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void editCar() throws RemoteException;

    void getCar(int searchId, Client client) throws RemoteException;

    void deleteCar(Car car) throws RemoteException;

    void createBranch(String name, String location) throws RemoteException;

    void editBranch() throws RemoteException;

    void deleteBranch(Branch branch) throws RemoteException;

    void login(String username, String password, Client client);
}
