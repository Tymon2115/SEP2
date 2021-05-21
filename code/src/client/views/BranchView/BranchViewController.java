package client.views.BranchView;

import client.viewmodel.BranchViewModel;
import client.viewmodel.ReservationViewModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.Branch.Branch;

import java.beans.PropertyChangeEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BranchViewController {
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    TableView<Branch> tableView;
    @FXML
    TableColumn<Branch, Number> idCol;
    @FXML
    TableColumn<Branch, String> idName;
    @FXML
    TableColumn<Branch, String> idLocation;
    BranchViewModel branchViewModel;

    public void init(BranchViewModel branchViewModel) {
        this.branchViewModel = branchViewModel;
        idName.setCellValueFactory(cellData -> (cellData.getValue().nameProperty()));
        idCol.setCellValueFactory(cellData -> (cellData.getValue().idProperty()));
        idLocation.setCellValueFactory(cellData -> (cellData.getValue().locationProperty()));
        System.out.println(branchViewModel.getBranches());
        tableView.setItems(branchViewModel.getBranches());
    }


    public void openAddView(ActionEvent actionEvent) {

    }

    public void openDeleteView(ActionEvent actionEvent) {

    }

    public void openEditView(ActionEvent actionEvent) {

    }

    public void goBack(ActionEvent actionEvent) {
        branchViewModel.home();
    }


}
