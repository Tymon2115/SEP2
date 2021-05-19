package client.network;

import server.RMIServer.Server;
import shared.Branches.Branch;
import shared.EventType;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.Remote;
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
    public void createReservation(int id, String name, String surname, String driversLicence, Address address, String creditCardNumber, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate) {
        try {
            server.createReservation(id, name, surname, driversLicence, address, creditCardNumber, car, startBranch, endBranch, startDate, endDate, this);
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
    public void createEmployee(String name, String surname, int id, Branch branch) {
        try {
            server.createEmployee(name, surname, id, branch);
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
    public void createManager(String name, String surname, int id, Branch branch) {
        try {
            server.createManager(name, surname, id, branch);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editManager() {

    }

    @Override
    public void login(String username, String password) {

        User user=new User(username,password);
        Request req=new Request(EventType.CREATEUSER_REQUEST,user);
        sendToServer(req,"Successfull");

    }

    @Override
    public void managerCallback(Manager manager) {
        support.firePropertyChange("manager", null, manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        try {
            server.deleteManager(manager);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCar(Car car) {
        try {
            server.createCar(car);
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
    public void createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) {
        try {
            server.createBranch(name, location, employees, reservations, cars, manager);
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
    public void addListener(PropertyChangeListener listener, String name) {
        support.addPropertyChangeListener(name, listener);
    }

//    @Override
//    public void addListener(PropertyChangeListener listener, String name) {
//
//    }
}
