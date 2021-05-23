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
    private TableColumn<Car, Number> column_id;
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
    private TableColumn<Car, Number> column_branch;
    @FXML
    private TableColumn<Car, Number> column_dailyprice;


    public void back(ActionEvent actionEvent) {
        carViewModel.home();
    }


    public void init(CarViewModel carViewModel) {

        this.carViewModel = carViewModel;
        column_branch.setCellValueFactory(cellData -> (cellData.getValue().branchIdProperty()));
        column_dailyprice.setCellValueFactory(cellData -> (cellData.getValue().dailyPriceProperty()));
        column_description.setCellValueFactory(cellData -> (cellData.getValue().descriptionProperty()));
        column_engine.setCellValueFactory(cellData -> (cellData.getValue().engineProperty()));
        column_equipment.setCellValueFactory(cellData -> (cellData.getValue().equipmentProperty()));
        column_fuelconsumption.setCellValueFactory(cellData -> (cellData.getValue().fuelConsumptionProperty()));
        column_fueltype.setCellValueFactory(cellData -> (cellData.getValue().fuelTypeProperty()));
        column_id.setCellValueFactory(cellData -> (cellData.getValue().idProperty()));
        column_make.setCellValueFactory(cellData -> (cellData.getValue().makeProperty()));
        column_model.setCellValueFactory(cellData -> (cellData.getValue().modelProperty()));
        column_numberplates.setCellValueFactory(cellData -> (cellData.getValue().numberPlatesProperty()));
        column_seats.setCellValueFactory(cellData -> (cellData.getValue().seatsProperty()));
        column_transmission.setCellValueFactory(cellData -> (cellData.getValue().transmissionProperty()));
        tableview_car.setItems(carViewModel.getCars());
    }

    public void openDeleteView(javafx.event.ActionEvent actionEvent) {
    }

    public void openAddView(javafx.event.ActionEvent actionEvent) {
        carViewModel.addCar();
    }

    public void back(javafx.event.ActionEvent actionEvent) {
        carViewModel.home();
    }

    public void openEditView(javafx.event.ActionEvent actionEvent) {
    }
}
