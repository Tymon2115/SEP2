package server.database;

import shared.Branches.Branch;
import shared.Reservation.Cars;
import shared.Reservation.Reservations;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BranchHandler {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();


    public void createBranch(String name, String location) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO \"sep\".branch (name, location) VALUES ('" + name + "','" + location + "');");
            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    public Branch getBranch(int searchId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM branch WHERE id = '" + searchId + "' ; ");
            int id = 0;
            String name = null;
            String location = null;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                location = result.getString("location");
            }
            statement.close();
            result.close();
            Branch branch = new Branch(id, name, location);
            return branch;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }

    public ArrayList<Branch> getBranch() {
//        try {
//            Statement statement = databaseConnection.createStatement();
//            ResultSet result = statement.executeQuery("SELECT * FROM 'branch'");
//            Arraylist<Branch> branches = new ArrayList<>();
//            while (result.next()) {
//
//            }
//            return null;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return null;
    }

//    public void editBranch(int id, String name, String location, Employees employees, Reservations reservations, Cars cars, Manager manager) {
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("");
//            statement.close();
//        } catch (SQLException throwables) {
//
//            throwables.printStackTrace();
//
//        }
//    }

}
