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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class DataServer implements Server {

    public DataServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
//    public void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date, Client client) throws RemoteException {
            public void createReservation(String name, Client client){
        Reservation reservation = new Reservation(name);
        //todo there will be some database bullshit and then reservation will be made
        try {
            client.reservationCallback(reservation);
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
    public Car createCar(int id, String make, String model, String color, String numberPlates) throws RemoteException {
        return new Car(id, make, model, color, numberPlates);
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
        return new Branch(name, location, employees, reservations, cars, manager);
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
