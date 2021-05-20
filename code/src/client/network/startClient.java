package client.network;

import client.model.DataModel;
import client.model.Model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class startClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        DataClient client = new DataClient();
        Model model = new DataModel(client);
        client.startClient();
//        model.createBranch("model", "Model");
        model.getBranch(10);
    }
}
