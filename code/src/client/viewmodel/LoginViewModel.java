package client.viewmodel;

import client.Session;
import client.core.ViewHandler;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewModel {

    private Model model;
    private StringProperty username, password, loginResponse;
    private PropertyChangeListener listener;
    private ViewHandler viewHandler;


    public LoginViewModel(Model model) {
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginResponse = new SimpleStringProperty();
        model.addListener(this::loggedIn, "login");
    }

    public int loggedIn(PropertyChangeEvent event) {
        int role_id = (int) event.getNewValue();

        if (role_id == 0)
        {
            loginResponse.setValue("Incorrect information");
        }
        else {
            viewHandler.openFrontPageView();
        }

        return role_id;
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
}
