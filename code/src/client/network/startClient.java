package client.network;

import shared.Branches.Branch;
import shared.Reservation.Car;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class startClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Client client = new DataClient();
        client.startClient();
        client.createReservation("test");
    }
}
