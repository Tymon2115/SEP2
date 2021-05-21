package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewModel {

    private Model model;
    private StringProperty username, password, loginResponse;
    private PropertyChangeListener listener;
    private ViewHandler viewHandler;


    public LoginViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginResponse = new SimpleStringProperty();
        model.addListener(this::loggedIn, "login");
        this.viewHandler = viewHandler;
    }

    public void loggedIn(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            int role_id = (int) event.getNewValue();
            if (role_id == 0) {
                loginResponse.setValue("Incorrect information");
            } else {
                viewHandler.openFrontPageView();
            }
        });


    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty loginResponseProperty() {
        return loginResponse;
    }

    public void login() {
        model.login(username.get(), password.get());
    }

    public void openFrontPageView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../client/views/LoginView/Login.fxml"));

    }
}
