//package client.views.ReservationView;
//
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.control.Button;
//import javafx.scene.control.SplitPane;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import shared.Reservation.Reservation;
//import shared.Reservation.Reservations;
//
//import java.io.IOException;
//
//public class ReservationViewController {
//
//  public Button openBranchViewButton;
//  public Button openEmployeeViewButton;
//  public Button openCarViewButton;
//  public Button editButton;
//  public Button deleteButton;
//  public Button addButton;
//  public TableView tableView;
//  public SplitPane rootPane;
//
//  private ReservationViewModel reservationViewModel;
//  private Reservations reservationsClass;
//
//  public void init(ReservationViewModel reservationViewModel) {
//    this.reservationViewModel = reservationViewModel;
//    initColumns();
//
//
//  }
//
//  private void initColumns() {
//    TableColumn<Reservation, String> nameColumn = new TableColumn<>("Name");
//    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Reservation, String> surnameColumn = new TableColumn<>("Surname");
//    surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
//
//    TableColumn<Reservation, String> driversLicenseColumn = new TableColumn<>("Driver's License No.");
//    driversLicenseColumn.setCellValueFactory(new PropertyValueFactory<>("driversLicence"));
//
//    TableColumn<Reservation, String> addressColumn = new TableColumn<>("Address");
//    addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
//
//    TableColumn<Reservation, String> creditCardColumn = new TableColumn<>("Credit Card No.");
//    creditCardColumn.setCellValueFactory(new PropertyValueFactory<>("creditCardNumber"));
//
//    TableColumn<Reservation, String> carColumn = new TableColumn<>("Car");
//    carColumn.setCellValueFactory(new PropertyValueFactory<>("car"));
//
//    TableColumn<Reservation, String> branchColumn = new TableColumn<>("Branch");
//    branchColumn.setCellValueFactory(new PropertyValueFactory<>("branch"));
//
//    TableColumn<Reservation, String> dateColumn = new TableColumn<>("Date");
//    dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//    tableView = new TableView();
//    tableView.setItems(getReservations());
//    tableView.getColumns().addAll(nameColumn, surnameColumn, driversLicenseColumn, addressColumn, creditCardColumn, carColumn, branchColumn, dateColumn);
//  }
//
//  private ObservableList<Reservation> getReservations() {
//    return FXCollections.observableArrayList(reservationsClass.getReservations());
//  }
//  public void openBranchView(ActionEvent actionEvent) throws IOException {
//    SplitPane pane  = FXMLLoader.load(getClass().getResource("../BranchView/BranchView.fxml"));
//    rootPane.getChildrenUnmodifiable().setAll(pane);
//  }
//
//  public void openAddView(ActionEvent actionEvent) {
//
//  }
//
//  public void openDeleteView(ActionEvent actionEvent) {
//
//  }
//
//  public void openEditView(ActionEvent actionEvent) {
//
//  }
//
//  public void openCarView(ActionEvent actionEvent) {
//
//  }
//
//  public void openEmployeeView(ActionEvent actionEvent) {
//
//  }
//}
