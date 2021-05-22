package client.core;


import client.viewmodel.BranchViewModel;
import client.viewmodel.CarViewModel;
import client.views.BranchView.BranchViewController;

import client.views.CarView.CarViewController;
import client.views.EmployeeView.EmployeeViewController;
import client.views.FrontPageView.FrontPageViewController;
import client.views.LoginView.LoginController;
import client.views.Registration.RegistrationViewController;
import client.views.ReservationView.ReservationViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
}
