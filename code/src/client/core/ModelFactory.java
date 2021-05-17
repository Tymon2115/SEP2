package client.core;

import client.model.DataModel;
import client.model.Model;
import client.network.DataClient;

import java.rmi.RemoteException;


public class ModelFactory {
    private Model model;

    public Model getModel() {
        if (model == null) {
            try {
                model = new DataModel(new DataClient());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return model;
    }


}
