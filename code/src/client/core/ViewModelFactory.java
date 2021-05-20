package client.core;


//import client.viewmodel.CarViewModel;
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

    public FrontPageViewModel getFrontPageController() {
        if (frontPageViewModel == null)
        {
            frontPageViewModel = new FrontPageViewModel(modelFactory.getModel());
        }
        return frontPageViewModel;
    }

//    public RegistrationViewModel getRegistrationViewModel() {
//        if (registrationViewModel == null)
//        {
//            registrationViewModel = new RegistrationViewModel(modelFactory.getModel());
//        }
//        return registrationViewModel;
//    }
}
