package client.core;


import client.views.CarView.CarViewController;
import client.views.FrontPageView.FrontPageViewController;
import client.views.LoginView.LoginController;
//import client.views.Registration.RegistrationViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.personel.Employee;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        stage = new Stage();
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        openLoginViewModel(null);
        stage.show();
        stage.setResizable(false);
    }

    // Could be private
    public void openLoginViewModel(Employee employee) {
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
    }


    public void openCarViewModel() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/CarView/CarView.fxml"));

        try {
            Parent root = null;
            root = loader.load();

            CarViewController controller = loader.getController();
            controller.init(viewModelFactory.getCarViewModel());

            stage.setTitle("Car View");
            Scene carScene = new Scene(root);
            stage.setScene(carScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void openRegistrationViewModel() {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../views/Registration/RegistrationView.fxml"));
//
//        try {
//            Parent root = null;
//            root = loader.load();
//
//            RegistrationViewController controller = loader.getController();
//            controller.init(viewModelFactory.getRegistrationViewModel(), this);
//
//            stage.setTitle("Registration View");
//            Scene registerScene = new Scene(root);
//            stage.setScene(registerScene);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

        public void openFrontPageViewModel() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/FrontpageView/FrontPageViewController.fxml"));

        try {
            Parent root = null;
            root = loader.load();

            FrontPageViewController controller = loader.getController();
            controller.init(viewModelFactory.getFrontPageController());

            stage.setTitle("Front Page View");
            Scene frontPageScene = new Scene(root);
            stage.setScene(frontPageScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
