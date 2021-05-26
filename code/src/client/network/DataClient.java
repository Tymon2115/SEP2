package client.network;

import client.model.Model;
import server.RMIServer.Server;
import shared.Branch.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

public class DataClient implements Client, PropertyChangeSubject {

    private Server server;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    public DataClient() throws RemoteException {
        this.server = server;
        UnicastRemoteObject.exportObject((Client) this, 0);

    }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (Server) registry.lookup("server");
    }


    @Override
    public void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException {
        server.createReservation(name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, (Client) this, price, email, phoneNumber);
    }

    @Override
    public void getReservation(int id) throws RemoteException {
        server.getReservation(id, this);
    }

    @Override
    public void reservationCallback(Reservation reservation) {
        support.firePropertyChange("reservation", null, reservation);
    }

    @Override
    public void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException {
        server.editReservation(id, name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
    }

    @Override
    public void deleteReservation(int reservationId) {
        try {
            server.deleteReservation(reservationId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) {
        try {
            server.createEmployee(name, surname, roleId, branchId, username, password, email);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getEmployee(int id) throws RemoteException {
        server.getEmployee(id, this);
    }

    @Override
    public void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException {
        server.editEmployee(id, name, surname, roleId, branchId, username, password, email);
    }

    @Override
    public void employeeCallback(Employee employee) {
        support.firePropertyChange("employee", null, employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            System.out.println("Data client");
            server.deleteEmployee(employeeId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void createCar(String make, String carModel, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) {
        try {
            server.createCar(make, carModel, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCar(int id) throws RemoteException {
        server.getCar(id, this);
    }

    @Override

    public void editCar(int id, String make, String carModel, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException {
        server.editCar(id, make, carModel, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);

    }

    @Override
    public void carCallback(Car car) {
        support.firePropertyChange("car", null, car);
    }

    @Override
    public void deleteCar(int carId) {
        try {
            server.deleteCar(carId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createBranch(String name, String location) {
        try {
            server.createBranch(name, location);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getBranch(int id) throws RemoteException {
        server.getBranch(id, this);
    }

    @Override
    public void editBranch(int id, String name, String location) throws RemoteException {
        server.editBranch(id, name, location);
    }

    @Override
    public void branchCallback(Branch branch) {
        support.firePropertyChange("branch", null, branch);
    }

    @Override
    public void deleteBranch(int branchId) {
        try {

            server.deleteBranch(branchId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void login(String username, String password) throws RemoteException {
        server.login(username, password, this);
    }

    @Override
    public void loginCallback(int role) {
        support.firePropertyChange("login", null, role);
    }

    @Override
    public void addListener(PropertyChangeListener listener, String name) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void getReservations() throws RemoteException {
        server.getReservations(this);
    }

    @Override
    public void reservationsCallback(ArrayList<Reservation> reservations) throws RemoteException {
        support.firePropertyChange("reservations", null, reservations);
    }

    @Override
    public void getBranches() throws RemoteException {

        server.getBranches(this);
    }

    @Override
    public void branchesCallback(ArrayList<Branch> branches) throws RemoteException {

        support.firePropertyChange("branches", null, branches);
    }

    @Override
    public void getCars() throws RemoteException {

        server.getCars(this);
    }

    @Override
    public void carsCallback(ArrayList<Car> cars) throws RemoteException {

        support.firePropertyChange("cars", null, cars);
    }

    @Override
    public void getEmployees() throws RemoteException {
        server.getEmployees(this);
    }

    @Override
    public void employeesCallback(ArrayList<Employee> employees) throws RemoteException {
        support.firePropertyChange("employees", null, employees);
    }

}
