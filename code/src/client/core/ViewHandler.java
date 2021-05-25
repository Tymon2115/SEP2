package client.core;


import client.viewmodel.*;
import client.views.BranchView.AddBranchViewController;
import client.views.BranchView.BranchViewController;

import client.views.BranchView.EditBranchViewController;
import client.views.CarView.AddCarViewController;
import client.views.CarView.CarViewController;

import client.views.CarView.EditCarViewController;
import client.views.EmployeeView.EditEmployeeViewController;
import client.views.EmployeeView.EmployeeViewController;
import client.views.FrontPageView.FrontPageViewController;
import client.views.LoginView.LoginController;

import client.views.Registration.RegistrationViewController;
import client.views.ReservationView.AddReservationViewController;
import client.views.ReservationView.EditReservationViewController;
import client.views.ReservationView.ReservationViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.Branch.Branch;
import shared.Reservation.Car;
import shared.Reservation.Reservation;
import shared.personel.Employee;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ModelFactory modelFactory;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ModelFactory modelFactory) {
        stage = new Stage();
        this.modelFactory = modelFactory;
        viewModelFactory = new ViewModelFactory(modelFactory, this);

    }

    public void start() {
        openLoginView();
        stage.show();
        stage.setResizable(false);
    }

    // Could be private
    public void openLoginView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/LoginView/Login.fxml"));

        try {
            Parent root = null;
            root = loader.load();

            LoginController controller = loader.getController();
            controller.init(viewModelFactory.getLoginViewModel());

            stage.setTitle("Log in");
            Scene loginScene = new Scene(root);
            stage.setScene(loginScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFrontPageView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/FrontPageView/FrontPageView.fxml"));

        try {
            Parent root = null;
            root = loader.load();

            FrontPageViewController controller = loader.getController();
            controller.init(viewModelFactory.getFrontPageController());
            stage.setTitle("Home");
            Scene frontScene = new Scene(root);
            stage.setScene(frontScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openCarView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/CarView/CarView.fxml"));
        try {
            CarViewModel carViewModel = viewModelFactory.getCarViewModel();
            Parent root = null;
            root = loader.load();
            CarViewController controller = loader.getController();
            controller.init(carViewModel);
            stage.setTitle("Car View");
            stage.setMaximized(true);
            Scene carScene = new Scene(root);
            stage.setScene(carScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openRegistrationView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Registration/RegistrationView.fxml"));
        try {
            Parent root = null;
            root = loader.load();

            RegistrationViewController controller = loader.getController();
            controller.init(viewModelFactory.getRegistrationViewModel());

            stage.setTitle("Registration View");
            Scene registerScene = new Scene(root);
            stage.setScene(registerScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openReservationView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/ReservationView/ReservationView.fxml"));
        try {
            Parent root = null;
            root = loader.load();
            ReservationViewController controller = loader.getController();
            controller.init(viewModelFactory.getReservationViewModel());

            stage.setTitle("Reservation");
            Scene reservationScene = new Scene(root);
            stage.setScene(reservationScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openEmployeeView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/EmployeeView/EmployeeView.fxml"));
        try {
            Parent root = null;
            root = loader.load();
            EmployeeViewController controller = loader.getController();
            controller.init(viewModelFactory.getEmployeeViewModel());
            stage.setTitle("Employee");
            Scene employeeScene = new Scene(root);
            stage.setScene(employeeScene);
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBranchView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/BranchView/BranchView.fxml"));
        try {
            BranchViewModel branchViewModel = viewModelFactory.getBranchViewModel();
            Parent root = null;
            root = loader.load();
            BranchViewController controller = loader.getController();
            controller.init(branchViewModel);
            stage.setTitle("Branch");
            Scene branchScene = new Scene(root);
            stage.setScene(branchScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAddReservationView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/ReservationView/AddReservationView.fxml"));
        try {
            AddEditReservationViewModel addEditReservationViewModel = viewModelFactory.getAddEditReservationViewModel();
            Parent root = null;
            root = loader.load();
            AddReservationViewController controller = loader.getController();
            controller.init(addEditReservationViewModel);
            stage.setTitle("Add Reservation");
            Scene addReservationScene = new Scene(root);
            stage.setScene(addReservationScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAddBranchView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/BranchView/AddBranchView.fxml"));
        try {
            AddEditBranchViewModel addEditBranchViewModel = viewModelFactory.getAddEditBranchViewModel();
            Parent root = null;
            root = loader.load();
            AddBranchViewController controller = loader.getController();
            controller.init(addEditBranchViewModel);
            stage.setTitle("Add Branch");
            Scene addBranchScene = new Scene(root);
            stage.setScene(addBranchScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAddCarView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/CarView/AddCarView.fxml"));
        try {
            AddEditCarViewModel addEditCarViewModel = viewModelFactory.getAddEditCarViewModel();
            Parent root = null;
            root = loader.load();
            AddCarViewController controller = loader.getController();
            controller.init(addEditCarViewModel);
            stage.setTitle("Add Car");
            Scene addBranchScene = new Scene(root);
            stage.setScene(addBranchScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBranchEditView (Branch selectedBranch) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/BranchView/EditBranchView.fxml"));
        try {
            AddEditBranchViewModel addEditBranchViewModel = viewModelFactory.getAddEditBranchViewModel();
            Parent root = null;
            root = loader.load();
            EditBranchViewController controller = loader.getController();
            controller.init(addEditBranchViewModel, selectedBranch);
            stage.setTitle("Edit Branch");
            Scene editBranchScene = new Scene(root);
            stage.setScene(editBranchScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCarEditView (Car selectedCar) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/CarView/EditCarView.fxml"));
        try {
            AddEditCarViewModel addEditCarViewModel = viewModelFactory.getAddEditCarViewModel();
            Parent root = null;
            root = loader.load();
            EditCarViewController controller = loader.getController();
            controller.init(addEditCarViewModel, selectedCar);
            stage.setTitle("Edit Car");
            Scene editCarScene = new Scene(root);
            stage.setScene(editCarScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openEmployeeEditView (Employee selectedEmployee) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/EmployeeView/EditEmployeeView.fxml"));
        try {
            RegistrationViewModel registrationViewModel = viewModelFactory.getRegistrationViewModel();
            Parent root = null;
            root = loader.load();
            EditEmployeeViewController controller = loader.getController();
            controller.init(registrationViewModel, selectedEmployee);
            stage.setTitle("Edit Employee");
            Scene editEmployeeScene = new Scene(root);
            stage.setScene(editEmployeeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openReservationEditView (Reservation selectedReservation) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/ReservationView/EditReservationView.fxml"));
        try {
            AddEditReservationViewModel addEditReservationViewModel = viewModelFactory.getAddEditReservationViewModel();
            Parent root = null;
            root = loader.load();
            EditReservationViewController controller = loader.getController();
            controller.init(addEditReservationViewModel, selectedReservation);
            stage.setTitle("Edit Reservation");
            Scene editReservationScene = new Scene(root);
            stage.setScene(editReservationScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
