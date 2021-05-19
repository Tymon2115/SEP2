package client.core;

import client.model.DataModel;
import client.model.Model;

import java.rmi.RemoteException;


public class ModelFactory
{
    private DataModel model;
    private ClientFactory clientFactory;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }


    public Model getModel() {
        if (model == null) {
            try {
                model = new Model(clientFactory.getClient());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return model;
    }


}
