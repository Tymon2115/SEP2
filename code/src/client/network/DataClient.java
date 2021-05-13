package client.network;

import server.RMIServer.Server;
import shared.Branches.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
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


    //    public void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) {
    @Override
    public void createReservation(String name)  {
        try {
            //
            // server.createReservation(name, surname, driversLicence, address, creditCardNumber, car, branch, date, this);
            server.createReservation(name, this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void reservationCallback(Reservation reservation) throws RemoteException {
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

    }

    @Override
    public void deleteReservation(Reservation reservation) {

    }

    @Override
    public void createEmployee(String name, String surname, int id, Branch branch) {

    }

    @Override
    public void editEmployee() {

    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public void createManager(String name, String surname, int id, Branch branch) {

    }

    @Override
    public void editManager() {

    }

    @Override
    public void addManager(Manager manager) {

    }

    @Override
    public void deleteManager(Manager manager) {

    }

    @Override
    public void createCar(int id, String make, String model, String color, String numberPlates) {

    }

    @Override
    public void editCar() {

    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void deleteCar(Car car) {

    }

    @Override
    public void createBranch(String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) {

    }

    @Override
    public void editBranch() {

    }

    @Override
    public void addBranch(Branch branch) {

    }

    @Override
    public void deleteBranch(Branch branch) {

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
