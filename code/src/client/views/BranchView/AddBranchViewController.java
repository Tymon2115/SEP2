package client.views.BranchView;

import client.viewmodel.AddEditBranchViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class AddBranchViewController {

    private AddEditBranchViewModel addEditBranchViewModel;

    @FXML
    private javafx.scene.control.TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private Label messageLabel;




    public void init (AddEditBranchViewModel addEditBranchViewModel) {
        this.addEditBranchViewModel = addEditBranchViewModel;
        nameTextField.textProperty().bindBidirectional(addEditBranchViewModel.nameProperty());
        locationTextField.textProperty().bindBidirectional(addEditBranchViewModel.locationProperty());
        messageLabel.textProperty().bindBidirectional(addEditBranchViewModel.messageProperty());
    }

    public void cancelAction () {
        addEditBranchViewModel.cancelAction();
    }

    public void addAction () {
        addEditBranchViewModel.addAction();
    }
}
