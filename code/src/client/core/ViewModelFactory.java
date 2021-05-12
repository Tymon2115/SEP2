package client.core;

import client.model.Model;
import client.viewmodel.LoginViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel()
    {
        if (loginViewModel == null)
        {
            loginViewModel = new LoginViewModel(modelFactory.getModel());
        }
        return loginViewModel;
    }
}
