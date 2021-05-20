package client.core;

import client.network.Client;
import client.network.DataClient;

import java.rmi.RemoteException;

public class ClientFactory {

    private DataClient client;

    public Client getClient() {
        if(client == null)
        {
            try {
                client = new DataClient();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return client;
    }
}
