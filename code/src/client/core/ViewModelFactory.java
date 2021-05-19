package client.core;

import client.model.Model;
import client.viewmodel.CarViewModel;
import client.viewmodel.LoginViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CarViewModel carViewModel;
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

    public CarViewModel getCarViewModel() {
        if (carViewModel == null)
        {
            carViewModel = new CarViewModel(modelFactory.getModel());
        }
        return carViewModel;
    }
}
