package client.views.CarView;

import client.viewmodel.CarViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Reservation.Car;

import javax.swing.text.TableView;

public class CarViewController {
  @FXML
  public Button openReservationViewButton;
  @FXML
  public Button addButton;
  @FXML
  public Button deleteButton;
  @FXML
  public Button editButton;
  @FXML
  public Label usernameLabel;

  private CarViewModel carViewModel;
  private Car car;
  private TableView tableView;

  /**
   * Method to run when opening the client GUI
   */
  public void init(CarViewModel carVM)
  {
    this.carViewModel = carViewModel;
    usernameLabel.textProperty().bindBidirectional(carViewModel.usernameProperty);

//    TableColumn<Car, String> makeColumn = new TableColumn<>("Make");
//    makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
//
//    TableColumn<Car, String> modelColumn = new TableColumn<>("Model");
//    modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
//
//    TableColumn<Car, String> plateNumbersColumn = new TableColumn<>("Plate numbers");
//    plateNumbersColumn.setCellValueFactory(new PropertyValueFactory<>("plateNumbers"));
//
//    TableColumn<Car, String> fuelTypeColumn = new TableColumn<>("Fuel type");
//    fuelTypeColumn.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
//
//    TableColumn<Car, String> fuelConsumptionColumn = new TableColumn<>("Fuel consumption");
//    fuelConsumptionColumn.setCellValueFactory(new PropertyValueFactory<>("fuelConsumption"));
//
//    TableColumn<Car, String> seatsColumn = new TableColumn<>("Seats");
//    seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
//
//    TableColumn<Car, String> engineColumn = new TableColumn<>("Engine");
//    engineColumn.setCellValueFactory(new PropertyValueFactory<>("engine"));
//
//    TableColumn<Car, String> transmissionColumn = new TableColumn<>("Transmission");
//    transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));
//
//    TableColumn<Car, String> equipmentColumn = new TableColumn<>("Equipment");
//    equipmentColumn.setCellValueFactory(new PropertyValueFactory<>("equipment"));
//
//    TableColumn<Car, String> descriptionColumn = new TableColumn<>("Description");
//    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
//
//    tableView = new TableView();
//
//    tableView.setItems(getCars());
//    tableView.getColumns().addAll(makeColumn, modelColumn, plateNumbersColumn, fuelTypeColumn, fuelConsumptionColumn, seatsColumn, engineColumn, transmissionColumn, equipmentColumn, descriptionColumn);

  }



  public void openReservationView(ActionEvent actionEvent) {
    System.out.println("Reservation window opened");
  }

  public void openAddView(ActionEvent actionEvent) {
//    carViewModel.addCarView(car);
  }

  public void openDeleteView(ActionEvent actionEvent) {
    carViewModel.deleteCarView(car);
  }

  public void openEditView(ActionEvent actionEvent) {
//    carViewModel.openEditCarView(car);
  }
}
