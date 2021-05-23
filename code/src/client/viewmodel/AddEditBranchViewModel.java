package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import shared.Branch.Branch;

import javax.print.DocFlavor;
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
            model.getBranches();
            viewHandler.openBranchView();
        }
        else {
            //shouldn't do anything
        }

    }

    public void cancelAction () {
        viewHandler.openBranchView();
    }

    public void editAction () {
        if (inputVerification()) {
            //TODO call edit in model and go back to list
        } else {
            //shouldn't do anything
        }
    }


}
