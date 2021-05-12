package client.views.LoginView;

import client.viewmodel.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginResultMessage;

    private LoginViewModel loginVM;

    public void init() {
        usernameField.textProperty().bindBidirectional(loginVM.usernameProperty());
        passwordField.textProperty().bindBidirectional(loginVM.passwordProperty());
        loginResultMessage.textProperty().bindBidirectional(loginVM.loginResponseProperty());
    }

    public void onLoginButton(ActionEvent actionEvent) {
        System.out.println("Login pressed");
        loginVM.login();
    }


}
