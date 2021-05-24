package client.viewmodel;

import client.Session;
import client.core.ViewHandler;
import client.model.DataModel;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationViewModel {

    private  Model model;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty username;
    private StringProperty password;
    private StringProperty confirmpassword;
    private StringProperty registrationMessageLabel;
    private StringProperty role;
    private StringProperty branch;
    private StringProperty email;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;
    private ObservableList<String> branches;
    private ObservableList<String> roles;

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
        role = new SimpleStringProperty();
        branch = new SimpleStringProperty();
        email = new SimpleStringProperty();
        branches = FXCollections.observableArrayList();
        roles = FXCollections.observableArrayList();


        if (Session.getRole_id() == 1) {
            roles.add("2");
            roles.add("3");
        }

        if (Session.getRole_id() == 2) {
            roles.add("3");
        }

        model.addListener(this::listenForBranches, "branches");
        model.getBranches();

    }

    private void listenForBranches(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            branches.clear();

            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) propertyChangeEvent.getNewValue();
            ArrayList<String> receivedBranchNumbers = new ArrayList<>();
            for (Branch receivedBranch : receivedBranches) {
                receivedBranchNumbers.add(String.valueOf(receivedBranch.getId()));
            }
            branches.addAll(receivedBranchNumbers);

        });
    }

    public ObservableList<String> getBranches() {
        return branches;
    }

    public ObservableList<String> getRoles() {
        return roles;
    }

    public void home() {
        viewHandler.openEmployeeView();
    }

    private boolean inputVerification () {
        String specialCharacters = "^[^<>{}\"/|;:.,~!?@#$%^=&*\\]\\\\()\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$";
        Pattern regex = Pattern.compile(specialCharacters);

        Matcher matcher = regex.matcher(password.get());

        if (!matcher.find()) {
            registrationMessageLabel.set("Please input a password with at least one special character");
        }

        //TODO oliver : finish input verification

        if (firstname.get() == null || "".equals(firstname.get())) {
            registrationMessageLabel.setValue("Please input your first name");
            return false;
        } else if (lastname.get() == null || "".equals(lastname.get())) {
            registrationMessageLabel.setValue("Please input your last name");
            return false;
        } else if (username.get() == null || "".equals(username.get())) {
            registrationMessageLabel.setValue("Please input your username");
            return false;
        } else if (password.get() == null || "".equals(password.get())) {
            registrationMessageLabel.setValue("Please input your password");
            return false;
        } else if (confirmpassword.get() == null || "".equals(confirmpassword.get())) {
            registrationMessageLabel.setValue("Please input your password confirmation");
            return false;
        } else if (!password.get().equals(confirmpassword.get())){
            registrationMessageLabel.setValue("Please input matching passwords");
            return false;
        } else if (firstname.get().length() > 800) {
            registrationMessageLabel.set("Please input a first name with a maximum of 800 characters");
        } else if (lastname.get().length() > 40) {
            registrationMessageLabel.set("Please input a last name with a maximum of 40 characters");
        } else if (password.get().length() < 8) {
            registrationMessageLabel.set("Please input a password with a minimum length of 8 characters");
        } else if ()
            else {
            return true;
        }
    }

    public void register() {
        if (inputVerification()) {
            model.createEmployee(
                    firstname.get(),
                    lastname.get(),
                    Integer.parseInt(role.get()),
                    Integer.parseInt(branch.get()),
                    username.get(),
                    password.get(),
                    email.get()
            );

        }
        model.getEmployees();
        viewHandler.openEmployeeView();
        defaultFields();
    }

    public void defaultFields() {
        firstname.setValue("");
        lastname.setValue("");
        username.setValue("");
        password.setValue("");
        confirmpassword.setValue("");
        registrationMessageLabel.setValue("");
        email.setValue("");
    }

    public void onEdit (int id) {
        if (inputVerification()) {
            model.editEmployee(
                    id,
                    firstname.get(),
                    lastname.get(),
                    Integer.parseInt(role.get()),
                    Integer.parseInt(branch.get()),
                    username.get(),
                    password.get(),
                    email.get()
            );
            model.getEmployees();
            viewHandler.openEmployeeView();
            firstname.set("");
            lastname.set("");
            role.set("");
            branch.set("");
            username.set("");
            password.set("");
            email.set("");
        }
        else {
            //shouldn't do anything
        }
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public StringProperty roleProperty () {
        return role;
    }

    public StringProperty branchProperty() {
        return branch;
    }

    public StringProperty emailProperty () {
        return email;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty confirmPasswordProperty() {
        return confirmpassword;
    }

    public StringProperty registrationMessageLabelProperty() {
        return registrationMessageLabel;
    }
}
