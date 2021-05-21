package client.views.BranchView;

import client.viewmodel.BranchViewModel;
import client.viewmodel.ReservationViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.Branch.Branch;

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
    TableColumn<Branch, Integer> idCol;
    @FXML
    TableColumn<Branch, String> idName;
    @FXML
    TableColumn<Branch, String> idLocation;
    BranchViewModel branchViewModel;

    public void init(BranchViewModel branchViewModel) {
        this.branchViewModel = branchViewModel;
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
