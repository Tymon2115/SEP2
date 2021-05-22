package client.views.CarView;//package client.views.CarView;
import client.core.ViewHandler;
import client.viewmodel.CarViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import shared.Reservation.Car;
import shared.personel.Employee;

import javax.swing.text.TableView;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class CarViewController implements Initializable {
  @FXML
  private TableView tableview_employee;
  @FXML
  private TableColumn<Employee, Integer> column_id;
  @FXML
  private TableColumn<Employee, String> column_make;
  @FXML
  private TableColumn<Employee, String> column_model;
  @FXML
  public Label usernameLabel;
  private ViewHandler viewHandler;
  private CarViewModel viewModel;

  private CarViewModel carViewModel;
  private Car car;
  private TableView tableView;

  public CarViewController (CarViewModel carViewModel) {
    this.carViewModel = carViewModel;
  }


  public void openReservationView(ActionEvent actionEvent) {
    System.out.println("Reservation window opened");
  }

  public void openAddView(ActionEvent actionEvent) {

  }

  public void openDeleteView(ActionEvent actionEvent) {

  }

  public void openEditView(ActionEvent actionEvent) {

  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
