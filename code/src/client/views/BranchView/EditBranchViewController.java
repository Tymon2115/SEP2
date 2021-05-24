package client.views.BranchView;

import client.viewmodel.AddEditBranchViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import shared.Branch.Branch;

import java.util.ArrayList;

public class EditBranchViewController {
    private AddEditBranchViewModel addEditBranchViewModel;

    @FXML
    private javafx.scene.control.TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private Label messageLabel;
    @FXML
    private Text idText;



    public void init (AddEditBranchViewModel addEditBranchViewModel, Branch selectedBranch) {
        this.addEditBranchViewModel = addEditBranchViewModel;
        nameTextField.textProperty().bindBidirectional(addEditBranchViewModel.nameProperty());
        locationTextField.textProperty().bindBidirectional(addEditBranchViewModel.locationProperty());
        messageLabel.textProperty().bindBidirectional(addEditBranchViewModel.messageProperty());


        idText.setText(String.valueOf(selectedBranch.getId()));
        nameTextField.textProperty().set(selectedBranch.getName());
        locationTextField.textProperty().set(selectedBranch.getLocation());
    }

    public void cancelAction () {
        addEditBranchViewModel.cancelAction();
    }

    public void editAction () {
        addEditBranchViewModel.editAction(Integer.parseInt(idText.getText()));
    }
}
