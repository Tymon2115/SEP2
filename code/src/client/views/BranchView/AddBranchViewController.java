package client.views.BranchView;

import client.viewmodel.BranchViewModel;
import javafx.fxml.FXML;

import java.awt.*;

public class AddBranchViewController {

    private BranchViewModel branchViewModel;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField locationTextField;

    public AddBranchViewController (BranchViewModel branchViewModel) {
        this.branchViewModel = branchViewModel;

    }

    public void backAction () {

    }

    public void addAction () {

    }

    public void proceedAction () {

    }
}
