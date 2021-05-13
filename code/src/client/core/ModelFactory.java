package client.core;

import client.model.Model;
import client.model.ModelManager;

public class ModelFactory {
    private Model model;

    public Model getModel() {
        if (model == null)
        {
            model = new ModelManager();
        }
        return model;
    }


}
