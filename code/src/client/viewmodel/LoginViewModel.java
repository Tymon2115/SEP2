package client.viewmodel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {

    private Model model;
    private StringProperty username, password, loginResponse;

    public LoginViewModel(Model model) {
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginResponse = new SimpleStringProperty();

    }

    public StringProperty usernameProperty()
    {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty loginResponseProperty() {
        return loginResponse;
    }

    public void login() {
        System.out.println(username.get());
        System.out.println(password.get());

    }
}
