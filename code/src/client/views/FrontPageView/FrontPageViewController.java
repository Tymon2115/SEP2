package client.views.FrontPageView;

import client.Session;
import client.viewmodel.FrontPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FrontPageViewController {

    @FXML
    private Button openEmployeeButton;
    @FXML
    private Button openBranchesButton;
    @FXML
    private Button openCarsButton;

    private FrontPageViewModel frontPageViewModel;

    public void init(FrontPageViewModel frontPageViewModel) {
        this.frontPageViewModel = frontPageViewModel;

        // Owner ID = 1, Manager ID = 2, Employee ID = 3
        if (Session.getRole_id() == 3) {
            openBranchesButton.setVisible(false);
            openEmployeeButton.setVisible(false);
            openCarsButton.setVisible(false);
        } else if (Session.getRole_id() == 2) {
            openBranchesButton.setVisible(false);
        }
    }

    public void onCarsButton(ActionEvent actionEvent) {
        frontPageViewModel.getCarView();
    }

    public void onReservationsButton(ActionEvent actionEvent) {
        frontPageViewModel.getReservationView();
    }

    public void onEmployeeButton(ActionEvent actionEvent) {
        frontPageViewModel.getEmployeeView();
    }

    public void onBranchesButton(ActionEvent actionEvent) {
        frontPageViewModel.getBranchView();
    }
}
