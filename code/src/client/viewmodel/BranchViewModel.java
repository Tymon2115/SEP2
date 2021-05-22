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

public class BranchViewModel {
    private Model model;
    private ViewHandler viewHandler;
    private ObservableList<Branch> branches;

    public BranchViewModel(Model model, ViewHandler viewHandler) {
        branches = FXCollections.observableArrayList();
        this.model = model;
        model.getBranches();
        this.viewHandler = viewHandler;
        model.addListener(this::listenForBranches, "branches");
    }


    public Model getModel() {
        return model;
    }

    public void home() {
        viewHandler.openFrontPageView();
    }

    public void listenForBranches(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            branches.clear();
            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) event.getNewValue();
            branches.addAll(receivedBranches);
        });
    }


    public ObservableList<Branch> getBranches() {
        return branches;
    }


}
