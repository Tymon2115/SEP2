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

/**
 * ViewModel for registration of new employee, only accesible by manager and owner
 * @author Dan
 */
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

    /**
     * Instantiates a new Registration view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
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

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<String> getBranches() {
        return branches;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public ObservableList<String> getRoles() {
        return roles;
    }

    /**
     * Home.
     */
    public void home() {
        viewHandler.openEmployeeView();
    }

    private boolean inputVerification () {
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
            registrationMessageLabel.setValue("Passwords do not match");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Register.
     */
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

    /**
     * Default fields.
     */
    public void defaultFields() {
        firstname.setValue("");
        lastname.setValue("");
        username.setValue("");
        password.setValue("");
        confirmpassword.setValue("");
        registrationMessageLabel.setValue("");
        email.setValue("");
    }

    /**
     * On edit.
     *
     * @param id the id
     */
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

    /**
     * Firstname property string property.
     *
     * @return the string property
     */
    public StringProperty firstnameProperty() {
        return firstname;
    }

    /**
     * Lastname property string property.
     *
     * @return the string property
     */
    public StringProperty lastnameProperty() {
        return lastname;
    }

    /**
     * Role property string property.
     *
     * @return the string property
     */
    public StringProperty roleProperty () {
        return role;
    }

    /**
     * Branch property string property.
     *
     * @return the string property
     */
    public StringProperty branchProperty() {
        return branch;
    }

    /**
     * Email property string property.
     *
     * @return the string property
     */
    public StringProperty emailProperty () {
        return email;
    }

    /**
     * Username property string property.
     *
     * @return the string property
     */
    public StringProperty usernameProperty() {
        return username;
    }

    /**
     * Password property string property.
     *
     * @return the string property
     */
    public StringProperty passwordProperty() {
        return password;
    }

    /**
     * Confirm password property string property.
     *
     * @return the string property
     */
    public StringProperty confirmPasswordProperty() {
        return confirmpassword;
    }

    /**
     * Registration message label property string property.
     *
     * @return the string property
     */
    public StringProperty registrationMessageLabelProperty() {
        return registrationMessageLabel;
    }
}
