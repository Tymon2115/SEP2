package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;

/**
 * ViewModel for displaying home page of the app
 * @author Dan
 */
public class FrontPageViewModel {

    private ViewHandler viewHandler;
    private Model model;

    /**
     * Instantiates a new Front page view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public FrontPageViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
    }

    /**
     * Gets car view.
     */
    public void getCarView() {
        viewHandler.openCarView();
        model.getCars();

    }

    /**
     * Gets reservation view.
     */
    public void getReservationView() {
        viewHandler.openReservationView();
        model.getReservations();
    }

    /**
     * Gets employee view.
     */
    public void getEmployeeView() {
        viewHandler.openEmployeeView();
        model.getEmployees();
    }

    /**
     * Gets branch view.
     */
    public void getBranchView() {
        viewHandler.openBranchView();
        model.getBranches();

    }

}
