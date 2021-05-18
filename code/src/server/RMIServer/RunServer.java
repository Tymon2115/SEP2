package server.RMIServer;

import shared.Branches.Branch;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;
import shared.personel.Employees;
import shared.personel.Manager;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Server server = new DataServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("server", server);
        System.out.println("started");
    }
}
