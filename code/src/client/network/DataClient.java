package client.network;

import server.RMIServer.Server;
import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class DataClient implements Client, PropertyChangeSubject {

    private Server server;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    public DataClient() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (Server) registry.lookup("server");
    }


    @Override
    public void createReservation(int id, String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, double price) {
        try {
            server.createReservation(id, name, surname, driversLicence, address, car, startBranch, endBranch, startDate, endDate, this, price);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void reservationCallback(Reservation reservation) {
        reservationUpdate(reservation);
    }

    private void reservationUpdate(Reservation reservation) {
        support.firePropertyChange("reservation", null, reservation);
    }

    @Override
    public void editReservation() {

    }

    @Override
    public void addReservation(Reservation reservation) {
        //todo idk this is garbage probably
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        try {
            server.deleteReservation(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createEmployee(String name, String surname, int roleId, Branch branch, String username, String password, String email) {
        try {
            server.createEmployee(name, surname, roleId, branch, username, password, email);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editEmployee() {

    }

    @Override
    public void employeeCallback(Employee employee) {
        support.firePropertyChange("employee", null, employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try {
            server.deleteEmployee(employee);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId) {
        try {
            server.createCar(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCar() {
        //
    }

    @Override
    public void carCallback(Car car) {
        support.firePropertyChange("car", null, car);
    }

    @Override
    public void deleteCar(Car car) {
        try {
            server.deleteCar(car);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void createBranch(int id, String name, String location) {
        try {
            server.createBranch(id, name, location);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editBranch() {

    }

    @Override
    public void branchCallback(Branch branch) {
        support.firePropertyChange("branch", null, branch);
    }

    @Override
    public void deleteBranch(Branch branch) {
        try {
            server.deleteBranch(branch);
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

//    @Override
//    public void addListener(PropertyChangeListener listener, String name) {
//
//    }
}
