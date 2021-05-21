package client.views.ReservationView;


import client.viewmodel.ReservationViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Reservation.Car;
import shared.Reservation.Reservation;


import java.io.IOException;

public class ReservationViewController {
    @FXML
    private Button homeButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation, Integer> idCol;
    @FXML
    private TableColumn<Reservation, String> nameCol;
    @FXML
    private TableColumn<Reservation, String> surnameCol;
    @FXML
    private TableColumn<Reservation, String> driversLicenceCol;
    @FXML
    private TableColumn<Reservation, String> addressCol;
    @FXML
    private TableColumn<Reservation, String> carCol;
    @FXML
    private TableColumn<Reservation, String> startBranchCol;
    @FXML
    private TableColumn<Reservation, String> endBranchCol;
    @FXML
    private TableColumn<Reservation, String> startDateCol;
    @FXML
    private TableColumn<Reservation, String> endDateCol;
    @FXML
    private TableColumn<Reservation, String> priceCol;
    @FXML
    private TableColumn<Reservation, String> emailCol;
    @FXML
    private TableColumn<Reservation, String> phoneNumberCol;
    ReservationViewModel reservationViewModel;

    public void init(ReservationViewModel reservationViewModel)  {
        this.reservationViewModel = reservationViewModel;
    }



    public void onDeleteButton(ActionEvent actionEvent) {

    }

    public void onEditButton(ActionEvent actionEvent) {

    }

    public void onAddButton(ActionEvent actionEvent) {

    }
    public void home(ActionEvent actionEvent){
        reservationViewModel.home();
    }

}
