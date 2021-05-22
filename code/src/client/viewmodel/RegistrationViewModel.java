package client.viewmodel;

import client.core.ViewHandler;
import client.model.DataModel;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.personel.Employee;

import java.beans.PropertyChangeSupport;

public class RegistrationViewModel {

    private Model model;
    private StringProperty firstname, lastname, username, password, confirmpassword, registrationMessageLabel;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;

    public RegistrationViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        support = new PropertyChangeSupport(this);
        this.viewHandler = viewHandler;
        firstname = new SimpleStringProperty();
        lastname = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirmpassword = new SimpleStringProperty();
        registrationMessageLabel = new SimpleStringProperty();

        // Branch and Role

    }

    public void home() {
        viewHandler.openFrontPageView();
    }

    public void register() {
        if (firstname.get() == null || "".equals(firstname.get())) {
            registrationMessageLabel.setValue("Please input your first name");
        } else if (lastname.get() == null || "".equals(lastname.get())) {
            registrationMessageLabel.setValue("Please input your last name");
        } else if (username.get() == null || "".equals(username.get())) {
            registrationMessageLabel.setValue("Please input your username");
        } else if (password.get() == null || "".equals(password.get())) {
            registrationMessageLabel.setValue("Please input your password");
        } else if (password.get().length() < 3 || password.get().length() > 15) {
            registrationMessageLabel.setValue("Password needs to be between 3 and 15 characters");
        } else if (confirmpassword.get() == null || "".equals(confirmpassword.get())) {
            registrationMessageLabel.setValue("Please input your password confirmation");
        } else {
            if (confirmpassword.get() != null) {
                if (!confirmpassword.get().equals(password.get())) {
                    registrationMessageLabel.setValue("The password don't match");
                } else {
                    registerEmployeeAccount();

                }
            }
        }
    }

    public void registerEmployeeAccount() {
        model.register(new Employee(firstname.get(), lastname.get(), username.get(), password.get()));
        defaultFields();
    }

    public void defaultFields() {
        firstname.setValue("");
        lastname.setValue("");
        username.setValue("");
        password.setValue("");
        confirmpassword.setValue("");
        registrationMessageLabel.setValue("");
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty confirmpasswordProperty() {
        return confirmpassword;
    }

    public StringProperty registrationMessageLabelProperty() {
        return registrationMessageLabel;
    }
}
