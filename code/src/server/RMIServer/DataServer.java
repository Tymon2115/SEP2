package server.RMIServer;

import client.network.Client;
import server.database.CarHandler;
import shared.Branches.Branch;
import shared.Reservation.*;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class DataServer implements Server {

    public DataServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void createReservation(int id, String name, String surname, String driversLicence, Address address , Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, Client client, double price) throws RemoteException {
        Reservation reservation = new Reservation(id, name, surname, driversLicence, address, car, startBranch, endBranch, startDate, endDate, price);
        //todo there will be some database bullshit and then reservation will be made
        try {
            client.reservationCallback();
            System.out.println(reservation.getName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editReservation() throws RemoteException {

    }

    @Override
    public void addReservation(Reservation reservation) throws RemoteException {

    }

    @Override
    public void deleteReservation(Reservation reservation) throws RemoteException {

    }

    @Override
    public Employee createEmployee(String name, String surname, int id, Branch branch) throws RemoteException {
        return new Employee(name, surname, id, branch);
    }

    @Override
    public void editEmployee() throws RemoteException {

    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException {

    }

    @Override
    public void deleteEmployee(Employee employee) throws RemoteException {

    }

    @Override
    public Manager createManager(String name, String surname, int id, Branch branch) throws RemoteException {
        return new Manager(name, surname, id, branch);
    }

    @Override
    public void editManager() throws RemoteException {

    }

    @Override
    public void addManager(Manager manager) throws RemoteException {

    }

    @Override
    public void deleteManager(Manager manager) throws RemoteException {

    }

    @Override
    public Car createCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description) throws RemoteException {
        return new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description);
    }

    @Override
    public void editCar() throws RemoteException {

    }

    @Override
    public void addCar(Car car) throws RemoteException {

    }

    @Override
    public void deleteCar(Car car) throws RemoteException {

    }

    @Override
    public Branch createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) throws RemoteException {
        return new Branch(name, location, reservations, cars, manager);
    }

    @Override
    public Branch createBranch(int id, String name, String location) {
        return new Branch(id, name, location);
    }

    @Override
    public void editBranch() throws RemoteException {

    }

    @Override
    public void addBranch(Branch branch) throws RemoteException {

    }

    @Override
    public void deleteBranch(Branch branch) throws RemoteException {

    }
}
