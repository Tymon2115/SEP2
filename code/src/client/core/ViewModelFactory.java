package client.core;

import client.viewmodel.CarViewModel;
import client.viewmodel.FrontPageViewModel;
import client.viewmodel.LoginViewModel;
import client.viewmodel.RegistrationViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CarViewModel carViewModel;
    private RegistrationViewModel registrationViewModel;
    private FrontPageViewModel frontPageViewModel;
    private ModelFactory modelFactory;
    private ViewHandler viewHandler;

    public ViewModelFactory(ModelFactory modelFactory, ViewHandler viewHandler) {
        this.modelFactory = modelFactory;
        this.viewHandler = viewHandler;
    }

    public LoginViewModel getLoginViewModel()
    {
        if (loginViewModel == null)
        {
            loginViewModel = new LoginViewModel(modelFactory.getModel(), viewHandler );
        }
        return loginViewModel;
    }

    public CarViewModel getCarViewModel() {
        if (carViewModel == null)
        {
            carViewModel = new CarViewModel(modelFactory.getModel(), viewHandler);
        }
        return carViewModel;
    }

    public FrontPageViewModel getFrontPageController() {
        if (frontPageViewModel == null)
        {
            frontPageViewModel = new FrontPageViewModel(modelFactory.getModel(), viewHandler);
        }
        return frontPageViewModel;
    }

    public RegistrationViewModel getRegistrationViewModel() {
        if (registrationViewModel == null)
        {
            registrationViewModel = new RegistrationViewModel(modelFactory.getModel(), viewHandler);
        }
        return registrationViewModel;
    }
}
