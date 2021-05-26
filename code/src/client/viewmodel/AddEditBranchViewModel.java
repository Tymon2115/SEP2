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

/**
 * ViewModel for adding and editing the branch
 * @author Oliver
 */
public class AddEditBranchViewModel {

    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;


    private StringProperty name;
    private StringProperty location;
    private StringProperty message;


    /**
     * Instantiates a new Add edit branch view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public AddEditBranchViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.support = new PropertyChangeSupport(this);
        this.name = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
        this.message = new SimpleStringProperty();
    }

    /**
     * Name property string property.
     *
     * @return the string property
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * Location property string property.
     *
     * @return the string property
     */
    public StringProperty locationProperty() {
        return location;
    }

    /**
     * Message property string property.
     *
     * @return the string property
     */
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

    /**
     * Add action calls add method on model.
     */
    public void addAction() {
        if (inputVerification()) {
            model.createBranch(name.getValue(), location.getValue());
            model.getBranches();
            viewHandler.openBranchView();
            name.set("");
            location.set("");
        }
        else {
            //shouldn't do anything
        }

    }

    /**
     * Cancel action, goes back to previous scene.
     */
    public void cancelAction () {
        viewHandler.openBranchView();
    }

    /**
     * Edit action.
     *
     * @param id the id
     */
    public void editAction (int id) {
        if (inputVerification()) {
            model.editBranch(id, name.get(), location.get());
            model.getBranches();
            viewHandler.openBranchView();
            name.set("");
            location.set("e");
        } else {
            //shouldn't do anything
        }
    }


}
