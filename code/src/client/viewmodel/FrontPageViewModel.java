package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;

public class FrontPageViewModel {

    private ViewHandler viewHandler;
    private Model model;

    public FrontPageViewModel(Model model) {
        this.model = model;
    }

    public void getCarView() {
//        viewHandler.openCarViewModel();
    }

    public void getReservationView() {
//        viewHandler.openReservationView();
    }

    public void getEmployeeView() {
//        viewHandler.openEmployeeView();
    }

    public void getBranchView() {
//        viewHandler.openBranchView();
    }
}
