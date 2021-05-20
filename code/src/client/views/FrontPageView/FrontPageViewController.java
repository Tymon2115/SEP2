package client.views.FrontPageView;

import client.Session;
import client.viewmodel.FrontPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FrontPageViewController {

    @FXML
    public Button openEmployeeButton;
    @FXML
    public Button openBranchesButton;


    private FrontPageViewModel frontPageViewModel;

    public void init(FrontPageViewModel frontPageViewModel)
    {
        this.frontPageViewModel = frontPageViewModel;
        openBranchesButton.setVisible(false);
        openEmployeeButton.setVisible(false);

        // Owner ID = 1, Manager ID = 2
        if (Session.getRole_id() == 1)
        {
            openEmployeeButton.setVisible(true);
            openBranchesButton.setVisible(true);
        } else if (Session.getRole_id() == 2)
        {
            openEmployeeButton.setVisible(true);
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
