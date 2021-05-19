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

    public void createEmployee(String name, String surname, int role_id, Branch branch, String username, String password, String email) throws AlreadyExists {
        try {
            Statement statement1 = connection.createStatement();


            ResultSet result = statement1.executeQuery("SELECT * FROM employee WHERE name = '" + name + "' AND surname = '" + surname + "' AND role_id = '" + role_id + "' AND branch_id =  '" + branch.getId() + "' AND username = '" + username + "' AND email = '" + email + "');");

            if (result.next()) {
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate("INSERT INTO employee (name, surname, role_id, branch_id, username, password, email) " +
                        "VALUES ('" + name + "', '" + surname + "', " + role_id + ", " + branch.getId() + ", '" + username + "', '" +
                        password + "','" + email + "');");
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
            String email = null;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                branch = branchHandler.getBranch(result.getInt("branch_id"));
                username = result.getString("username");
                password = result.getString("password");
                roleId = result.getInt("role_id");
                email = result.getString("email");
            }
            statement.close();
            result.close();
            Employee employee = new Employee(id, name, surname, roleId, branch, username, password, email);
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
                String email = result.getString("email");
                employees.add(new Employee(id, name, surname, roleId, branch, username, password, email));
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return employees;
        }
    }

    public void editEmployee(int id, String name, String surname, int role_id, Branch branch, String username, String password, String email) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE employee SET name = '" + name + "', surname = '" + surname + "', role_id = " + role_id + "', branch_id = '" + branch.getId() + "', username = '" + username + "', password = '" + password + "', email = '" + email + "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }
    public void deleteEmployee(int id){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM employee where id = '" + id + "';" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Login (String username, String password) {
        Statement statement = connection.createStatement();

    }

}

