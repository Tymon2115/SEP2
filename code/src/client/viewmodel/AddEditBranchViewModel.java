package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import shared.Branch.Branch;

import javax.print.DocFlavor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AddEditBranchViewModel {

    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;


    private StringProperty name;
    private StringProperty location;
    private StringProperty message;
    private ArrayList<Branch> branches;


    public AddEditBranchViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.support = new PropertyChangeSupport(this);
        this.name = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
        this.message = new SimpleStringProperty();
        branches = new ArrayList<>();
        model.addListener(this::listenForBranches, "branches");
        model.getBranches();
    }

    private void listenForBranches(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            branches  = (ArrayList<Branch>) propertyChangeEvent.getNewValue();
        });
    }


    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty locationProperty() {
        return location;
    }

    public StringProperty messageProperty() {
        return message;
    }

    private boolean inputVerification() {
        if (name.get() == null || name.get().equals("")) {
            message.setValue("Please input name");
            return false;
        }
        else if (location.get() == null || name.get().equals("")) {
            message.setValue("Please input location");
            return false;
        }
        else if (name.get().length() > 500) {
            message.set("Please input a name with maximum 500 characters");
            return false;
        }
        else if (location.get().length() > 100) {
            message.set("Please input a location with a maximum of 500 characters");
            return false;
        }
        else {

            model.getBranches();

            for (Branch branch : branches) {
                if (branch.getName().equals(name.get()) && branch.getLocation().equals(location.get())) {
                    message.set("This branch already exists in the system");
                    return false;
                }
            }

            return true;
        }
    }

    private void defaultFields () {
        name.set("");
        location.set("");
        message.set("");
    }

    private void reload () {
        model.getBranches();
        viewHandler.openBranchView();
        defaultFields();
    }

    public void addAction() {
        if (inputVerification()) {
            model.createBranch(name.getValue(), location.getValue());
            reload();
            defaultFields();
        }
        else {
            //shouldn't do anything
        }

    }

    public void cancelAction () {
        reload();
    }

    public void editAction (int id) {
        if (inputVerification()) {
            model.editBranch(id, name.get(), location.get());
            reload();
        } else {
            //shouldn't do anything
        }
    }


}
