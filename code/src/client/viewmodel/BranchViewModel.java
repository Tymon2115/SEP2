package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * ViewModel for displaying branch information
 * @author Dan
 */
public class BranchViewModel {
    private Model model;
    private final ViewHandler viewHandler;
    private ObservableList<Branch> branches;

    /**
     * Instantiates a new Branch view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public BranchViewModel(Model model, ViewHandler viewHandler) {
        branches = FXCollections.observableArrayList();
        this.model = model;

        model.getBranches();
        this.viewHandler = viewHandler;
        model.addListener(this::listenForBranches, "branches");
    }


    /**
     * Gets model.
     *
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Home.
     */
    public void home() {
        viewHandler.openFrontPageView();
    }

    /**
     * Listen for branches.
     *
     * @param event the event
     */
    public void listenForBranches(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            branches.clear();
            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) event.getNewValue();
            branches.addAll(receivedBranches);
        });
    }

    /**
     * Add branch.
     */
    public void addBranch(){
        viewHandler.openAddBranchView();
    }

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<Branch> getBranches() {
        return branches;
    }

    /**
     * Gets add branch view.
     */
    public void getAddBranchView () {
        viewHandler.openAddBranchView();
    }

    /**
     * Open edit view.
     *
     * @param selectedBranch the selected branch
     */
    public void openEditView (Branch selectedBranch) {
        viewHandler.openBranchEditView(selectedBranch);
    }

    /**
     * Delete action.
     *
     * @param id the id
     */
    public void deleteAction (int id) {
        model.deleteBranch(id);
        model.getBranches();
    }

}
