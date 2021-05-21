package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;

public class FrontPageViewModel {

    private ViewHandler viewHandler;
    private Model model;

    public FrontPageViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
    }

    public void getCarView() {
        viewHandler.openCarView();
    }

    public void getReservationView() {
        viewHandler.openReservationView();
    }

    public void getEmployeeView() {
        viewHandler.openEmployeeView();
    }

    public void getBranchView() {
        viewHandler.openBranchView();
    }
}
