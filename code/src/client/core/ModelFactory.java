package client.core;

import client.model.DataModel;
import client.model.Model;
import client.network.DataClient;

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
            model = new DataModel(clientFactory.getClient());
            System.out.println(">Model created");
            System.out.println(">model in model factory: " + model);
        }
        return model;
    }


}
