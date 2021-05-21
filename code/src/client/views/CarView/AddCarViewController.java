package client.views.CarView;

import client.viewmodel.CarViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddCarViewController {
    private CarViewModel carViewModel;

    public AddCarViewController (CarViewModel carViewModel) {
        this.carViewModel = carViewModel;
    }

    @FXML
    private TextField makeTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField colorTextField;
    @FXML
    private TextField numberPlatesTextField;
    @FXML
    private TextField fuelTypeTextField;
    @FXML
    private TextField fuelConsumptionTextField;
    @FXML
    private TextField seatsTextField;
    @FXML
    private TextField engineTextField;
    @FXML
    private TextField transmissionTextField;
    @FXML
    private TextField equipmentTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField dailyPriceTextField;
    @FXML
    private ComboBox branchComboBox;

    public void cancelAction () {

    }

    public void addAction () {

    }

    public void proceedAction() {

    }
}
