package client.views.EmployeeView;


import client.viewmodel.EmployeeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.personel.Employee;


public class EmployeeViewController {

    private EmployeeViewModel employeeViewModel;

    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button backButton;

    @FXML
    private TableView<Employee> employee_tableview;
    @FXML
    private TableColumn<Employee, Number> column_id;
    @FXML
    private TableColumn<Employee, String> column_name;
    @FXML
    private TableColumn<Employee, String> column_surname;
    @FXML
    private TableColumn<Employee, String> column_branch;
    @FXML
    private TableColumn<Employee, String> column_username;
    @FXML
    private TableColumn<Employee, Number> column_role;
    @FXML
    private TableColumn<Employee, String> column_email;

    public void init(EmployeeViewModel employeeViewModel) {
        employee_tableview.getItems().clear();
        this.employeeViewModel = employeeViewModel;
        column_id.setCellValueFactory(cellData -> (cellData.getValue().idProperty()));
        column_name.setCellValueFactory(cellData -> (cellData.getValue().nameProperty()));
        column_branch.setCellValueFactory(cellData -> (cellData.getValue().branchProperty()));
        column_surname.setCellValueFactory(cellData -> (cellData.getValue().surnameProperty()));
        column_email.setCellValueFactory(cellData -> (cellData.getValue().emailProperty()));
        column_username.setCellValueFactory(cellData -> (cellData.getValue().surnameProperty()));
        column_role.setCellValueFactory(cellData -> (cellData.getValue().roleProperty()));
        employee_tableview.setItems(employeeViewModel.getEmployees());
    }


    public void openAddView(ActionEvent actionEvent) {

    }

    public void openDeleteView(ActionEvent actionEvent) {

    }

    public void openEditView(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) {
        employeeViewModel.home();
    }

}
