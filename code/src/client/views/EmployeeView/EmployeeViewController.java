package client.views.EmployeeView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.personel.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeViewController implements Initializable {

  @FXML
  private Button editButton;
  @FXML
  private  Button deleteButton;
  @FXML
  private  Button addButton;
  @FXML
  private Button backButton;

  @FXML
  private TableView<Employee> employee_tableview;
  @FXML
  private TableColumn<Employee, Integer> column_id;
  @FXML
  private TableColumn<Employee, String> column_name;
  @FXML
  private TableColumn<Employee, String> column_surname;
  @FXML
  private TableColumn<Employee, String> column_branch;
  @FXML
  private TableColumn column_username;
  @FXML
  private TableColumn column_role;
  @FXML
  private TableColumn column_email;


  public void openAddView(ActionEvent actionEvent) {

  }

  public void openDeleteView(ActionEvent actionEvent) {

  }

  public void openEditView(ActionEvent actionEvent) {

  }

  public void back(ActionEvent actionEvent) {

  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
