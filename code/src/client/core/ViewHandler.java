package client.core;

import client.views.LoginView.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        stage = new Stage();
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        openLoginViewModel();
        stage.show();
    }

    // Could be private
    public void openLoginViewModel() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/LoginView/Login.fxml"));

        try {
            Parent root = null;
            root = loader.load();

            LoginController controller = loader.getController();
            controller.init(viewModelFactory.getLoginViewModel());

            stage.setTitle("Login");
            Scene loginScene = new Scene(root);
            stage.setScene(loginScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
