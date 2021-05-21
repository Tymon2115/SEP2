package client.views.CarView;

import client.viewmodel.CarViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.Reservation.Car;
import java.awt.event.ActionEvent;


public class CarViewController {


    private CarViewModel carViewModel;

    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button editButton;
    @FXML
    private Button backButton;


    @FXML
    private TableView<Car> tableview_car;
    @FXML
    private TableColumn<Car, Integer> column_id;
    @FXML
    private TableColumn<Car, String> column_make;
    @FXML
    private TableColumn<Car, String> column_model;
    @FXML
    private TableColumn<Car, String> column_numberplates;
    @FXML
    private TableColumn<Car, String> column_fueltype;
    @FXML
    private TableColumn<Car, String> column_fuelconsumption;
    @FXML
    private TableColumn<Car, String> column_seats;
    @FXML
    private TableColumn<Car, String> column_engine;
    @FXML
    private TableColumn<Car, String> column_transmission;
    @FXML
    private TableColumn<Car, String> column_equipment;
    @FXML
    private TableColumn<Car, String> column_description;
    @FXML
    private TableColumn<Car, String> column_branch;
    @FXML
    private TableColumn<Car, String> column_dailyprice;



    public void back(ActionEvent actionEvent) {
        carViewModel.home();
    }


    public void init(CarViewModel carViewModel) {
        this.carViewModel = carViewModel;
    }

    public void openDeleteView(javafx.event.ActionEvent actionEvent) {
    }

    public void openAddView(javafx.event.ActionEvent actionEvent) {
    }

    public void back(javafx.event.ActionEvent actionEvent) {
        carViewModel.home();
    }

    public void openEditView(javafx.event.ActionEvent actionEvent) {
    }
}
