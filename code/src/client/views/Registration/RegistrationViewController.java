package client.views.Registration;

import client.core.ViewHandler;
import client.viewmodel.RegistrationViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationViewController {

    @FXML
    public SplitMenuButton selectRoleSelector;
    @FXML
    public SplitMenuButton selectBranchSelector;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmpasswordTextField;
    @FXML
    private Label registrationLabelMessage;


    private RegistrationViewModel registrationViewModel;
    private ViewHandler viewHandler;

    public void init(RegistrationViewModel registrationViewModel) {
        this.registrationViewModel = registrationViewModel;
        firstnameTextField.textProperty().bindBidirectional(registrationViewModel.firstnameProperty());
        lastnameTextField.textProperty().bindBidirectional(registrationViewModel.lastnameProperty());
        usernameTextField.textProperty().bindBidirectional(registrationViewModel.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(registrationViewModel.passwordProperty());
        confirmpasswordTextField.textProperty().bindBidirectional(registrationViewModel.confirmpasswordProperty());
        registrationLabelMessage.textProperty().bindBidirectional(registrationViewModel.registrationMessageLabelProperty());
    }

    public void closeOnAction(ActionEvent actionEvent) {
        registrationViewModel.defaultFields();
        registrationViewModel.home();
    }

    public void selectRole(ActionEvent actionEvent) {
//        if (selectRoleSelecter == )
//        {
//            selectRoleSelecter.setOnAction((actionEvent1 ->
//                    ));
//        }
    }

    public void registerButtonOnAction(ActionEvent actionEvent) {
        registrationViewModel.register();
    }

    public void selectBranch(ActionEvent actionEvent) {

    }

    public void home() {
        registrationViewModel.home();
    }
}
