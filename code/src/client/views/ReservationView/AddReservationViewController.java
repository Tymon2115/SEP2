package client.views.ReservationView;

import client.viewmodel.ReservationViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class AddReservationViewController {

    private ReservationViewModel reservationViewModel;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField driversLicenceTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField zipTextField;
    @FXML
    private TextField countryTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private ComboBox carComboBox;
    @FXML
    private ComboBox startBranchComboBox;
    @FXML
    private ComboBox endBranchComboBox;
    @FXML
    private DatePicker startDateDatePicker;
    @FXML
    private DatePicker endDateDatePicker;

    public AddReservationViewController (ReservationViewModel reservationViewModel) {
        this.reservationViewModel = reservationViewModel;
    }

    public void cancelAction () {

    }

    public void addAction() {

    }

    public void proceedAction () {

    }


}
