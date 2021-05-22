package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeSupport;

public class AddEditBranchViewModel {

    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;

    private StringProperty name;
    private StringProperty location;
    private StringProperty message;



    public AddEditBranchViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.support = new PropertyChangeSupport(this);
        this.name = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
        this.message = new SimpleStringProperty();
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
        else {
            return true;
        }
    }

    public void addAction() {
        if (inputVerification()) {
            model.createBranch(name.getValue(), location.getValue());
        }
        else {
            //shouldn't do anything
        }

    }

    public void cancelAction () {
        //TODO go back to list
    }

    public void editAction () {
        if (inputVerification()) {
            model.createBranch(name.getValue(), location.getValue());
        } else {
            //shouldn't do anything
        }
    }





}
