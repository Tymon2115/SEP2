package client.core;

import client.viewmodel.*;
import server.database.BranchHandler;
import shared.personel.Employee;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CarViewModel carViewModel;
    private RegistrationViewModel registrationViewModel;
    private FrontPageViewModel frontPageViewModel;
    private ModelFactory modelFactory;
    private ViewHandler viewHandler;
    private ReservationViewModel reservationViewModel;
    private BranchViewModel branchViewModel;
    private EmployeeViewModel employeeViewModel;
    private AddEditReservationViewModel addEditReservationViewModel;
    private AddEditBranchViewModel addEditBranchViewModel;
    private AddEditCarViewModel addEditCarViewModel;

    public ViewModelFactory(ModelFactory modelFactory, ViewHandler viewHandler) {
        this.modelFactory = modelFactory;
        this.viewHandler = viewHandler;
    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory.getModel(), viewHandler);
        }
        return loginViewModel;
    }

    public CarViewModel getCarViewModel() {
        if (carViewModel == null) {

            carViewModel = new CarViewModel(modelFactory.getModel(), viewHandler);

        }
        return carViewModel;
    }

    public FrontPageViewModel getFrontPageController() {
        if (frontPageViewModel == null) {
            frontPageViewModel = new FrontPageViewModel(modelFactory.getModel(), viewHandler);
        }
        return frontPageViewModel;
    }

    public RegistrationViewModel getRegistrationViewModel() {
        if (registrationViewModel == null) {
            registrationViewModel = new RegistrationViewModel(modelFactory.getModel(), viewHandler);
        }
        return registrationViewModel;
    }

    public ReservationViewModel getReservationViewModel() {
        if (reservationViewModel == null) {
            reservationViewModel = new ReservationViewModel(modelFactory.getModel(), viewHandler);
        }
        return reservationViewModel;
    }

    public BranchViewModel getBranchViewModel() {
        if (branchViewModel == null) {
            branchViewModel = new BranchViewModel(modelFactory.getModel(), viewHandler);

        }
        return branchViewModel;
    }

    public EmployeeViewModel getEmployeeViewModel() {
        if (employeeViewModel == null) {
            employeeViewModel = new EmployeeViewModel(modelFactory.getModel(), viewHandler);
        }
        return employeeViewModel;
    }

    public AddEditReservationViewModel getAddEditReservationViewModel() {
        if (addEditReservationViewModel == null) {
            addEditReservationViewModel = new AddEditReservationViewModel(modelFactory.getModel(), viewHandler);
        }
        return addEditReservationViewModel;
    }

    public AddEditBranchViewModel getAddEditBranchView() {
        if (addEditBranchViewModel == null) {
            addEditBranchViewModel = new AddEditBranchViewModel(modelFactory.getModel(), viewHandler);
        }
        return addEditBranchViewModel;
    }

    public AddEditCarViewModel getAddEditCarViewModel() {
        if (addEditCarViewModel == null) {
            addEditCarViewModel = new AddEditCarViewModel(modelFactory.getModel(), viewHandler);
        }
        return addEditCarViewModel;
    }
}
