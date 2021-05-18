package server.database;

import client.exceptions.AlreadyExists;
import shared.Branches.Branch;
import shared.Reservation.Cars;
import shared.Reservation.Reservations;
import shared.personel.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeHandler {
    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private BranchHandler branchHandler = new BranchHandler();

    public void createEmployee(String name, String surname, int role_id, Branch branch, String username, String password) throws AlreadyExists {
        try {
            Statement statement1 = connection.createStatement();

            //TODO finish statement
            ResultSet result = statement1.executeQuery("SELECT");

            if (result.next()) {
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate("INSERT INTO employee (name, surname, role_id, branch_id, username, password) " +
                        "VALUES ('" + name + "', '" + surname + "', " + role_id + ", " + branch.getId() + ", '" + username + "', '" +
                        password + "');");
                statement1.close();
                statement2.close();
            } else {
                statement1.close();
                throw new AlreadyExists("This object already exists in the database");
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    public Employee getEmployee(int searchId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employee WHERE id = '" + searchId + "' ; ");
            String name = null;
            String surname = null;
            int id = 0;
            Branch branch = null;
            String username = null;
            String password = null;
            int roleId = 0;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                branch = branchHandler.getBranch(result.getInt("branch_id"));
                username = result.getString("username");
                password = result.getString("password");
                roleId = result.getInt("role_id");
            }
            statement.close();
            result.close();
            Employee employee = new Employee(id, name, surname, roleId, branch, username, password);
            return employee;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employee");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int roleId = result.getInt("role_id");
                Branch branch = branchHandler.getBranch(result.getInt("branch_id"));
                String username = result.getString("username");
                String password = result.getString("password");
                employees.add(new Employee(id, name, surname, roleId, branch, username, password));
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return employees;
        }
    }

    public void editEmployee(int id, String name, String location, Reservations reservations, Cars cars) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("");
            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

}

