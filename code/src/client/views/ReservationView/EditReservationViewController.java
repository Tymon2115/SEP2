package client.views.ReservationView;

import client.viewmodel.AddEditReservationViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class EditReservationViewController {

    private AddEditReservationViewModel addEditReservationViewModel;

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
    @FXML
    private Label messageLabel;

    public void init (AddEditReservationViewModel addEditReservationViewModel) {
        this.addEditReservationViewModel = addEditReservationViewModel;
        nameTextField.textProperty().bindBidirectional(addEditReservationViewModel.nameProperty());
        surnameTextField.textProperty().bindBidirectional(addEditReservationViewModel.surnameProperty());
        driversLicenceTextField.textProperty().bindBidirectional(addEditReservationViewModel.surnameProperty());
        streetTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressStreetProperty());
        cityTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressCityProperty());
        zipTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressZipProperty());
        countryTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressCountryProperty());
        priceTextField.textProperty().bindBidirectional(addEditReservationViewModel.priceProperty());
        emailTextField.textProperty().bindBidirectional(addEditReservationViewModel.emailProperty());
        phoneNumberTextField.textProperty().bindBidirectional(addEditReservationViewModel.phoneNumberProperty());
        carComboBox.valueProperty().bindBidirectional(addEditReservationViewModel.phoneNumberProperty());
        startBranchComboBox.valueProperty().bindBidirectional(addEditReservationViewModel.startBranchProperty());
        endBranchComboBox.valueProperty().bindBidirectional(addEditReservationViewModel.endBranchProperty());
        startDateDatePicker.valueProperty().bindBidirectional(addEditReservationViewModel.startDateProperty());
        endDateDatePicker.valueProperty().bindBidirectional(addEditReservationViewModel.endDateProperty());

        //TODO add loading data from chosen reservation
    }

    public void cancelAction () {
        addEditReservationViewModel.cancelAction();
    }

    public void editAction() {
        addEditReservationViewModel.editAction();
    }



}
